class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
            if (hand.length % groupSize != 0) return false;

                Map<Integer, Integer> count = new HashMap<>();

                    for (int num : hand) {
                            count.put(num, count.getOrDefault(num, 0) + 1);
                                }

                                    for (int num : hand) {
                                            if (count.getOrDefault(num, 0) == 0) continue;

                                                    int start = num;

                                                            // num이 속할 수 있는 가장 왼쪽 시작점 찾기
                                                                    while (count.getOrDefault(start - 1, 0) > 0) {
                                                                                start--;
                                                                                        }

                                                                                                // start부터 num까지 필요한 그룹을 처리
                                                                                                        while (start <= num) {
                                                                                                                    while (count.getOrDefault(start, 0) > 0) {
                                                                                                                                    for (int i = 0; i < groupSize; i++) {
                                                                                                                                                        int curr = start + i;

                                                                                                                                                                            if (count.getOrDefault(curr, 0) == 0) {
                                                                                                                                                                                                    return false;
                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                            count.put(curr, count.get(curr) - 1);
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                    start++;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                    return true;
                                                                                                                                                                                                                                                                                                    }
    }

