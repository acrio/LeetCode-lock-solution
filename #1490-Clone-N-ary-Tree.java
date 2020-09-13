class Solution {
    public Node cloneTree(Node root) {
        if (root == null) return null; 
        Node node = new Node(); 
        node.val = root.val; 
        List<Node> children = new ArrayList<>(); 
        for (Node c : root.children){  
            children.add(cloneTree(c));
        }

        node.children = children;
        return node;
    }
}
