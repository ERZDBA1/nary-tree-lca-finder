import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A utility class for finding the Lowest Common Ancestor (LCA) or the Lowest Dominating Common Ancestors (LDCAs)
 * for a set of nodes in an n-ary tree.
 * <br><br>
 *
 * Note: This algorithm assumes each node has only one parent. It does not support nodes with multiple parents
 * or handle cases with cycles in the tree.
 */
public class NaryTreeLCAFinder {
    /**
     * Flag to enable or disable debug output.
     * If set to true, the algorithm will print debug information during execution.
     */
    private static boolean isDebug = true;

    /**
     * Finds the Lowest Common Ancestor (LCA) for a given set of nodes in the n-ary tree.
     *
     * @param root  the root of the n-ary tree
     * @param nodes a set of nodes for which the LCA needs to be found
     * @return the LCA of the given nodes, or null if the root is null,
     *         the set is empty, or contains only null values
     * @throws NullPointerException if the set of nodes is null
     */
    public static TreeNode findLCA(TreeNode root, Set<TreeNode> nodes) {
        return findLCAHelper(root, nodes, null);
    }

    /**
     * Finds the Lowest Dominating Common Ancestors (LDCAs) for a given set of nodes in the n-ary tree.
     *
     * @param root  the root of the n-ary tree
     * @param nodes a set of nodes for which the LDCAs need to be found
     * @return a set of nodes representing the LDCAs, or an empty set if the root is null,
     *         the set is empty, or contains only null values
     * @throws NullPointerException if the set of nodes is null
     */
    public static Set<TreeNode> findLDCAs(TreeNode root, Set<TreeNode> nodes) {
        Set<TreeNode> ldcas = new LinkedHashSet<>();
        findLCAHelper(root, nodes, ldcas);
        return ldcas;
    }

    /**
     * Helper method that assists in finding either the LCA or the LDCAs of the given set of nodes.
     *
     * @param root  the current root node being processed
     * @param nodes the set of nodes for which the LCA or LDCAs need to be found
     * @param ldcas a set to store the LDCAs if found, or null if finding only the LCA
     * @return the LCA of the given nodes, or if no common ancestor exists,
     *         or null if the root is null, the set is empty, contains only null values
     * @throws NullPointerException if the set of nodes is null
     */
    private static TreeNode findLCAHelper(TreeNode root, Set<TreeNode> nodes, Set<TreeNode> ldcas) {
        if (root == null) return null;

        if (nodes.contains(root)) {
            if (ldcas != null) {
                if (isDebug)
                    System.out.printf("(Node %s) Adding node %s to LDCAs.%n", root, root);
                ldcas.add(root);
            }

            return root;
        }

        int count = 0;
        TreeNode temp = null;

        for (TreeNode child : root.getChildren()) {
            if (isDebug)
                System.out.printf("(Node %s) Expanding node %s -> Child: %s%n", root, root, child);

            TreeNode res = findLCAHelper(child, nodes, ldcas);
            if (isDebug)
                System.out.printf("(Node %s) Child %s returned LCA: %s%n", root, child, res != null ? res : "null");

            if (res != null) {
                count++;
                if (count == 1) {
                    temp = res;
                    if (isDebug)
                        System.out.printf("(Node %s) Setting node %s temp to %s%n", root, root, temp);
                }
            }

            if (isDebug)
                System.out.printf("(Node %s) Status - Temp: %s; Count: %d%n", root, temp != null ? temp : "null", count);
        }

        return count > 1 ? root : temp;
    }
}
