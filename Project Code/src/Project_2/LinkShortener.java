import java.util.*;

public class LinkShortener {

    private Map<String, String> urlMap = new HashMap<>();
    private static final String BASE_URL = "http://short.ly/";

    public String shortenURL(String originalURL) {
        String shortURL = BASE_URL + generateHash(originalURL);
        if (!urlMap.containsKey(shortURL)) {
            urlMap.put(shortURL, originalURL);
        } else {
            int counter = 1;
            while (urlMap.containsKey(shortURL + counter)) {
                counter++;
            }
            shortURL = shortURL + counter;
            urlMap.put(shortURL, originalURL);
        }
        return shortURL;
    }

    public String expandURL(String shortURL) {
        return urlMap.get(shortURL);
    }

    private String generateHash(String url) {
        return Integer.toHexString(url.hashCode());
    }

}
