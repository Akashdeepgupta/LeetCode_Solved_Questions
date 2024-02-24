class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
       
        // Group Meetings in increasing order of time
        Map<Integer, List<int[]>> timeMeetings = new TreeMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], t = meeting[2];
            timeMeetings.computeIfAbsent(t, k -> new ArrayList<>()).add(new int[]{x, y});
        }
        
        // Boolean Array to mark if a person knows the secret or not
        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;

        // Process in increasing order of time
        for (int t : timeMeetings.keySet()) {
            // For each person, save all the people whom he/she meets at time t
            Map<Integer, List<Integer>> meet = new HashMap<>();
            for (int[] meeting : timeMeetings.get(t)) {
                int x = meeting[0], y = meeting[1];
                meet.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                meet.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            }

            // Start traversal from those who already know the secret at time t
            // Set to avoid redundancy
            Set<Integer> start = new HashSet<>();
            for (int[] meeting : timeMeetings.get(t)) {
                int x = meeting[0], y = meeting[1];
                if (knowsSecret[x]) {
                    start.add(x);
                }
                if (knowsSecret[y]) {
                    start.add(y);
                }
            }
            
            // Do BFS
            Queue<Integer> q = new LinkedList<>(start);
            while (!q.isEmpty()) {
                int person = q.poll();
                for (int nextPerson : meet.getOrDefault(person, new ArrayList<>())) {
                    if (!knowsSecret[nextPerson]) {
                        knowsSecret[nextPerson] = true;
                        q.offer(nextPerson);
                    }
                }
            }
        }
        
        // List of people who know the secret
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (knowsSecret[i]) {
                result.add(i);
            }
        }
        return result;
        
    }
}


// {
//      // create bi-directional graph using meetings array
//         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

//         for(int i = 0;i<n;i++){
//             graph.add(new ArrayList<Integer>());
//         }

//         for(int i = 0;i<meetings.length;i++){
//             int val1 = meetings[i][0];
//             int val2 = meetings[i][1];
//             graph.get(val1).add(val2);
//             graph.get(val2).add(val1);
//         }

//         // one array to check whether secret is shared to that person
//         int [] isSecretShared = new int[n];
//         isSecretShared[0] = 1; //person 0 always knows the secret
//         isSecretShared[firstPerson] = 1; //firstPerson also knows the secret (argument given).
        
// }