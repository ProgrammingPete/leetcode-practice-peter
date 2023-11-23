package neetcode.io.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int numIslands(char[][] grid) {
        // TODO: already finished on leetcode
        return 0;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxIslandSize = 0; 
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) { // this is a start of a new island
                    maxIslandSize =  Math.max(getIslandSize(grid, rows, cols, i, j), maxIslandSize);
                }
            }
        }
        return maxIslandSize;
    }
    /*
     * 
     */
    private int getIslandSize(int[][] grid, int rows, int cols, int i, int j){
        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0)
            return 0;

        
        grid[i][j] = 0; // set this value to 0 since we have visited it. We basically destroy this part of the island

        return  (1 + 
                    getIslandSize(grid, rows, cols, i - 1, j) + 
                    getIslandSize(grid, rows, cols, i + 1, j) +
                    getIslandSize(grid, rows, cols, i, j - 1) +
                    getIslandSize(grid, rows, cols, i, j + 1)
            );
    }

    class Coordinate {
        int row = 0; 
        int col = 0;
        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString(){
            return "[" + row + "," + col + "]";
        }
        @Override
        public boolean equals(Object o) {
            if(o == this)
                return true;
            if(!(o instanceof Coordinate))
                return false;
            Coordinate other = (Coordinate)o;
            return (other.col == this.col && other.row == this.row);
        }
        @Override
        public final int hashCode(){
            return 31 * this.row * this.col;
        }
    } 

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        Queue<Coordinate> queue = new LinkedList<>(); // older coordinates to be visited
        Set<Coordinate> visited = new HashSet<>(); // holds coordinates we already visited
        int rows = grid.length;
        int cols = grid[0].length;
        int shortestPath = Integer.MAX_VALUE;

        //add the first item to the queue
        Coordinate first = new Coordinate(0, 0);
        queue.add(first);
        visited.add(first);

        int path = 1;
        boolean pathfound = false;
        while(!queue.isEmpty()) {
            int snapshotSize = queue.size();
            for(int i = 0; i < snapshotSize; i++) { // this is so we can keep track of the level (path length)
                Coordinate curr = queue.poll();
                if(curr.row == rows - 1 && curr.col == cols - 1) {
                    shortestPath = Math.min(shortestPath, path);
                    pathfound = true;
                }
                //we need to check every neighbor and every diagonal neighbor to see if it matches the criteria
                Coordinate[] neighbors = new Coordinate[] {
                    new Coordinate(curr.row, curr.col - 1), //left
                    new Coordinate(curr.row, curr.col + 1), // right
                    new Coordinate(curr.row - 1, curr.col), // up
                    new Coordinate(curr.row + 1, curr.col), // down
                    new Coordinate(curr.row - 1, curr.col - 1), // leftup
                    new Coordinate(curr.row + 1, curr.col - 1), // leftdown
                    new Coordinate(curr.row - 1, curr.col + 1), // rightup
                    new Coordinate(curr.row + 1, curr.col + 1) // rightdown
                };
                for(Coordinate neighbor : neighbors) {
                    if(neighbor.col < 0 || neighbor.row < 0 || neighbor.col == cols || neighbor.row == rows ||
                        visited.contains(neighbor) || grid[neighbor.row][neighbor.col] == 1) {
                            // skip this neighbor
                    } else {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            path++;
        }
        if(pathfound) {
            return shortestPath;
        } else {
            return -1;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, Map<Integer, Node> map) {
        if(node == null) return null;
        if(map.containsKey(node.val)) return map.get(node.val);
        Node deepCopy = new Node(node.val);
        map.put(node.val, deepCopy);
        for(Node neighbor : node.neighbors) {
            deepCopy.neighbors.add(dfs(neighbor, map));
        }
        return deepCopy;
    }
}
