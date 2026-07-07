class Solution {
    public int maxDepth(String s) {
        int i, ans =0;
        Stack<Character> st= new Stack<>();
        for(i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch == '('){
                st.push('(');
            }
            else if(ch == ')'){
                st.pop();
            }
            ans = Math.max(ans,st.size());
        }
        return ans;
    }
}