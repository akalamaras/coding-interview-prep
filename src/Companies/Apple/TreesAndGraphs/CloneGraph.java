package Companies.Apple.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {

    public Node cloneGraph(Node node) {

        HashMap<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, HashMap<Integer, Node> map) {

        if(node == null)
            return null;

        if(map.containsKey(node.val))
            return map.get(node.val);
        else {

            Node clone = new Node(node.val, new ArrayList<>());
            map.put(clone.val, clone);

            for(Node neighbor: node.neighbors)
                clone.neighbors.add(dfs(neighbor, map));

            return clone;
        }


    }
}
