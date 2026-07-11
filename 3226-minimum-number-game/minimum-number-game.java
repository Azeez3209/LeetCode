class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int arr [] =new int[nums.length];
        int j=0;
        while(pq.size()>0){
            int alice=pq.poll();
            int bob=pq.poll();
            arr[j++]=bob;
            arr[j++]=alice;
        }
        return arr;
    }
}