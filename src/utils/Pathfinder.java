package utils;

import java.util.ArrayList;
import java.util.List;

public class Pathfinder{
  
    public boolean pathExists(Cell[][] map, int xi, int yi, int xo, int yo) {

    	
    	List<Node> queue = new ArrayList<Node>();
        queue.add(new Node(xi,yi));

        boolean pathExists = false;
        int cpt = 0;
        while(!queue.isEmpty()) {
        	
        	System.out.print("Node "+cpt++);
        	System.out.print(" ["+ queue.get(0).x);
        	System.out.println(","+queue.get(0).y+"]");
        	
            Node current = queue.remove(0);
            
            if(current.x == xo && current.y == yo) {
                pathExists = true;
                break;
            }
            
            map[current.x][current.y] = Cell.WLL; // mark as visited
            
            List<Node> neighbors = getNeighbors(map, current);
            queue.addAll(neighbors);
        }
        
        return pathExists;
    }
    
   public static List<Node> getNeighbors(Cell[][] map, Node node) {
        List<Node> neighbors = new ArrayList<Node>();
        
        if(isValidPoint(map, node.x - 1, node.y)) {
            neighbors.add(new Node(node.x - 1, node.y));
        }
        
        if(isValidPoint(map, node.x + 1, node.y)) {
            neighbors.add(new Node(node.x + 1, node.y));
        }
        
        if(isValidPoint(map, node.x, node.y - 1)) {
            neighbors.add(new Node(node.x, node.y - 1));
        }
        
        if(isValidPoint(map, node.x, node.y + 1)) {
            neighbors.add(new Node(node.x, node.y + 1));
        }
        
        return neighbors;
    }
    
    public static boolean isValidPoint(Cell[][] map, int x, int y) {
        return !(x < 0 || x >= map.length || y < 0 || y >= map.length) && (map[x][y] != Cell.WLL);
    }
}

class Node{
    int x;
    int y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

