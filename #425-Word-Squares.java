public class Solution {
    class TrieNode {
            public TrieNode[] link;
            public List<String> startWith;
            public TrieNode() {
                link = new TrieNode[26];
                startWith = new ArrayList<>();
            }
        }
        
    class Trie {
        public TrieNode root;
        
        public Trie(String[] words) {
            root = new TrieNode();
            
            for (String w : words) {
                TrieNode curr = root;
                for (char c : w.toCharArray()) {
                    if (curr.link[c - 'a'] == null) {
                        curr.link[c - 'a'] = new TrieNode();
                    }
                    curr = curr.link[c - 'a'];
                    curr.startWith.add(w);
                }
            }
        }
        
        public List<String> searchPrefix(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.link[c - 'a'] == null) {
                    return new ArrayList<String>();
                }
                curr = curr.link[c - 'a'];
            }
            return new ArrayList<String>(curr.startWith);
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        Trie trie = new Trie(words);
        List<String> list = new ArrayList<>();
        for (String w : words) {
            list.add(w);
            helper(trie, result, list);
            list.remove(list.size() - 1);
        }
        return result;
    }
    
    public void helper(Trie trie, List<List<String>> result, List<String> list) {
        if (list.size() == list.get(0).length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        int index = list.size();
        StringBuilder prefix = new StringBuilder();
        for (String s : list) {
            prefix.append(s.charAt(index));
        }
        List<String> startWith = trie.searchPrefix(prefix.toString());
        for (String w : startWith) {
            list.add(w);
            helper(trie, result, list);
            list.remove(list.size() - 1);
        }
    }
}
