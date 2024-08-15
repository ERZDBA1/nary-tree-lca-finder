import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Create the tree structure
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        root.getChildren().add(node2);
        root.getChildren().add(node3);
        root.getChildren().add(node4);
        node2.getChildren().add(node5);
        node2.getChildren().add(node6);
        node2.getChildren().add(node7);
        node3.getChildren().add(node8);
        node4.getChildren().add(node9);
        node7.getChildren().add(node10);

        /*
                 1
               / | \
              2  3  4
             /|\  |  \
            5 6 7 8   9
                |
                10
         */
        Set<TreeNode> nodesToFind = new LinkedHashSet<>();
        nodesToFind.add(node2);
        nodesToFind.add(node5);
        nodesToFind.add(node10);
        nodesToFind.add(node9);
        nodesToFind.add(null);

        // Test LCA
        TreeNode lca = NaryTreeLCAFinder.findLCA(root, nodesToFind);
        System.out.println();

        // Test LCDA
        Set<TreeNode> ldcas = NaryTreeLCAFinder.findLDCAs(root, nodesToFind);
        System.out.println();

        System.err.println("LCA of nodes " + nodesToFind + ": " + (lca != null ? lca : "None"));
        System.err.print("LDCAs of nodes " + nodesToFind + ": " + ldcas);
    }
}