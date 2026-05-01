class CountSquares {
        Map<String, Integer> map;

            public CountSquares() {
                    map = new HashMap<>();
                        }

                            public void add(int[] point) {
                                    String key = point[0] + "," + point[1];
                                            map.put(key, map.getOrDefault(key, 0) + 1);
                                                }

                                                    public int count(int[] point) {
                                                            int x = point[0];
                                                                    int y = point[1];
                                                                            int res = 0;

                                                                                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                                                                                                String[] parts = entry.getKey().split(",");
                                                                                                            int px = Integer.parseInt(parts[0]);
                                                                                                                        int py = Integer.parseInt(parts[1]);
                                                                                                                                    int diagCount = entry.getValue();

                                                                                                                                                // 대각선 후보가 아니면 skip
                                                                                                                                                            if (px == x || py == y) continue;
                                                                                                                                                                        if (Math.abs(px - x) != Math.abs(py - y)) continue;

                                                                                                                                                                                    // 나머지 두 꼭짓점
                                                                                                                                                                                                String key1 = x + "," + py;
                                                                                                                                                                                                            String key2 = px + "," + y;

                                                                                                                                                                                                                        int count1 = map.getOrDefault(key1, 0);
                                                                                                                                                                                                                                    int count2 = map.getOrDefault(key2, 0);

                                                                                                                                                                                                                                                res += diagCount * count1 * count2;
                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                return res;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    }
