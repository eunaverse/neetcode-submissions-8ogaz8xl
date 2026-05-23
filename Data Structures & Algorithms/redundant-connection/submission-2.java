class Solution {

  int[] ans = new int[2];

  public int[] findRedundantConnection(int[][] edges) {
    Map<Integer, List<Integer>> edgeMap = new HashMap<>();
    for (int[] edge : edges) {
      edgeMap.computeIfAbsent(edge[0], ArrayList::new).add(edge[1]);
      edgeMap.computeIfAbsent(edge[1], ArrayList::new).add(edge[0]);
    }

    boolean[] visited = new boolean[edges.length + 1];
    Stack<Integer> stk = new Stack<>();
    findCycle(stk, visited, 1, edgeMap, edges);
    return ans;
  }

  boolean findCycle(Stack<Integer> stk, boolean[] visited, int cur,
      Map<Integer, List<Integer>> edgeMap, int[][] edges) {
    visited[cur] = true;
    stk.push(cur);
    for (int next : edgeMap.getOrDefault(cur, Collections.emptyList())) {
      if (visited[next] && stk.size() > 1 && stk.elementAt(stk.size() - 2) == next) {
        continue;
      }
      if (visited[next]) {
        Set<Integer> set = new HashSet<>();
        while (!stk.isEmpty() && stk.peek()!=next) {
          set.add(stk.pop());
        }
        set.add(next);
        for (int i = edges.length - 1; i >= 0; i--) {
          if (set.contains(edges[i][0]) && set.contains(edges[i][1])) {
            ans[0] = edges[i][0];
            ans[1] = edges[i][1];
            break;
          }
        }
        return true;
      }
      if (findCycle(stk, visited, next, edgeMap, edges)) {
        return true;
      }
    }

    stk.pop();
    return false;
  }

}
