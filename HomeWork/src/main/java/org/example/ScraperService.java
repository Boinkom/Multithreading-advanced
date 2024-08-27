package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class ScraperService {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // Пул на 10 потоков

    public List<Future<ScrapeResult>> scrapeUrls(List<String> urls) {
        List<Future<ScrapeResult>> futures = new ArrayList<>();

        for (String url : urls) {
            Callable<ScrapeResult> task = () -> {
                try {
                    Document doc = Jsoup.connect(url).get();
                    String title = doc.title();
                    String description = doc.select("meta[name=description]").attr("content");
                    return new ScrapeResult(url, title, description);
                } catch (Exception e) {
                    return new ScrapeResult(url, "Error", e.getMessage());
                }
            };
            futures.add(executorService.submit(task));
        }
        return futures;
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
