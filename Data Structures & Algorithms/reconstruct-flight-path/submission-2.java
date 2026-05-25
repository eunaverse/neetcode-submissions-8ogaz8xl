 class Solution {
    List<String> ans = new ArrayList<>();
    int totalTickets;

    public List<String> findItinerary(List<List<String>> tickets) {
      totalTickets = tickets.size();

      Map<String, List<String>> edge = new HashMap<>();

      for (List<String> t : tickets) {
        edge.computeIfAbsent(t.get(0), v -> new ArrayList<>()).add(t.get(1));
      }

      for (List<String> nexts : edge.values()) {
        Collections.sort(nexts);
      }

      List<String> path = new ArrayList<>();
      path.add("JFK");

      dfs("JFK", path, edge);

      return ans;
    }

    boolean dfs(String cur, List<String> path, Map<String, List<String>> edge) {
      if (path.size() == totalTickets + 1) {
        ans = new ArrayList<>(path);
        return true;
      }

      List<String> nexts = edge.get(cur);
      if (nexts == null || nexts.isEmpty()) {
        return false;
      }

      for (int i = 0; i < nexts.size(); i++) {
        String next = nexts.remove(i);
        path.add(next);

        if (dfs(next, path, edge)) {
          return true;
        }

        path.remove(path.size() - 1);
        nexts.add(i, next);
      }

      return false;
    }
  }