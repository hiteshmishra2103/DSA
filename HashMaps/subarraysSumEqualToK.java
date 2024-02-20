package HashMaps;

//brute force solution
//use two loops to find all subarrays and check if their sum is equal to k

//following is most optimised solution for subarray sum equal to k
class Solution {
    public int subarraySum(int[] nums, int k) {
    HashMap<Integer, Integer> map=new HashMap<>();
    int sum=0, ans=0;
    //(sum, count)
    //the following is for case when the whole array sum is equal to k
    map.put(0,1);

    for(int j=0;j<nums.length;j++){
        sum+=nums[j];//sum[j]
        if(map.containsKey(sum-k)){
            //adding 
            ans+=map.get(sum-k);
        }
        
        map.put(sum, map.getOrDefault(sum,0)+1);
    }

    return ans;

    }
}