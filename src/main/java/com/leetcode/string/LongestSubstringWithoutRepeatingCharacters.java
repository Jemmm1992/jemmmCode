package com.leetcode.string;

import java.util.HashSet;

/**
 * Created by BIG-JIAN on 2017/7/5.
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
/**基本思路是维护一个窗口，每次关注窗口中的字符串,在每次判断中，左窗口和右窗口选择其一向前移动。
 * 同样是维护一个HashSet, 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，
 * 如果发现重复字符，则说明当前窗口中的串已经不满足要求，继续移动有窗口不可能得到更好的结果，
 * 此时移动左窗口，直到不再有重复字符为止，中间跳过的这些串中不会有更好的结果，因为他们不是重复就是更短。
 * 因为左窗口和右窗口都只向前，所以两个窗口都对每个元素访问不超过一遍，因此时间复杂度为O(2*n)=O(n),是线性算法。
 * 空间复杂度为HashSet的size,也是O(n).
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int walker = 0;
        int runner = 0;
        while(runner<s.length()) {
            if(set.contains(s.charAt(runner))) {
                if(max<runner-walker) {
                    max = runner-walker;
                }
                while(s.charAt(walker)!=s.charAt(runner)) {
                    set.remove(s.charAt(walker));
                    walker++;
                }
                walker++;
            } else {
                set.add(s.charAt(runner));
            }
            runner++;
        }
        max = Math.max(max,runner-walker);
        return max;
    }
}
