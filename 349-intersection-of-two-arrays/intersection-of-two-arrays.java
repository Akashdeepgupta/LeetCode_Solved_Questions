class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        List<Integer> sol = new ArrayList<>();
        for(int i = 0;i<nums1.length;i++){
            hs.add(nums1[i]);
        }
        for(int i = 0;i<nums2.length;i++){
            if(hs.contains(nums2[i])){
                hs.remove(nums2[i]);
                sol.add(nums2[i]);
            }
        }
        int size = sol.size();
        int [] answer = new int[size];
        for(int i = 0;i<size;i++){
            answer[i] = sol.get(i);
        }
        return answer;
    }
}