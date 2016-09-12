package leetcode.string;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Two pointers
     * Time Complexity: O(2n)
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j ++) {
        	while(exist[s.charAt(j)]) {
        		exist[s.charAt(i)] = false;
        		i ++;
        	}
        	exist[s.charAt(j)] = true;
        	maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
    
    public int lengthOfLongestSubstring2(String s) {
    	int[] indexMap = new int[256];
    	int i = 0, maxLen = 0;
    	Arrays.fill(indexMap, -1);
    	for(int j = 0; j < s.length(); j ++) {
    		if(indexMap[s.charAt(j)] >= i) {
    			i = indexMap[s.charAt(j)] + 1;
    		}
    		indexMap[s.charAt(j)] = j;
    		maxLen = Math.max(maxLen, j - i + 1);
    	}
    	return maxLen;
    }
    
    public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters so = new LongestSubstringWithoutRepeatingCharacters();
		String[] tests = {
				"",
				"a",
				"ab",
				"aa",
				"abcdaefghi"
		};
		for(int i = 0; i < tests.length; i ++) {
			System.out.println(so.lengthOfLongestSubstring1(tests[i]));
			System.out.println(so.lengthOfLongestSubstring2(tests[i]));
		}
	}
}
