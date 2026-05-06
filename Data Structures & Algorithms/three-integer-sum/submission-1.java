class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int first = nums[i];
            findTwoSum(-first, i+1, nums.length-1, nums, res);
        }

        return res;
    }

    private void findTwoSum(int target, int start, int end, int[] nums, List<List<Integer>> res){
        while(start<end){
            int sum = nums[start]+nums[end];
            if(sum==target){
                res.add(List.of(-target, nums[start], nums[end]));
                start++;
                end--;
                while(start<end && nums[start]==nums[start-1]) start++;
                while(start<end && nums[end] == nums[end+1]) end--;
            }
            else if(sum < target){
                start++;
            }
            else{
                end--;
            
            }
        }
    }
}
