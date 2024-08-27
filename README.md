Пример использования:
curl -X POST http://localhost:8080/scrape -H "Content-Type: application/json" -d "[\"https://example.com\", \"https://example.org\"]"
Пример ответа:
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
Остановка сервиса:
curl -X GET http://localhost:8080/scrape/shutdown


