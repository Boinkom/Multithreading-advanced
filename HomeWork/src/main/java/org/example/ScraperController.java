package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/scrape")
public class ScraperController {

    private final ScraperService scraperService;

    public ScraperController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @PostMapping
    public List<ScrapeResult> scrapeUrls(@RequestBody List<String> urls) {
        List<Future<ScrapeResult>> futures = scraperService.scrapeUrls(urls);
        List<ScrapeResult> results = new ArrayList<>();
        for (Future<ScrapeResult> future : futures) {
            try {
                results.add(future.get()); // Дождаться завершения задачи и получить результат
            } catch (InterruptedException | ExecutionException e) {
                results.add(new ScrapeResult("Error", "Error", e.getMessage()));
            }
        }
        return results;
    }

    @GetMapping("/shutdown")
    public String shutdown() {
        scraperService.shutdown();
        return "Scraper service is shutting down.";
    }
}
