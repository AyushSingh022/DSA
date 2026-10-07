import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        int leftRemove = 0;
        int rightRemove = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftRemove++;
            } else if (ch == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        backtrack(s, 0, 0, leftRemove, rightRemove,
                  new StringBuilder(), result);

        return new ArrayList<>(new LinkedHashSet<>(result));
    }

    private void backtrack(String s, int index, int balance,
                           int leftRemove, int rightRemove,
                           StringBuilder current, List<String> result) {

        if (balance < 0) {
            return;
        }

        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && balance == 0) {
                result.add(current.toString());
            }
            return;
        }

        char ch = s.charAt(index);

        if (ch == '(') {
            if (leftRemove > 0) {
                backtrack(s, index + 1, balance,
                          leftRemove - 1, rightRemove,
                          current, result);
            }

            current.append(ch);

            backtrack(s, index + 1, balance + 1,
                      leftRemove, rightRemove,
                      current, result);

            current.deleteCharAt(current.length() - 1);

        } else if (ch == ')') {
            if (rightRemove > 0) {
                backtrack(s, index + 1, balance,
                          leftRemove, rightRemove - 1,
                          current, result);
            }

            if (balance > 0) {
                current.append(ch);

                backtrack(s, index + 1, balance - 1,
                          leftRemove, rightRemove,
                          current, result);

                current.deleteCharAt(current.length() - 1);
            }

        } else {
            current.append(ch);

            backtrack(s, index + 1, balance,
                      leftRemove, rightRemove,
                      current, result);

            current.deleteCharAt(current.length() - 1);
        }
    }
}