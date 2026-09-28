/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preorderIndex= 0;
    Map<Integer, Integer> inorderMap= new HashMap<>();

    TreeNode bulidTreeHelper(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }

        int rootValue = preorder[preorderIndex++];

        TreeNode root= new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        root.left = bulidTreeHelper(preorder, left, rootIndex-1);
        root.right = bulidTreeHelper(preorder, rootIndex+1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return bulidTreeHelper(preorder,0, inorder.length-1);
    }
}