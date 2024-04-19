import java.util.*;

public class Solution {
    // Method to calculate the number of distinct prime factors in an array of integers
    public int distinctPrimeFactors(int[] nums) {
        // Set to store unique prime factors
        Set<Integer> primeFactors = new HashSet<>();
        
        // Iterate through each number in the array
        for (int num : nums) {
            // Factorize num into its prime factors
            int i = 2; // Starting from 2 because 1 is not a prime number
            while (num > 1) {
                // Check if i is a factor of num
                if (num % i == 0) {
                    // Add the prime factor to the set
                    primeFactors.add(i);
                    // Divide num by i to remove this prime factor and continue factorizing
                    num /= i;
                } else {
                    // If i is not a factor, increment i to check the next number
                    i++;
                }
            }
        }
        // Return the size of the set, which represents the count of distinct prime factors
        return primeFactors.size();
    }
}
