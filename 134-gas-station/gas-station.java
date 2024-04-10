class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        int deficit = 0; // Corrected variable name
        int balance = 0;
        int start = 0;

        for(int i = 0; i < n; i++) {
            balance += gas[i] - cost[i]; // Corrected calculation of balance

            if(balance < 0) {
                deficit += balance;
                start = i + 1;
                balance = 0;
            }
        }
        if(balance + deficit >= 0) // Corrected condition for checking if a solution exists
            return start;
        return -1;
    }
}