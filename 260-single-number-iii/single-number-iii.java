class Solution {
    public int[] singleNumber(int[] nums) {
        int sum=0,n=nums.length;
        for(int i=0;i<n;i++)
            sum^=nums[i];
        //Bitwise & sum and it's 2's complement, to find it's rightmost set-bit(1) (Example: 0010)
        
        sum=(sum & -sum); //rightmost-set-bit.
        int sum1=0,sum2=0;
        //dividing the array into two groups on the basis of the rightmost-set-bit being either 0 or 1.
        
        for(int i=0;i<n;i++){
            if((nums[i] & sum) > 0){ //If rightmost set bit of(arr[i] & sum) is 1.
                sum1^=nums[i];
            }
            else{                   //If rightmost set bit of(arr[i] & sum) is 0.
                sum2^=nums[i];
            }
        }
        return (new int[]{sum1,sum2});
    }
}