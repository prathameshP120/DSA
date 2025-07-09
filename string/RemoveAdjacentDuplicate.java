public class RemoveAdjacentDuplicate {
    public String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            // Check if ans is not empty and the last character of ans is equal to the
            // current character in s
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == s.charAt(index)) {
                // Remove the last character (pop) from ans
                ans.deleteCharAt(ans.length() - 1);
            } else {
                // Add the current character to ans
                ans.append(s.charAt(index));
            }
            index++;
        }
        return ans.toString();
    }

}
