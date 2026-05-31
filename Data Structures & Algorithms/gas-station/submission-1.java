class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
                int gasSum = 0, costSum = 0;
                        for (int i = 0; i < gas.length; i++) {
                                    gasSum += gas[i];
                                                costSum += cost[i];
                                                        }

                                                                if (gasSum < costSum) return -1;

                                                                        int total = 0;
                                                                                int start = 0;
                                                                                        for (int i = 0; i < gas.length; i++) {
                                                                                                    int diff = gas[i] - cost[i];
                                                                                                                total += diff;
                                                                                                                            if (total < 0) {
                                                                                                                                            start = i + 1;
                                                                                                                                                            total = 0;
                                                                                                                                                                        }
                                                                                                                                                                                }

                                                                                                                                                                                        return start;
                                                                                                                                                                                            }
                                                                                                                                                                                            }

