class Solution {
    public int recurs(int i,int start,int arr[],int dp[]){
        int len2=arr.length;
        if(i>=len)
            return 0;
        if(i==len-1 && start==0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        return dp[i]=Math.max(recurs(i+1,start,arr,dp),arr[i]+recurs(i+2,start,arr,dp));
    }
    public int rob(int[] nums) {
        int len= nums.length;
        int dp[]=new int[len];
        Arrays.fill(dp,-1);
        if(len==1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0],nums[1]);
        int result=recurs(0,0,nums,dp);
        Arrays.fill(dp,-1);
        int recs=recurs(1,1,nums,dp);
        result=Math.max(result,recs);
        return result;
    }
}
