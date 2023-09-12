class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> sol = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        int n = groupSizes.length;
        int max = 0;
        for(int i = 0;i<n;i++){
            if(groupSizes[i] > max){
                max = groupSizes[i];
            }
            if(hm.containsKey(groupSizes[i])){
                ArrayList<Integer> temp = hm.get(groupSizes[i]);
                temp.add(i);
                hm.put(groupSizes[i],temp);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                hm.put(groupSizes[i],temp);
            }
        }
        for(int i = 1;i<=max;i++){
            if(hm.containsKey(i)){
                ArrayList<Integer> temp = hm.get(i);
                int size = temp.size();
                int counter = 0;
                while(size > 0){
                    List<Integer> solTemp = new ArrayList<>();
                    for(int j = 0;j<i;j++){
                        solTemp.add(temp.get(counter++));
                        size--;
                        if(size == 0){
                            break;
                        }
                    }
                    sol.add(solTemp);
                }
                
            }
        }
        return sol;
    }
}