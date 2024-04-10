class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        long result = 0; // Use long to avoid integer overflow

        // Arrays to store previous and next smaller elements
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        // Initialize arrays with default values
        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, n);

        // Stack to store indices
        Stack<Integer> stack = new Stack<>();

        // Fill nextSmaller array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        // Clear the stack for re-use
        stack.clear();

        // Fill prevSmaller array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                prevSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        // Calculate the sum
        for (int i = 0; i < n; i++) {
            long countLeft = i - prevSmaller[i];
            long countRight = nextSmaller[i] - i;
            result = (result + (countLeft * countRight * arr[i]) % MOD) % MOD;
        }

        return (int) result;
    }
}