class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n,m = len(matrix), len(matrix[0])

        l = 0
        r = n-1
        row = 0
        while l<=r:
            mid = l + ((r-l)//2)
            if target >= matrix[mid][0] and target <= matrix[mid][m-1]:
                if target == matrix[mid][0] or target == matrix[mid][m-1]:
                    return True
                row = mid
                break
            elif target < matrix[mid][0]:
                r = mid -1
            else:
                l = mid +1
    
        l = 0
        r = m - 1
        while l<=r:
            mid = l + ((r-l)//2)
            if target < matrix[row][mid]:
                r  = mid - 1
            elif target > matrix[row][mid]:
                l = mid + 1
            else: return True
        return False
