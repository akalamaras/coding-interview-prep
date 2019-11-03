package Support;

public class MultiLevelNode {

    public int val;
    public MultiLevelNode prev;
    public MultiLevelNode next;
    public MultiLevelNode child;

    public MultiLevelNode() {}

    public MultiLevelNode(int _val, MultiLevelNode _prev, MultiLevelNode _next, MultiLevelNode _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
