class Solution {
    Node *pf = NULL, *qf = NULL;
    bool qisSubOfp = false;
    bool foundp = false;
    bool foundq = false;
public:
    Node* moveSubTree(Node* root, Node* p, Node* q) {
        for(auto node : q->children)
            if(node == p)
                return root;
        Node* empty = new Node(-1);
        empty->children.push_back(root);
        dfs(empty, NULL, p, q);
        if(!qisSubOfp)
        {
            auto it = find(pf->children.begin(),pf->children.end(),p);
            pf->children.erase(it);
            q->children.push_back(p);
            return root;
        }
        
        auto it = find(qf->children.begin(),qf->children.end(),q);
        qf->children.erase(it);
        it = find(pf->children.begin(),pf->children.end(),p);
        
        it = pf->children.erase(it);
        q->children.push_back(p);
        pf->children.insert(it, q);
        return empty->children[0];
    }

    void dfs(Node* root, Node* fa, Node* p, Node* q)
    {
        if(!root) return;
        if(root == p)
        {
            pf = fa;
            foundp = true;
        }
        if(root == q)
        {
            if(foundp)
                qisSubOfp = true;
            qf = fa;
            foundq = true;
        }
        for(auto c : root->children)
            dfs(c, root, p, q);
        if(root == p)
            foundp = false;
        if(root == q)
            foundq = false;
    }   
};
