class Solution {
    public int calPoints(String[] operations) {
        int i, top, top2, ans=0;
        Stack<Integer> st= new Stack<>();
        for(i=0;i<operations.length;i++){
            String s = operations[i];
            if(s.equals("+")){
                 top = st.pop();
                 top2 = st.peek();
                st.push(top);
                st.push(top + top2);
            }
            else if(s.equals("D")){
               top = st.peek();
               st.push(top*2);
            }
            else if(s.equals("C")){
                st.pop();
            }
            else{
                st.push(Integer.valueOf(s));
            }
        }
        for(int k : st){
            ans+=k;
        }
        return ans;
    }
}