import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a node in an n-ary tree.
 * Each node holds an integer value and a list of its children.
 */
public class TreeNode {
    private final int val;
    private final List<TreeNode> children;

    /**
     * Constructs a TreeNode with a given value.
     *
     * @param val the integer value of the node
     */
    TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    /**
     * Returns the list of children of this node.
     *
     * @return a list of the children nodes
     */
    public List<TreeNode> getChildren() {
        return children;
    }

    /**
     * Returns a string representation of the node's value.
     *
     * @return a string representing the node's value
     */
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
