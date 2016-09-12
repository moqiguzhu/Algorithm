package leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Description: Leetcode 395.
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 *  such that every character in T appears no less than k times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if(null == s || s.length() < k) {
        	return 0;
        }
        
        return solve(s.toCharArray(), 0, s.length(), k);
    }
    
    private int solve(char[] cs, int begin, int end, int k) {
    	if(end - begin < k) {
    		return 0;
    	}
    	
    	Map<Character, List<Integer>> map = new HashMap<>();
    	for(int i = begin; i < end; i ++) {
    		if(!map.containsKey(cs[i])) {
    			map.put(cs[i], new ArrayList<Integer>());//arraylist to store the index of c
    		}
    		map.get(cs[i]).add(i);
    	}
    	List<Integer> less = new ArrayList<Integer>();
    	for(char c : map.keySet()) {
    		if(map.get(c).size() < k) {
    			less.addAll(map.get(c));
    		}
    	}
    	//return early
    	if(less.size() == 0) {
    		return end - begin;
    	}
    	int maxLen = 0;
    	Collections.sort(less);
    	less.add(end);//for convenient to split.
    	int left = begin;
    	for(int i = 0; i < less.size(); i ++) {
    		int right = less.get(i);
    		maxLen = Math.max(maxLen, solve(cs, left, right, k));
    		left = right + 1;//for next iteration.
    	}
    	return maxLen;
    }
    
    public static void main(String[] args) {
		LongestSubstringWithAtLeastKRepeatingCharacters so = new LongestSubstringWithAtLeastKRepeatingCharacters();
		String s1 = "aaabb";
		String s2 = "ababbc";
		String s3 = "bbaaacbd";
		System.out.println(so.longestSubstring(null, 2));//0
		System.out.println(so.longestSubstring(s1, 3));//3
		System.out.println(so.longestSubstring(s2, 2));//5
		System.out.println(so.longestSubstring(s2, 3));//0
		System.out.println(so.longestSubstring(s3, 3));
	}
}
