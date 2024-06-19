import java.util.*;

public class LinkShortenerCLI {

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Link Shortener");
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the URL to shorten: ");
                    String originalURL = scanner.nextLine();
                    String shortURL = linkShortener.shortenURL(originalURL);
                    System.out.println("Shortened URL: " + shortURL);
                    break;
                case 2:
                    System.out.print("Enter the short URL to expand: ");
                    String shortURLToExpand = scanner.nextLine();
                    String expandedURL = linkShortener.expandURL(shortURLToExpand);
                    if (expandedURL != null) {
                        System.out.println("Original URL: " + expandedURL);
                    } else {
                        System.out.println("Short URL not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
