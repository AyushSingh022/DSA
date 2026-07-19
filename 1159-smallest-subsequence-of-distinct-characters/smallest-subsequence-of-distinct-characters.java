
class Solution {
    public String smallestSubsequence(String s) {
        int[] charCnt = new int[26];
        HashSet<Character> inStack = new HashSet<>();
        for (char ch : s.toCharArray()) {
            charCnt[ch - 'a']++;
        }
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            charCnt[ch - 'a']--;
            if (inStack.contains(ch)) {
                continue;
            }
            while (!st.isEmpty()
                    && ch < st.peek()
                    && charCnt[st.peek() - 'a'] > 0) {
                inStack.remove(st.pop());
            }

            st.push(ch);
            inStack.add(ch);
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}