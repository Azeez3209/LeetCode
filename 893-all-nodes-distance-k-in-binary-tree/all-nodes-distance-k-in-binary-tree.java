/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current= queue.poll();

            if(current.left != null){
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }

            if(current.right != null){
                parentMap.put(current.right, current);
                queue.offer(current.right);
            
            }  
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> ans = new ArrayList<>();

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            if(distance == k) {
                while(!queue.isEmpty()){
                    ans.add(queue.poll().val);
                }
                return ans;
            }

            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();

                if(current.left != null && !visited.contains(current.left)){
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                if(current.right != null && !visited.contains(current.right)){
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                if(parentMap.containsKey(current) && !visited.contains(parentMap.get(current))){
                    queue.offer(parentMap.get(current));
                    visited.add(parentMap.get(current));
                }
            }
            distance++;
        }
        return ans;
    }
}