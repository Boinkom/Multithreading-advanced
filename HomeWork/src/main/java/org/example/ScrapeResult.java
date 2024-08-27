package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScrapeResult {
    private String url;
    private String title;
    private String description;
}
