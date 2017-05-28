import java.util.ArrayList;

public class BusiestNode{
  
  public static void main(String[] args){
    //read in a file and build the tree
    System.out.println("Not ready yet. . .");
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