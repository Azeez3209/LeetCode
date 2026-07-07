class Solution {
    public String clearDigits(String s) {
        Stack<Character> st= new Stack<>();
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}