class Solution {
  public int findDuplicate(int[] nums) {
    int[] cnt = new int[nums.length + 1];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > 1) {
                return num;
            }
        }
        return nums.length;
  }
}