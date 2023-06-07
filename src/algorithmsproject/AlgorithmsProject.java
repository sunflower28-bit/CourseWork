/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithmsproject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author pojan
 */
public class AlgorithmsProject {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        File myf = new File("C:\\Users\\pojan\\Documents\\NetBeansProjects\\AlgorithmsProject\\src\\algorithmsproject\\file1.txt"); //make file excesible to get all the information
        Scanner reader = new Scanner(myf); //create reader so we can manipulate the information
        int n, e; // variables to store number of nodes and edges
        String[] temp; //temp string to put numbers from lines
        
        
        Graph g = new Graph();
        
        
        //first line
        temp = reader.nextLine().split(" ");
        n = Integer.parseInt(temp[0]);
        e = Integer.parseInt(temp[1]);
         
        //checking constrains
        if(n<1 || n>100000 || e<1 || e>10000){
            System.out.println("Number of edges or nodes is not within the assignments constrains");
            System.exit(1);
        }
        
        //name of indexes
        String[] names = new String[e];//creating name holder for array
        String us = reader.nextLine();
       
       if("use-indexes".equals(us)){
           
        for(int i = 0; i<n;i++){
            //in case there are no String names
            
                names[i]= String.valueOf(i);
                g.getNode(String.valueOf(i));
        }
       }else{
           names = us.split(" ");
           for(int i = 0; i<n;i++){

                g.getNode(names[i]);
  
        }
       }
        
        
        
        //get startting index
        temp = null;
        temp = reader.nextLine().split(" ");
        int startingNodeIdx = Integer.parseInt(temp[0]);
         
        
        
        
        
        for (int i = 0; i < e;i++) { //taking each line
        String data = reader.nextLine();
        //saving into array
        
        
        for(int j = 0; j<3; j++){
            temp = data.split(" ");
            
            //checking constrainsts
        if(Integer.parseInt(temp[2])<0){
            System.out.println("Negative weights are not within the assignments constrains");
            System.exit(1);
        }//end if
            
        g.addEdge(names[Integer.parseInt(temp[0])], names[Integer.parseInt(temp[1])], Integer.parseInt(temp[2]));    //adding edges to graph
        }//end inside for
   
       
      }//end for
     
        

        g.dfs(names[startingNodeIdx], names, n);
        
        
        
        reader.close(); 
    }catch(FileNotFoundException  e){
        System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    
        
        
    
        
    }
   
  
    
}

