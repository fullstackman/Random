/** Problem Statement:
  * Detect a cycle in a linked list. Note that the head pointer may be 'null'
  * if the list is empty.

  * A Node is defined as: 
  * class Node {
  *     int data;
  *     Node next;
  * }
*/

boolean hasCycle(Node head) {
    //base case
    if(head == null)
        return false;

    //use a list runner algortihm
    Node runner = head;
    Node walker = head;
    //keep track of how many nodes the runner will skip through during each movement
    int speed = 2;
    while(runner != null){
        //first send the runner ahead and check the next few nodes
        for(int i = 0; i< speed; ++i){
            runner = runner.next;
            if(runner == null)
                return false;
            if(walker == runner)
                return true;
        }
        //then move the walker forward to see if it has caught up with the runner
        walker = walker.next;
        if(walker == runner)
            return true;
        //tell the runner to skip through more nodes in the next loop
        ++speed;
    }
    //if we have reached the end of the loop, then the list terminates without a loop
    return false;
}