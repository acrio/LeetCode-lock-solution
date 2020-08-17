class Solution {
    int res=0; 
    public int diameter(Node root) {
        dfs(root); 
        return res; 
    }

    int dfs(Node root){
        int max1=0; // 当前节点下距离叶子节点最长的路径
        int max2=0; // 当前节点下距离叶子节点次长的路径
        for(Node child : root.children){ // 循环每一个子节点
            // 递归查看当前子节点到叶子节点的最长路径
            // 加一为当前节点到该子节点的距离
            int length=dfs(child)+1;
            // 使用该距离更新最长路径即次长路径
            if(length>=max1){
                max2=max1;
                max1=length;
            }else if(length>=max2){
                max2=length;
            }
        }
        res=Math.max(res, max1+max2);
        return max1;
    }
}
