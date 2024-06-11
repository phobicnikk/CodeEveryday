class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freqMp = new TreeMap<>();
        for(var num : arr1){
            freqMp.put(num, freqMp.getOrDefault(num, 0) + 1);
        }
        int indx = 0;
        for(var num : arr2){
            int freq = freqMp.get(num);
            while(freq-->0){
                arr1[indx++] = num;
            }
            freqMp.put(num, 0);
        }
        for(var entry : freqMp.entrySet()){
            var num = entry.getKey();
            var freq = entry.getValue();
            while(freq-->0){
                arr1[indx++] = num;
            }
        }
        return arr1;
    }
}