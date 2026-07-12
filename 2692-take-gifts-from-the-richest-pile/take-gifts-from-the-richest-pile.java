class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans=0;
        int temp,i;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(i=0; i<gifts.length; i++){
            pq.add(gifts[i]);
        }
        for(i=0; i<k; i++){
            temp= (int)Math.sqrt(pq.poll());
            pq.add(temp);
        }
        for(int val : pq){
            ans+=val;
        }
        return ans;
    }
}