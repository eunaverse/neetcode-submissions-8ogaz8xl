class Solution {
            public int findKthLargest(int[] nums, int k) {
                    int offset = 10000;
                            int[] count = new int[20001];

                                    for (int num : nums) {
                                                count[num + offset]++;
                                                        }

                                                                for (int i = count.length - 1; i >= 0; i--) {
                                                                            k -= count[i];
                                                                                        if (k <= 0) {
                                                                                                        return i - offset;
                                                                                                                    }
                                                                                                                            }

                                                                                                                                    return -1;
                                                                                                                                        }
                                                                                                                                        }
