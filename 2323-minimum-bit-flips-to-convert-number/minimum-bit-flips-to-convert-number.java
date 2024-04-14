class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int cnt = 0;
        for(int i = 0 ; i < 32 ; i++){ // Corrected loop condition
            if( (ans & (1 << i)) != 0){ // Also, added comparison with zero to check if the bit is set
                cnt++;
            }
        }

        return cnt;
    }
}