/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithmsproject;

/**
 *
 * @author pojan
 */
public class Edge {
    public Node dest; //destination node
    public int weight; //edge weight
    
    
    public Edge(Node m, int w){
        dest = m;
        weight = w;
    }
}
