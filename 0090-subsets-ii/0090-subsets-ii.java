class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
       List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                if(!outer.contains(internal)){
                    outer.add(internal);
                }
            }
        }
        return  outer;
    }
}