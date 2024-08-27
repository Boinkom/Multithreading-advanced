Web Scraper API
Overview
This service provides a simple API for scraping web pages. It allows you to send URLs to be scraped and retrieve the titles and descriptions of the pages. Additionally, you can shut down the service using a specific endpoint.

API Endpoints
1. Scrape URLs
Endpoint: POST /scrape

Description: Send a list of URLs to be scraped. The service will return the titles and descriptions of the pages.

Request:

Method: POST
URL: http://localhost:8080/scrape
Headers:
Content-Type: application/json
Body:
["https://example.com", "https://example.org"]
Response:

Content-Type: application/json
Body:
[
  {
    "url": "https://example.com",
    "title": "Example Domain",
    "description": "Example domain"
  },
  {
    "url": "https://example.org",
    "title": "Example Domain",
    "description": "Example domain"
  }
]
2. Shutdown Service
Endpoint: GET /scrape/shutdown

Description: Shuts down the web scraper service.

Request:

Method: GET
URL: http://localhost:8080/scrape/shutdown
Example Usage
To scrape URLs, you can use the curl command:

sh

curl -X POST http://localhost:8080/scrape -H "Content-Type: application/json" -d '["https://example.com", "https://example.org"]'
To shut down the service, use:

sh
curl -X GET http://localhost:8080/scrape/shutdown


