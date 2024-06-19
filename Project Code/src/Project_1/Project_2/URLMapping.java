public class URLMapping {

    private String originalURL;
    private String shortURL;

    public URLMapping(String originalURL, String shortURL) {
        this.originalURL = originalURL;
        this.shortURL = shortURL;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public String getShortURL() {
        return shortURL;
    }
}
