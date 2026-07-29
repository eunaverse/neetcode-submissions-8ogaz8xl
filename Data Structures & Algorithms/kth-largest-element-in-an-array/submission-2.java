class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(a->-a));
        for(int num:nums){
            pq.offer(num);
        }

        while(!pq.isEmpty()){
            if(k==1) return pq.poll();
            k--;
            pq.poll();
        }

        return -1;
    }
}
