class Solution {
    public int getIndex(ArrayReader reader) {
        int length = reader.length();
        int l = 0, r = length - 1; 
        while (l < r) { 
            int mid = (l + r) / 2;
            int res; 
            int count = r - l + 1; 
            if (count % 2 == 0) {
                res = reader.compareSub(l, mid, mid+1, r); 
            } else { 
                mid--; 
                res = reader.compareSub(l, mid, mid+1, r-1); 
                if (res == 0) return r; 
            }
            if (res == 1) r = mid; 
            else if (res == -1) l = mid + 1; 
        }
        return l;
    }
}
