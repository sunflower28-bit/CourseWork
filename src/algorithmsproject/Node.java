/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsproject;
import java.util.*;

/**
 *
 * @author pojan
 */
public class Node {
    public String name;
    public List<Edge> adj;
    public int dist;
    public Node prev;
    public boolean seen;
    
    public Node(String _name){
        this.name = _name;
        adj = new LinkedList<Edge>();
        reset();
    }

    
    public void reset(){
        dist = Integer.MAX_VALUE;
        prev = null;
        seen = false;
       
    }
}
