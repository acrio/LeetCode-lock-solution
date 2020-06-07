class Solution {
    Map<Character, Character> parent = new HashMap<>();

    public String smallestEquivalentString(String A, String B, String S) {
        for(int i = 0; i<A.length(); i++){
            char a = A.charAt(i);
            char b = B.charAt(i);

            if(find(a) != find(b)){
                union(a, b);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<S.length(); i++){
            char anc = find(S.charAt(i));
            sb.append(anc);
        }

        return sb.toString();
    }

    private char find(char c){
        parent.putIfAbsent(c, c);
        if(c != parent.get(c)){
            char anc = find(parent.get(c));
            parent.put(c, anc);
        }

        return parent.get(c);
    }

    private void union(char a, char b){
        char c1 = find(a);
        char c2 = find(b);
        if(c1 < c2){
            parent.put(c2, c1);
        }else{
            parent.put(c1, c2);
        }
    }
}
