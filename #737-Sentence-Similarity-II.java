class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length!=words2.length) return false;
        Map<String, String> map = new HashMap<>();
        for(String[] pair : pairs){
            String parent0 = find(pair[0], map);
            String parent1 = find(pair[1], map);
            if(!parent0.equals(parent1)) map.put(parent0, parent1);
        }
        int n = words1.length;
        for(int i=0; i<n; i++){
            if (!words1[i].equals(words2[i]) && !find(words1[i], map).equals(find(words2[i], map))) return false;
        }
        return true;
    }
    
    private String find(String word, Map<String, String> map){
        if(!map.containsKey(word)) return word;
        String str = word;
        while(map.containsKey(str)){
            str = map.get(str);
        }
        map.put(word, str);
        return str;
    }
}
