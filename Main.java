import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class Maximum {
    int max_no = Integer.MIN_VALUE;
}
class Main {
static Maximum max = new Maximum();
  // Problem Statement #
  // Given a binary tree and a number ‘S’, find all paths from root-to-leaf such
  // that the sum of all the node values of each path equals ‘S’.

  private static List<Integer> allPathsSum(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    currentPathSUm(root, sum, currentPath, allPaths);
    return allPaths.get(0);

  }

  private static void currentPathSUm(TreeNode currentNode, int sum, List<Integer> currentPath,
      List<List<Integer>> allPaths) {
    if (currentNode == null)
      return;
    // add current node to path
    currentPath.add(currentNode.val);

    // if currentnode is leaf and value is sum add to allpaths
    if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
      allPaths.add(new ArrayList<>(currentPath));
    } else {
      currentPathSUm(currentNode.left, sum - currentNode.val, currentPath, allPaths);
      currentPathSUm(currentNode.right, sum - currentNode.val, currentPath, allPaths);
    }
    // remove the current node from the path to backtrack
    currentPath.remove(currentPath.size() - 1);
  }

  // Problem 1: Given a binary tree, return all root-to-leaf paths.

  // Solution: We can follow a similar approach. We just need to remove the “check
  // for the path sum”.

  private static List<List<Integer>> allPaths(TreeNode root) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    currentPath(root, currentPath, allPaths);
    return allPaths;

  }

  private static void currentPath(TreeNode currentNode, List<Integer> currentPath,
      List<List<Integer>> allPaths) {
    if (currentNode == null)
      return;
    // add current node to path
    currentPath.add(currentNode.val);

    // if currentnode is leaf and value is sum add to allpaths
    if (currentNode.left == null && currentNode.right == null) {
      allPaths.add(new ArrayList<>(currentPath));
    } else {
      currentPath(currentNode.left, currentPath, allPaths);
      currentPath(currentNode.right, currentPath, allPaths);
    }
    // remove the current node from the path to backtrack
    currentPath.remove(currentPath.size() - 1);
  }

  //Given a binary tree, find the root-to-leaf path with the maximum sum.
  
  private static List<List<Integer>> maxAllPathSum(TreeNode root) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    maxPathSum(root, max, 0, currentPath, allPaths);
    return allPaths;

  }

  //Given a binary tree, find the maximum sum for root-to-leaf.
  
    private static int maxSumAllPath(TreeNode root) {
   List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    maxPathSum(root, max, 0, currentPath, allPaths);
    return max.max_no;

  }

  private static void maxPathSum(TreeNode currentNode, Maximum maxSum, int currentSum, List<Integer> currentPath, List<List<Integer>> allPaths) {
    if (currentNode == null)
      return;
    // add current node to path
    currentPath.add(currentNode.val);
    currentSum += currentNode.val;
    // if currentnode is leaf and value is sum add to allpaths
    if (currentNode.left == null && currentNode.right == null) {
      if(currentSum > maxSum.max_no) {
        maxSum.max_no = currentSum;
        allPaths.add(new ArrayList<>(currentPath));
      }
    } else {
      maxPathSum(currentNode.left, maxSum, currentSum, currentPath, allPaths);
      maxPathSum(currentNode.right, maxSum, currentSum, currentPath, allPaths);
    }
    // remove the current node from the path to backtrack
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
    System.out.println(Main.allPaths(root));
    System.out.println(Main.maxAllPathSum(root));
    System.out.println(Main.maxSumAllPath(root));
  }
}