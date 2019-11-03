package Learn.QueueAndStack.Stack.DFS;

import Support.Node;
import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {

        HashMap<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, HashMap<Integer, Node> map) {

        if (node == null)
            return null;

        if (map.containsKey(node.val))
            return map.get(node.val);

        else {

            Node clone = new Node(node.val,new ArrayList<>());
            map.put(clone.val, clone);

            for (Node neighbour : node.neighbours)
                clone.neighbours.add(dfs(neighbour, map));

            return clone;
        }
    }
}
