// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

// Example 1:

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
public class FindtheIndexoftheFirstOccurrenceInAString {
   
    public int strStr(String haystack, String needle) {
        // If the needle is empty, return 0 (common strStr behavior)
        if (needle.isEmpty()) {
            return 0;
        }

        // Loop through the haystack up to a point where needle could still fit
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring starting from i matches the needle
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the starting index if found
            }
        }
        
        // Return -1 if the needle is not found
        return -1;
    
}
}
