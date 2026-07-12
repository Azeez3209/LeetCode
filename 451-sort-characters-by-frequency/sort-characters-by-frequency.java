class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Freq> pq=new PriorityQueue<>((a,b)-> b.val - a.val);
        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(char key: hm.keySet()){
            pq.add(new Freq(key,hm.get(key)));
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Freq top = pq.poll();
            char ch = top.key;
            int cnt = top.val;
            for(int i=0; i<cnt; i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

class Freq{
    char key;
    int val;
    Freq(char key,int val){
        this.key=key;
        this.val=val;
    }
}