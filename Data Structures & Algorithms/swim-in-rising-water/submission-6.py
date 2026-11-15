class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])

        time = [[float('inf')] * m for _ in range(n)]
        time[0][0] = grid[0][0]

        min_heap = [(grid[0][0], 0, 0)]

        dr = [0, 1, 0, -1]
        dc = [1, 0, -1, 0]

        while min_heap:
            cur_time, cur_r, cur_c = heapq.heappop(min_heap)

            # 이전에 저장된 더 좋은 경로가 존재하면 무시
            if cur_time > time[cur_r][cur_c]:
                continue

            if cur_r == n-1 and cur_c == m-1:
                return cur_time

            for i in range(4):
                next_r = cur_r + dr[i]
                next_c = cur_c + dc[i]

                if not (0 <= next_r < n and 0 <= next_c < m):
                    continue

                new_time = max(cur_time, grid[next_r][next_c])

                if new_time < time[next_r][next_c]:
                    time[next_r][next_c] = new_time
                    heapq.heappush(
                        min_heap,
                        (new_time, next_r, next_c)
                    )

        return -1