import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class BusiestNode{
  
  public static void main(String[] args){
    System.out.println("Not ready yet. . .");
    //read in a file and build the tree
    if(args.length < 1){
      System.out.println("ERROR: No input file given!");
      return;
    }
    Node root = buildTree(args[0]);
  }

  private class Node{
    int value;
    Node[] children;

    public Node(int givenValue){
      this.value = givenValue;
      this.children = null;
    }

    /* to be completed.
    private addChild(){
      ;
    }
    */
  }

  private class Ancestor {
    Node itself;
    int totalValue;
    int descendants;
    int currentChild;

    public Ancestor(Node original){
      this.itself = original;
      totalValue = original.value;
      descendants = 1;
      currentChild = 0;
    }
  }

  private static Node buildTree(String inputFile){
    Node rootNode = null;

    //System.out.printf("You gave this file name: %s\n",inputFile);

    Scanner sc1 = null;
    
    try{
      sc1 = new Scanner(new BufferedReader(new FileReader(inputFile)));
      
      while(sc1.hasNextLine()){
        System.out.println(sc1.nextLine());
      }
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    finally{
      if(sc1 != null)
        sc1.close();
    }
    /*
    ArrayList<Ancestor> ancestors = new ArrayList<Ancestor>();
    Node currentNode = president;
    int currentIndex = -1;

    while (currentNode != null){
      if(currentNode.children.length < 1){
        //add value to ancestors and increment their descendant counts.
        currentNode = ancestors.get(currentIndex).itself;
        continue;
      }
      if (! ancestors.get(currentIndex).equals(currentNode) ){
        Ancestor temp = new Ancestor(currentNode);
        ancestors.add(temp);
        ++currentIndex;
        currentNode = currentNode.children[0];
        continue;
      }
      if (ancestors.get (currentIndex).currentChild < currentNode.children.length){
        currentNode = currentNode.children[ancestors.get(currentIndex).currentChild];
        continue;
      }
        // add value to ancestors and increment their descendant counts.
        //compute average and see if this qualifies as busiest Node
        --currentIndex;
      try {
        currentNode = ancestors.get(currentIndex).itself;
      }
      catch(Exception e){
        currentNode = null;
      }
      finally {
        continue;
      }
    }
    */
    return rootNode;
  }

  private Node findBusiestNode(Node president){
    Node busiestNode = null;
    ArrayList<Ancestor> ancestors = new ArrayList<Ancestor>();
    Node currentNode = president;
    int currentIndex = -1;

    while (currentNode != null){
      if(currentNode.children.length < 1){
        //add value to ancestors and increment their descendant counts.
        currentNode = ancestors.get(currentIndex).itself;
        continue;
      }
      if (! ancestors.get(currentIndex).equals(currentNode) ){
        Ancestor temp = new Ancestor(currentNode);
        ancestors.add(temp);
        ++currentIndex;
        currentNode = currentNode.children[0];
        continue;
      }
      if (ancestors.get (currentIndex).currentChild < currentNode.children.length){
        currentNode = currentNode.children[ancestors.get(currentIndex).currentChild];
        continue;
      }
        // add value to ancestors and increment their descendant counts.
        //compute average and see if this qualifies as busiest Node
        --currentIndex;
      try {
        currentNode = ancestors.get(currentIndex).itself;
      }
      catch(Exception e){
        currentNode = null;
      }
      finally {
        continue;
      }
    }

    return busiestNode;
  }
}