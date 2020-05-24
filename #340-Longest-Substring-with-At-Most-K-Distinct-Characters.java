class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        
        for (int right = 0; right < s.length(); right++) {
            int count = map.getOrDefault(s.charAt(right), 0);
            map.put(s.charAt(right), count + 1);
            
            while (map.size() > k) {
                char c = s.charAt(left);
                map.put(left, map.get(left) - 1);
                map.remove(c, 0);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
