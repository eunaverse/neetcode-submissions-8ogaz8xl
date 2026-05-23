class Solution {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    Map<Integer, List<Integer>> edge = new HashMap<>();
    Queue<Integer> que = new LinkedList<>();
    boolean[] visited = new boolean[numCourses];

    for (int[] pre : prerequisites) {
      indegree[pre[0]]++;
      edge.computeIfAbsent(pre[1], ArrayList::new).add(pre[0]);
    }

    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        que.add(i);
        visited[i] = true;
      }
    }

    int[] ans = new int[numCourses];
    int idx = 0;
    while (!que.isEmpty()) {
      int cur = que.poll();
      ans[idx++] = cur;
      for (int next : edge.getOrDefault(cur, Collections.emptyList())) {
        if (visited[next]) {
          continue;
        }
        indegree[next]--;
        if (indegree[next] == 0) {
          que.add(next);
          visited[next] = true;
        }
      }
    }

    return idx == numCourses ? ans : new int[0];
  }
}
