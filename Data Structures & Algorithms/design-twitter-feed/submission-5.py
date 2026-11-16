from collections import defaultdict
import heapq
from typing import List

class Twitter:

    def __init__(self):
        self.count = 0
        self.tweetMap = defaultdict(list)
        self.followMap = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweetMap[userId].append((self.count, tweetId))
        self.count += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        res = []
        minHeap = []

        # 자기 자신 + 팔로우한 사용자
        followees = self.followMap[userId] | {userId}

        for followeeId in followees:
            if self.tweetMap[followeeId]:
                index = len(self.tweetMap[followeeId]) - 1
                count, tweetId = self.tweetMap[followeeId][index]

                heapq.heappush(
                    minHeap,
                    (-count, tweetId, followeeId, index - 1)
                )

        while minHeap and len(res) < 10:
            count, tweetId, followeeId, index = heapq.heappop(minHeap)
            res.append(tweetId)

            if index >= 0:
                count, tweetId = self.tweetMap[followeeId][index]

                heapq.heappush(
                    minHeap,
                    (-count, tweetId, followeeId, index - 1)
                )

        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.followMap[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.followMap[followerId].discard(followeeId)