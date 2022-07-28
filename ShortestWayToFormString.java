// Time Complexity : O(m) +O(n.Logk)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ShortestWayToFormString {
    class Solution {
        public int shortestWay(String source, String target) {
            int tl = target.length();
            int sl = source.length();
            int tp = 0;
            int sp = 0;
            Map<Character, List<Integer>> map = new HashMap<>();

            for(int i=0; i<sl; i++) {
                char c = source.charAt(i);
                if(!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(i);
            }
            int count = 1;

            while(tp < tl) {
                char tChar = target.charAt(tp);
                if(!map.containsKey(tChar)) return -1;
                List<Integer> li = map.get(tChar);
                //binarySearch
                int k = Collections.binarySearch(li, sp);

                if(k < 0) { // element sp is present or within the list boundry
                    //convert the k into the proper index value where sp can be
                    k = -k - 1;
                }

                if(k == li.size()) { // sp is not in the list
                    sp = 0;
                    count+=1;
                } else { // sp is in the list
                    sp = li.get(k);
                    sp++;
                    tp++;
                }
            }

            return count;
        }
    }
}
