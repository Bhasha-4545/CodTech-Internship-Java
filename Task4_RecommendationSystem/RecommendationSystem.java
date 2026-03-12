import java.util.*;

public class RecommendationSystem {

    static Map<String, Map<String, Integer>> userRatings = new HashMap<>();

    public static void main(String[] args) {

        // Sample user ratings
        addRating("User1", "Laptop", 5);
        addRating("User1", "Phone", 4);

        addRating("User2", "Laptop", 4);
        addRating("User2", "Tablet", 5);

        addRating("User3", "Phone", 5);
        addRating("User3", "Tablet", 4);

        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Product Recommendation System ====");
        System.out.print("Enter your username: ");
        String user = scanner.nextLine();

        recommendProducts(user);
    }

    static void addRating(String user, String product, int rating) {
        userRatings.putIfAbsent(user, new HashMap<>());
        userRatings.get(user).put(product, rating);
    }

    static void recommendProducts(String user) {

        if (!userRatings.containsKey(user)) {
            System.out.println("User not found in system.");
            return;
        }

        Map<String, Integer> targetRatings = userRatings.get(user);
        Map<String, Integer> recommendationScores = new HashMap<>();

        for (String otherUser : userRatings.keySet()) {

            if (!otherUser.equals(user)) {

                Map<String, Integer> otherRatings = userRatings.get(otherUser);

                for (String product : otherRatings.keySet()) {

                    if (!targetRatings.containsKey(product)) {
                        recommendationScores.put(
                            product,
                            recommendationScores.getOrDefault(product, 0) + otherRatings.get(product)
                        );
                    }
                }
            }
        }

        if (recommendationScores.isEmpty()) {
            System.out.println("No recommendations available.");
        } else {

            System.out.println("\nRecommended Products:");

            recommendationScores
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .forEach(entry ->
                            System.out.println(entry.getKey() + " (Score: " + entry.getValue() + ")"));
        }
    }
}