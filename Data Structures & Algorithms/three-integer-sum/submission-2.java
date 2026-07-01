  public class Solution {
       public List<List<Integer>> threeSum(int[] nums) {
           Set<List<Integer>> res = new HashSet<>();
           Set<Integer> dups = new HashSet<>(); // 첫 번째 수의 중복 방지

           for (int i = 0; i < nums.length; i++) {
               if (dups.add(nums[i])) { // 이미 처리된 첫 번째 수라면 건너뜀
                   Set<Integer> seen = new HashSet<>(); // 2Sum을 위한 해시셋

                   for (int j = i + 1; j < nums.length; j++) {
                       int complement = -nums[i] - nums[j];
                       if (seen.contains(complement)) {
                           List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                           Collections.sort(triplet); // 결과값들의 무순서 중복 방지를 위한 3개짜리 정렬 (O(1))
                           res.add(triplet);
                       }
                       seen.add(nums[j]);
                   }
               }
           }
           return new ArrayList<>(res);
       }
   }