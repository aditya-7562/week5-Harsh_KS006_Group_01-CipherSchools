import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class class53 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        scanner.nextLine(); // Consume newline

        List<String> results = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // Size of ArrayList arr
            scanner.nextLine(); // Consume newline
            String elements = scanner.nextLine().trim(); // Elements to be inserted in the ArrayList

            List<Integer> arr = new ArrayList<>();
            for (char c : elements.toCharArray()) {
                arr.add(c - '0'); // Convert character to integer and add to ArrayList
            }

            List<Integer> result = thePendulum(n, arr);
            results.add(listToString(result));
        }

        // Print all results
        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    public static List<Integer> thePendulum(int n, List<Integer> arr) {
        // Sort the list of integers
        Collections.sort(arr);

        // Initialize the result list
        List<Integer> result = new ArrayList<>(n);

        // Alternate inserting elements from sorted array
        // First, insert the middle element if n is odd
        int mid = (n - 1) / 2;
        result.add(arr.get(mid));

        // Insert remaining elements in pendulum motion
        int left = mid - 1;
        int right = mid + 1;
        boolean insertToLeft = true;

        while (left >= 0 || right < n) {
            if (insertToLeft && left >= 0) {
                result.add(arr.get(left));
                left--;
            } else if (!insertToLeft && right < n) {
                result.add(arr.get(right));
                right++;
            }
            insertToLeft = !insertToLeft;
        }

        // Return the result list
        return result;
    }

    public static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num);
        }
        return sb.toString();
    }
}
