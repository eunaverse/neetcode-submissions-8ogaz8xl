class Twitter:

    def __init__(self):
        self.count = 0
        self.tweetMap = defaultdict(list) # [count, tweetId]
        self.followMap = defaultdict(set) # [followeeId]

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweetMap[userId].append([self.count, tweetId])
        if len(self.tweetMap[userId]) > 10:
            self.tweetMap[userId].pop(0)
        self.count -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        maxHeap = []
        for count, tweetId in self.tweetMap[userId]:
            heapq.heappush(maxHeap, [-count, tweetId])

        for followeeId in self.followMap[userId]:
            if followeeId in self.tweetMap:
                for count, tweetId in self.tweetMap[followeeId]:
                    heapq.heappush(maxHeap, [-count, tweetId])
                    if len(maxHeap) > 10:
                        heapq.heappop(maxHeap)

        res = []
        while len(maxHeap) > 0:
            count, tweetId = heapq.heappop(maxHeap)
            res.append(tweetId)
        res.reverse()
        
        return res


    def follow(self, followerId: int, followeeId: int) -> None:
        self.followMap[followerId].add(followeeId)
        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.followMap[followerId]:
            self.followMap[followerId].remove(followeeId)
        
