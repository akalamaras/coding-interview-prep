package Companies.Cisco.FirstGo;

import Support.RandomNode;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    /*
        // Definition for a RandomNode.
        class RandomNode {
            public int val;
            public RandomNode next;
            public RandomNode random;

            public RandomNode() {}

            public RandomNode(int _val,RandomNode _next,RandomNode _random) {
                val = _val;
                next = _next;
                random = _random;
            }
        };
    */


    /**
     * A linked list is given such that each node contains an additional pointer which could
     * point to any node in the list or null
     * Return a DEEP copy of the list
     *
     * Example:
     *
     *  Input: {"$id":"1","next":{
     *              "$id":"2","next":null,"random":
     *                  {"$ref":"2"},"val":2},"random":
     *                       {"$ref":"2"},"val":1}
     *  Explanation: RandomNode 1's value is 1, both its next and random pointer point to RandomNode 2.
     *               RandomNode 2's value is 2, its next pointer points to null and its random
     *                pointer points to itself.
     *
     *  Note: You must return the copy of the given head as a reference to the cloned list
     */

    // Solution info https://leetcode.com/problems/copy-list-with-random-pointer/solution/


    // Approach #1 Recursive (Accepted, O(n) time complexity, O(n) space complexity)

    /*
     *  Time Complexity O(n) where n is the number of nodes in the linked list.
     *  Space Complexity O(n) because of the recursion stack and the HashMap.
     *
     */

    /*
     *  The basic idea is to consider the linked list ike a graph. Every node on the linked list
     *  has 2 pointers. Since random pointers add the randomness to the structure we might visit
     *  the same node twice leading to cycles.
     *
     *  All we do in this approach is just traverse the graph and clone it. Cloning essentially
     *  means creating a new node for every unseen node we encounter. The traversal path will
     *  happen recursively in a depth first manner. Note that we have to keep track of nodes
     *  already processed to avoid cycles because of the random pointers.
     */

    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<RandomNode, RandomNode> visitedHash = new HashMap<RandomNode, RandomNode>();


    public RandomNode copyRandomList(RandomNode head) {

        if(head == null)
            return null;

        // If we have already processed the current randomNode, then we simply return the
        // cloned version of it.
        if(this.visitedHash.containsKey(head))
            return this.visitedHash.get(head);

        // Create a new randomNode with the value same as the old one (i.e. copy the randomNode)
        RandomNode randomNode = new RandomNode(head.val,null,null);

        // Save this value in the HashMap. This is needed since there might be loops
        // during traversal due to the randomness of the pointers and this will help
        // us avoid them.
        this.visitedHash.put(head, randomNode);

        // Recursively copy the remaining linked list starting once from the next pointer
        // and then from the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new randomNode we created
        randomNode.next = this.copyRandomList(head.next);
        randomNode.random = this.copyRandomList(head.random);

        return randomNode;
    }



    // Approach #2 Iterative O(n) space (Accepted, O(n) time complexity, O(n) space complexity)

    /*
     * Time Complexity O(n) because we make one pass over the original LinkedList of n elements.
     * Space Complexity O(n) because of the HashMap
     */


    /*
     *  The iterative solution to this problem does not model it as a graph, instead it
     *  simply treats it as a LinkedList. When we are iterating over the list, we can create new
     *  nodes via the random pointer or the next pointer, whichever points to a node that does
     *  not exist in our old -> new dictionary
     */

    HashMap<RandomNode, RandomNode> visited = new HashMap<>();

    public RandomNode copyRandomListIterativeON(RandomNode head) {

        if(head == null)
            return null;

        RandomNode oldRandomNode = head;

        // Creating the new head node
        RandomNode newRandomNode = new RandomNode(head.val,null,null);
        this.visited.put(oldRandomNode, newRandomNode);

        // Iterate on the linked list until all nodes are cloned.
        while(oldRandomNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newRandomNode.random = this.getClonedNode(oldRandomNode.random);
            newRandomNode.next = this.getClonedNode(oldRandomNode.next);

            // Move one step ahead in the linked list
            oldRandomNode = oldRandomNode.next;
            newRandomNode = newRandomNode.next;
        }
        return this.visited.get(head);
    }

    public RandomNode getClonedNode(RandomNode randomNode) {

        // If the randomNode exists then
        if(randomNode != null) {
            // Check if the randomNode is in the dictionary/HashMap
            if(this.visited.containsKey(randomNode))
                // If it is in the dictionary then return the new randomNode reference from it
                return this.visited.get(randomNode);
            else {
                // Otherwise create a new randomNode, add it to the dictionary and return it
                this.visited.put(randomNode,new RandomNode(randomNode.val,null,null));
                return this.visited.get(randomNode);
            }
        }
        // If the randomNode is null return null
        return null;
    }

    // Approach #3 Iterative O(1) space (Accepted, O(n) time complexity, O(1) space complexity)

    /*
     * Instead of using a dictionary/HashMap to keep the old node -> new node mappings, we can
     * tweak the original linked list and keep every cloned node next to its original node.
     * This interleaving of old and new nodes allows us to solve this problem without any
     * extra space.
     */
    public RandomNode copyRandomListO1(RandomNode head) {

        if(head == null)
            return null;

        // Creating a new weaved list of the original and copied nodes
        RandomNode ptr = head;
        while(ptr != head) {

            // Cloned node
            RandomNode newRandomNode = new RandomNode(ptr.val,null,null);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original LinkedList, then after weaving
            // the cloned nodes it would be A->A'->B->B'->C->C'.
            newRandomNode.next = ptr.next;
            ptr.next = newRandomNode;

            // Update ptr
            ptr = newRandomNode.next;
        }

        ptr = head;
        // Now we have to link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers
        // to assign references to random pointers to the cloned nodes.
        while(ptr != null) {
            ptr.next.random = (ptr.random == null) ? ptr.random.next : null;
            // Jump to the next non-clone node
            ptr = ptr.next.next;
        }

        // Unweave the LinkedList to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken into A->B->C and A'->B'->C'

        RandomNode ptr_old_list = head; // A->B->C
        RandomNode ptr_new_list = head.next; // A'->B'->C'
        // Keep the head to return it as a reference to the cloned list
        RandomNode head_old = head.next;
        while (ptr_old_list != null) {

            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;

            // Move on to the next.
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;

        }
        return head_old;
    }
}
