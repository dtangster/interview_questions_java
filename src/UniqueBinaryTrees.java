import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTrees {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> trees = new ArrayList<TreeNode>();

        _generateTrees(n, trees, null);
        return trees;
    }

    private static  void _generateTrees(int n, List<TreeNode> trees, TreeNode currentLeaf) {
        if (n == 0) {
            trees.add(currentLeaf);
            return;
        }
        if (currentLeaf == null && n == 1) {
            trees.add(new TreeNode(1));
            return;
        }

        TreeNode parentWithLeftLeaf = new TreeNode(n);
        TreeNode parentWithRightLeaf = new TreeNode(n);

        if (currentLeaf != null) {
            TreeNode copyCurrentLeaf = new TreeNode(currentLeaf.val);
            parentWithLeftLeaf.left = currentLeaf;
            parentWithRightLeaf.right = copyCurrentLeaf;
        }

        _generateTrees(n - 1, trees, parentWithLeftLeaf);
        _generateTrees(n - 1, trees, parentWithRightLeaf);

        return;
    }

    public static void main(String [] args) {
        List<TreeNode> trees = generateTrees(2);

        System.out.println(trees);
    }
}