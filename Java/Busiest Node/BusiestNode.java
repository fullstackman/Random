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
    //instantiate this class before its methods can be used
    BusiestNode mainObj = new BusiestNode();
    Node root = mainObj.buildTree(args[0]);
    /*System.out.printf("The root is a node with value %d and %d children.\n",
      root.value,root.children.length);*/
    Node busiestNode = null;
    busiestNode = mainObj.findBusiestNode(root);
  }

  private class Node{
    int value;
    Node[] children;

    public Node(int givenValue){
      this.value = givenValue;
      this.children = null;
    }

    public Node(int givenValue, int givenChildren){
      this.value = givenValue;
      this.children = new Node[givenChildren];
      //hardcode their initial state, just to be safe
      for(int i=0; i<givenChildren; ++i){
        this.children[i] = null;
      }
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

  private Node buildTree(String inputFile){
    //System.out.printf("You gave this file name: %s\n",inputFile);
    Node rootNode = null;
    Scanner sc1 = null;
    
    try{
      sc1 = new Scanner(new BufferedReader(new FileReader(inputFile)));
      int rootValue = sc1.nextInt();
      sc1.next();
      int rootChildren = sc1.nextInt();

      rootNode = new Node(rootValue, rootChildren);
      ArrayList<Ancestor> ancestors = new ArrayList<Ancestor>();
      Node currentNode = rootNode;
      int currentIndex = -1;
      
      while (currentNode != null){
        /*for(int z = -2; z < currentIndex; ++z){
          System.out.printf("\t");
        }
        System.out.printf("Current node: %d\twith %d children.\tCurrent Index: %d\n"
          ,currentNode.value,currentNode.children.length,currentIndex);*/
        if(currentNode.children.length < 1){
          currentNode = ancestors.get(currentIndex).itself;
          continue;
        }
        //If we don't have any ancestors yet or the current node is not the same as
        //the current ancestor, then we add this node to the list of ancestry.
        if ( ancestors.size() < 1 ||
          !ancestors.get(currentIndex).itself.equals(currentNode)
          ){
          /*System.out.printf("Creating new ancestor: %d with %d children.\n",
            currentNode.value,
            currentNode.children.length);*/
          Ancestor temp = new Ancestor(currentNode);
          ancestors.add(temp);
          sc1.next();
          int tempValue = sc1.nextInt();
          sc1.next();
          int tempChildren = sc1.nextInt();
          currentNode.children[temp.currentChild] = new Node(tempValue, tempChildren);
          currentNode = currentNode.children[temp.currentChild];
          ++currentIndex;
          continue;
        }
        //save the pointer to the current ancestor node for easy reference
        Ancestor temp = ancestors.get(currentIndex);
        //mark that a child was just processed successfully!
        temp.currentChild += 1;

        if (temp.currentChild < currentNode.children.length){
          sc1.next();
          int tempValue = sc1.nextInt();
          sc1.next();
          int tempChildren = sc1.nextInt();
          currentNode.children[temp.currentChild] = new Node(tempValue, tempChildren);
          currentNode = currentNode.children[temp.currentChild];
          continue;
        }
        /*for(int z = -1; z < currentIndex; ++z){
          System.out.printf("\t");
        }
        System.out.printf("Done processing node %d with %d children!\n",
          currentNode.value,currentNode.children.length);*/
        //at this point, we've visited all of this ancestors children
        //time to return to its ancestor
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
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    finally{
      if(sc1 != null)
        sc1.close();
    }
    System.out.println("Successfully set up the tree!");
    return rootNode;
  }

  private Node findBusiestNode(Node president){
    Node busiestNode = null;
    double busiestAvg = -1;
    ArrayList<Ancestor> ancestors = new ArrayList<Ancestor>();
    Node currentNode = president;
    int currentIndex = -1;

    while (currentNode != null){
      if(currentNode.children.length < 1){
        //add value to ancestors and increment their descendant counts.
        for(int k=0; k<ancestors.size();++k){
          ancestors.get(k).totalValue += currentNode.value;
        }
        currentNode = ancestors.get(currentIndex).itself;
        continue;
      }
      if ( ancestors.size() < 1 ||
          !ancestors.get(currentIndex).itself.equals(currentNode)
      ){
        Ancestor temp = new Ancestor(currentNode);
        ancestors.add(temp);
        currentNode = currentNode.children[0];
        ++currentIndex;
        continue;
      }

      //save the pointer to the current ancestor node for easy reference
      Ancestor temp = ancestors.get(currentIndex);
      //mark that a child was just processed successfully!
      temp.currentChild += 1;

      if (temp.currentChild < currentNode.children.length){
        currentNode = currentNode.children[temp.currentChild];
        continue;
      }
      // add value to ancestors and increment their descendant counts.
      temp.descendants += currentNode.children.length;
      for(int w=0; w<currentIndex; ++w){
        ancestors.get(w).totalValue += temp.totalValue;
        ancestors.get(w).descendants += temp.descendants;
      }
      //compute average and see if this qualifies as busiest Node
      double nodeAvg = (double) temp.totalValue / (double) temp.descendants;
      if(nodeAvg > busiestAvg){
        busiestAvg = nodeAvg;
        busiestNode = currentNode;
      }
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
    System.out.printf(
      "The busiest node has the value of %d with %d children and an average of %f.\n",
      busiestNode.value,busiestNode.children.length,busiestAvg);
    return busiestNode;
  }
}