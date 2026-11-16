class MedianFinder:

    def __init__(self):
        self.min_heap = []
        self.max_heap = []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.min_heap, num)

        # min_heap의 가장 작은 값을 max_heap으로 이동
        heapq.heappush(
            self.max_heap,
            -heapq.heappop(self.min_heap)
        )

        # max_heap이 하나 더 많도록 조정
        if len(self.max_heap) > len(self.min_heap) + 1:
            heapq.heappush(
                self.min_heap,
                -heapq.heappop(self.max_heap)
            )

    def findMedian(self) -> float:
        if len(self.max_heap) > len(self.min_heap):
            return -self.max_heap[0]

        return (-self.max_heap[0] + self.min_heap[0]) / 2