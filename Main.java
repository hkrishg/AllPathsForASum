import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class Main {

  // Problem Statement #
 // Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.

  private static List<List<Integer>> allPathsSum(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    currentPathSUm(root, sum, currentPath, allPaths);
    return allPaths;

  }

  private static void currentPathSUm(TreeNode currentNode, int sum, List<Integer> currentPath,
      List<List<Integer>> allPaths) {
    if (currentNode == null)
      return;
    // add current node to path
    currentPath.add(currentNode.val);

    //if currentnode is leaf and value is sum add to allpaths
    if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
      allPaths.add(new ArrayList<>(currentPath));
    } else {
      currentPathSUm(currentNode.left, sum - currentNode.val, currentPath, allPaths);
      currentPathSUm(currentNode.right, sum - currentNode.val, currentPath, allPaths);
    }
    //remove the current node from the path to backtrack
    currentPath.remove(currentPath.size() - 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println(Main.allPathsSum(root, 23));

  }
}