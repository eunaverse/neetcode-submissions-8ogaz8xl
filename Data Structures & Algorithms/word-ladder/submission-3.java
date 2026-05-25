class Solution {

  int ans;

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    if (!wordList.contains(endWord)) {
      return 0;
    }

    Map<String, List<String>> edge = new HashMap<>();

    for (int i = 0; i < wordList.size(); i++) {
      if (oneDiff(beginWord, wordList.get(i))) {
        edge.computeIfAbsent(beginWord, k -> new ArrayList<>()).add(wordList.get(i));
        edge.computeIfAbsent(wordList.get(i), k -> new ArrayList<>()).add(beginWord);
      }
      for (int j = i + 1; j < wordList.size(); j++) {
        if (oneDiff(wordList.get(i), wordList.get(j))) {
          edge.computeIfAbsent(wordList.get(i), k -> new ArrayList<>()).add(wordList.get(j));
          edge.computeIfAbsent(wordList.get(j), k -> new ArrayList<>()).add(wordList.get(i));
        }
      }
    }

    return bfs(beginWord, endWord, edge);
  }


  int bfs(String beginWord, String endWord, Map<String, List<String>> edge) {
    Queue<String> que = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    que.add(beginWord);
    visited.add(beginWord);

    int cnt = 0;
    while (!que.isEmpty()) {
      int size = que.size();
      cnt++;
      for (int i = 0; i < size; i++) {
        String word = que.poll();
        if (word.equals(endWord)) {
          return cnt;
        }
        for (String nextWord : edge.getOrDefault(word, Collections.emptyList())) {
          if (visited.contains(nextWord)) {
            continue;
          }
          que.add(nextWord);
          visited.add(nextWord);
        }
      }
    }

    return 0;

  }

  boolean oneDiff(String w1, String w2) {
    int diff = 0;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) != w2.charAt(i)) {
        diff++;
      }
      if (diff > 1) {
        return false;
      }
    }

    return true;
  }
}
