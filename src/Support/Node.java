package Support;

import java.util.List;

public class Node {

    public int val;
    public List<Node> neighbours;

    public Node() {}

    public Node(int _val, List<Node> _neighbours) {
        val = _val;
        neighbours = _neighbours;
    }
}
