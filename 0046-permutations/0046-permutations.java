class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> sol = new ArrayList<>();
        List<Integer> unpro =new ArrayList<>();
        List<Integer> pro =new ArrayList<>();
        for(int num : nums){
            unpro.add(num);
        }
        permutationArr(pro,unpro,0,0,sol);
        return sol;
    }
     public  void permutationArr(List<Integer> pro,  List<Integer> unpro, int idxu, int idxp, List<List<Integer>> sol){
        if(idxu == unpro.size()){
            List<Integer> add = new ArrayList<>(pro);
            sol.add(add);
            return;
        }
        int toAdd = unpro.get(idxu);
        for (int i = 0; i <= pro.size(); i++) {
            pro.add(i,toAdd);
            permutationArr(pro,unpro,idxu+1,idxp,sol);
            pro.remove(i);
        }

    }
}