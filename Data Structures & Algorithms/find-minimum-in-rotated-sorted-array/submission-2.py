class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1

        res = 1001
        while l<=r:
            m = (l+r)//2
            if nums[m] > nums[r]: 
                l = m + 1
            else:  
                res = min(res, nums[m])
                r = m - 1
        
        return res