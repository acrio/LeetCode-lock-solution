class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int counter = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char cRight = s.charAt(right);
            map.put(cRight, map.getOrDefault(cEnd, 0) + 1); 

            while (map.size() > 2) {
                char cLeft = s.charAt(left);
                map.put(cLeft, map.get(cLeft) - 1);
                map.remove(cLeft, 0);
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
