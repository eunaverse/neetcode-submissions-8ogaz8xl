class MedianFinder:

    def __init__(self):
        self.minHeap = []
        self.maxHeap = []
        

    def addNum(self, num: int) -> None:
        heapq.heappush(self.maxHeap, -num)

        largest = -heapq.heappop(self.maxHeap)
        heapq.heappush(self.minHeap, largest)

        if len(self.maxHeap) < len(self.minHeap):
            n = -heapq.heappop(self.minHeap)
            heapq.heappush(self.maxHeap, n)
        

    def findMedian(self) -> float:
        if(len(self.maxHeap) == len(self.minHeap)):
            return (-self.maxHeap[0]+self.minHeap[0])/2
        else:
            return -self.maxHeap[0]

        
        