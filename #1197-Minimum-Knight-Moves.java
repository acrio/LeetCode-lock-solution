class Solution {
    int[] directX = new int[]{1, 1,-1,-1,2,2,-2,-2};
    int[] directY = new int[]{2,-2,2,-2,1,-1,1,-1};

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        Queue<Point> q = new LinkedList<>();
        Map<Point, Integer> map = new HashMap<>();
        map.put(source, 0); // remember
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.offer(source);
        visited[source.x][source.y] = true; // use hashSet is wrong.
        while(!q.isEmpty()) {
            Point p = q.poll();
            if(p.x == destination.x && p.y == destination.y)
                return map.get(p);
            for(Point neighbor : getNeighbors(p)) {
                if(!isValid(grid, neighbor) || visited[neighbor.x][neighbor.y])
                    continue;
                q.offer(neighbor);
                visited[neighbor.x][neighbor.y] = true;
                map.put(neighbor, map.get(p) + 1);
            }
        }

        return -1;
    }

    List<Point> getNeighbors(Point point) {
        List<Point> result = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            result.add(new Point(point.x + directX[i], point.y + directY[i]));
        }
        return result;
    }

    boolean isValid(boolean[][] grid, Point point) {
        if(point.x >= 0 && point.x < grid.length && point.y >= 0 && point.y < grid[0].length 
                && !grid[point.x][point.y])
            return true;
        else return false;
    }
}
