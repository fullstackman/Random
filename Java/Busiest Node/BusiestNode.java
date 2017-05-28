public class BusiestNode{
  
  public static void main(String[] args){
    //read in a file and build the tree
    System.out.println("Not ready yet. . .");
  }

  private class Node{
    int value;
    Node[] children;

    public Node(givenValue){
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
    int total value;
    int descendants;
    int current child;

    public Ancestor(Node original){
      this.itself = original;
      total value = original dot value;
      descendants = 1;
      current child = 0;
    }
  }

  private Node findBusiestNode(Node president){
    Node busiest Node = null;
    Arraylist<Ancestor> ancestors = new Arraylist <Ancestor>();
    Node current node = president;
    int current index = -1;

    While (current Node not null){
      If (current node dot children < 1){
        //add value to ancestors and increment their descendant counts.
        current node = ancestors dot get (current index);
        continue;
      }
      if (! ancestors dot get (current index).equals (current node) ){
        Ancestor temp = Ancestor (current node);
        ancestors dot add (temp);
        ++current index;
        current node = current node dot children[0];
        continue;
      }
      if (ancestors dot get (current index) dot current child < current node dot children dot length){
        current node = current node dot children[ ancestors dot get (current index) dot current child];
        continue;
      }
        // add value to ancestors and increment their descendant counts.
        //compute average and see if this qualifies as busiest Node
        --current index;
      try {
        current node = ancestors dot get(current index);
      }
      catch{
        current node = null;
      }
      finally {
        continue;
      }
    }

    return busiest node;
  }
}