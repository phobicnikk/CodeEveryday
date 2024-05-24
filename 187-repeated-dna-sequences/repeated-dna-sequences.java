class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		if(s == null || s.length() < 10) {
			return Collections.emptyList();
		}
		int start = 0;
		int end = 10;
		Set<String> set = new HashSet<>();
		Set<String> result = new HashSet<>();
		StringBuilder builder = new StringBuilder(s);
		while(end <= s.length()) {            
			//String curr = s.substring(start,end);   
			//builder is faster, so using builder below
			String curr = builder.substring(start,end);   
			if(set.contains(curr)) {
				result.add(curr);
			}
			set.add(curr);
			start++;
			end++;
		}
		return new ArrayList<>(result);
	}
}