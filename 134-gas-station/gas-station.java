class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        int deficit = 0; 
        int balance = 0;
        int start = 0;

        for(int i = 0; i < n; i++) {
            balance += gas[i] - cost[i]; 
            if(balance < 0) {
                deficit += balance;
                start = i + 1;
                balance = 0;
            }
        }
        if(balance + deficit >= 0) 
            return start;
        return -1;
    }
}
