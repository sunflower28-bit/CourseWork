/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsproject;

import java.util.HashMap;
import java.util.*;

/**
 *
 * @author pojan
 */
public class Graph {
    public Map<String,Node> nodeMap = new HashMap<String,Node>();

    
    
    
    /*
    Add Node to the Map, if it's not there
    @return n vertex added
    */
    public Node getNode(String nodeName){
        Node n = nodeMap.get(nodeName);
        if(n == null){
            n = new Node(nodeName);
            nodeMap.put(nodeName, n);
        }
        return n;
    }
    /**
     * Add new edge to graph
     * @param sourceName
     * @param destName
     * @param weight 
     */
    public void addEdge(String sourceName, String destName, int weight){
        Node n = getNode(sourceName);
        Node d = getNode(destName);
        n.adj.add(new Edge(d, weight));
    
}
    /*
    Print shortest path 
    */

    private void printPath(Node destination) {
    if (destination == null) {
        return; // Base case: Terminate recursion when dest is null
    }
    
    //print all shortest paths to each node from the starting node
    printPath(destination.prev);
    System.out.print(" -> ");
    System.out.print(destination.name);
}
    public void printAllPaths(String[] names){
        for(String i : names){
            printPath(getNode(i));
            System.out.println();
        }
    }

    
    
    public void dijkstra(String startName){
PriorityQueue<Path> pq = new PriorityQueue<>();
Node start = nodeMap.get(startName);
pq.add(new Path(start, 0));
start.dist = 0;
while(!pq.isEmpty()){
    Path path = pq.remove();
    Node n = path.dest;
    
    
    for(Edge e:n.adj){
        Node u = e.dest;
        int wgt = e.weight;
        if(u.dist > n.dist + wgt){
            u.dist = n.dist + wgt;
            u.prev = n;
            pq.add(new Path(u, u.dist));
        }
    }
}
}//end dijkstra
    
    public void dfs(String startName, String[] names, int num_n){
        System.out.println("Print shortest paths:");
Stack<Path> st = new Stack<Path>();
Node start = nodeMap.get(startName);
st.add(new Path(start, 0));
start.dist = 0;
int seen_count = 0; //use it so we don't backtract unecesarry edges in DAGs
while(!st.isEmpty()){
    Path path = st.pop();
    
    Node n = path.dest;
    n.seen = true;
    seen_count ++;
    
    for(Edge e:n.adj){
        Node u = e.dest;
        if(u.seen == false || seen_count <= num_n){
        int wgt = e.weight;
        if(u.dist > n.dist + wgt){
            u.dist = n.dist + wgt;
            u.prev = n;
            st.add(new Path(u, u.dist));
             }}
        else{
            System.out.println("Dijkstra in use:");
            dijkstra(startName);
            printAllPaths(names);
            
            System.exit(0);
        }
    }
}
printAllPaths(names);
}//end dfs
    

    
    
}//end class Graph
