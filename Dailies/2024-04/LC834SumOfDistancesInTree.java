import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

class SumOfDistancesInTree {
    public static void main(String[] args){
        int[][] testcase1edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int testcase1n = 6;

        int[][] testcase2edges = {};
        int testcase2n = 1;

        int[][] testcase3edges = {{1,0}};
        int testcase3n = 2;

        int[] result = sumOfDistancesInTree(testcase1n, testcase1edges);

        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();

        result = sumOfDistancesInTree(testcase2n, testcase2edges);

        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();

        result = sumOfDistancesInTree(testcase3n, testcase3edges);

        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> edgeMap = new HashMap<>();

        for(int i=0; i<n; i++){
            edgeMap.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            edgeMap.get(edges[i][0]).add(edges[i][1]);
            edgeMap.get(edges[i][1]).add(edges[i][0]);
        }

        depths = new int[n];
        distances = new int[n];

        HashSet<Integer> visitedNodes = new HashSet<>();

        dfs(0, edgeMap, 1, visitedNodes);
        visitedNodes.clear();
        dfsBoogaloo(0, edgeMap, n, visitedNodes);
        
        return distances;
    }

    public static int[] depths;
    public static int[] distances;

    public static int dfs(int node, HashMap<Integer, ArrayList<Integer>> edgeMap, int currentCost, HashSet<Integer> visitedNodes){
        ArrayList<Integer> edges = edgeMap.get(node);
        visitedNodes.add(node);
        int count = 1;

        for(int child : edges){
            if(!visitedNodes.contains(child)){
                distances[0] += currentCost;
                count += dfs(child, edgeMap, currentCost+1, visitedNodes);
            }
        }
        depths[node] = count;
        return count;
    }

    public static void dfsBoogaloo(int node, HashMap<Integer, ArrayList<Integer>> edgeMap, int n, HashSet<Integer> visitedNodes){
        ArrayList<Integer> edges = edgeMap.get(node);
        visitedNodes.add(node);
        
        for(int child : edges){
            if(!visitedNodes.contains(child)){
                distances[child] = distances[node] + (n - depths[child]) - depths[child];
                dfsBoogaloo(child, edgeMap, n, visitedNodes);
            }
        }
    }
}