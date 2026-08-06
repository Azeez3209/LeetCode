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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        
        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int size = queue.size();
            
            for(int i=0;i<size;i++) {
                TreeNode current= queue.poll();
                if(leftToRight){
                    level.addLast(current.val);
                }else{
                    level.addFirst(current.val);
                }
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }    
            
            ans.add(level);

            leftToRight = !leftToRight;
        }
        return ans;           
    }
}