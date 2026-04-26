class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
            if (hand.length % groupSize != 0) return false;

                Arrays.sort(hand);

                    Map<Integer, Integer> count = new HashMap<>();
                        for (int num : hand) {
                                count.put(num, count.getOrDefault(num, 0) + 1);
                                    }

                                        for (int num : hand) {
                                                if (count.get(num) == 0) continue;

                                                        // num부터 시작하는 그룹 생성
                                                                for (int i = 0; i < groupSize; i++) {
                                                                            int curr = num + i;

                                                                                        if (count.getOrDefault(curr, 0) == 0) {
                                                                                                        return false;
                                                                                                                    }

                                                                                                                                count.put(curr, count.get(curr) - 1);
                                                                                                                                        }
                                                                                                                                            }

                                                                                                                                                return true;
                                                                                                                                                }
    }

