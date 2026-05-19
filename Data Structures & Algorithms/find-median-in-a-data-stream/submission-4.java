class MedianFinder {
          PriorityQueue<Integer> maxHeap;
                PriorityQueue<Integer> minHeap;

                      public MedianFinder() {
                                maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
                                          minHeap = new PriorityQueue<>();
                                                }

                                                      public void addNum(int num) {
                                                                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                                                                              maxHeap.add(num);
                                                                                        } else {
                                                                                                      minHeap.add(num);
                                                                                                                }

                                                                                                                          if (maxHeap.size() < minHeap.size()) {
                                                                                                                                        maxHeap.add(minHeap.poll());
                                                                                                                                                  } else if (maxHeap.size() > minHeap.size() + 1) {
                                                                                                                                                                minHeap.add(maxHeap.poll());
                                                                                                                                                                          }
                                                                                                                                                                                }

                                                                                                                                                                                      public double findMedian() {
                                                                                                                                                                                                if (maxHeap.isEmpty()) return -1;

                                                                                                                                                                                                          if (maxHeap.size() == minHeap.size()) {
                                                                                                                                                                                                                        return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
                                                                                                                                                                                                                                  }

                                                                                                                                                                                                                                            return maxHeap.peek();
                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                    }
