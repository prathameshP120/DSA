import java.util.*;
import java.util.Scanner;

public class PortionBrewing {
    // Map to store recipes for each potion
    private static Map<String, List<List<String>>> recipes = new HashMap<>();
    // Memoization map to store the minimum orbs for each potion
    private static Map<String, Integer> memo = new HashMap<>();

    // Recursive function to calculate the minimum orbs required for a potion
    public static int minOrbsToBrew(String target) {
        // If the potion's cost is already calculated, return it
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        // If the target is a raw ingredient, it costs 0 orbs
        if (!recipes.containsKey(target)) {
            return 0;
        }

        int minOrbs = Integer.MAX_VALUE;

        // Iterate through all recipes of the target potion
        for (List<String> recipe : recipes.get(target)) {
            int orbs = recipe.size() - 1; // Orbs needed for this recipe
            for (String ingredient : recipe) {
                orbs += minOrbsToBrew(ingredient); // Add the cost of brewing each ingredient
            }
            minOrbs = Math.min(minOrbs, orbs); // Track the minimum orbs
        }

        memo.put(target, minOrbs); // Memoize the result
        return minOrbs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of recipes
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Parse the recipes
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("="); // Split the potion and ingredients
            String potion = parts[0]; // Potion name
            String[] ingredients = parts[1].split("\\+"); // Ingredients list

            recipes.putIfAbsent(potion, new ArrayList<>());
            recipes.get(potion).add(Arrays.asList(ingredients));
        }

        // Target potion to brew
        String target = sc.nextLine();

        // Calculate and print the minimum orbs needed to brew the target potion
        System.out.println(minOrbsToBrew(target));
    }
}
