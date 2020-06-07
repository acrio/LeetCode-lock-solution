class Solution {
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2]-b[2]);

        int res = 0;
        UnionFind uf = new UnionFind(N);
        for(int [] connect : connections){
            if(uf.find(connect[0]) != uf.find(connect[1])){
                uf.union(connect[0], connect[1]);
                res += connect[2];
            }

            if(uf.count == 1){
                return res;
            }
        }

        return -1;
    }
}

class UnionFind{
    int [] parent;
    int [] size;
    int count;

    public UnionFind(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        this.count = n;
    }

    public int find(int i){
        if(i != parent[i]){
            parent[i] = find(parent[i]);
        }

        return parent[i];
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        
        if (pRoot == qRoot) return;
        if(size[pRoot] < size[qRoot]){
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }else{
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }

        this.count--;
    }
}
