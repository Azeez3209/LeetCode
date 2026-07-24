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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while(current != null || !stack.isEmpty()){

            if(current != null){
                stack.push(current);
                current = current.left;
            }
            else{
                TreeNode temp = stack.peek();
                if(temp.right != null && lastVisited != temp.right){
                    current = temp.right;
                }
                else {
                    ans.add(temp.val);
                    lastVisited = stack.pop();
                }
            }
        }
        return ans;
    }
}