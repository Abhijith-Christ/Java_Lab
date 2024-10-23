import java.util.*;

public class FrequencyAnalysis {

    // Static variable to store the input array
    private static int[] arr;

    // Static method to find the top K numbers based on their frequency
    public static void findTopKNumbers(int K) {
        // Step 1: Create a HashMap to store frequencies of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count frequencies of each number in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list from the elements in the map
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(frequencyMap.entrySet());

        // Step 3: Sort the list based on custom comparator
        freqList.sort((a, b) -> {
            // First compare by frequency in descending order
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            // If frequencies are equal, compare by the number itself in descending order
            return b.getKey() - a.getKey();
        });

        // Step 4: Output the top K elements
        System.out.print("Top " + K + " numbers: ");
        for (int i = 0; i < K; i++) {
            System.out.print(freqList.get(i).getKey() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept the size of the array from the user
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        // Initialize the array with size n
        arr = new int[n];

        // Accept the elements of the array from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Accept the value of K from the user
        System.out.println("Enter the value of K:");
        int K = scanner.nextInt();

        // Check if K is valid (K should not be greater than the size of the array)
        if (K > n) {
            System.out.println("K cannot be greater than the size of the array.");
        } else {
            // Call the method to find the top K numbers
            findTopKNumbers(K);
        }

        scanner.close();
}
}
