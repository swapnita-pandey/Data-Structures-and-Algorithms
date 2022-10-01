class Solution {
public:
    void swap(int &x, int &y){
        int temp = x;
        x = y;
        y = temp;
    }
    
    void nextPermutation(vector<int>& nums) {
        int size = nums.size();
        int index1;
        int index2;
        
        for(index1=size-2; index1 >= 0; index1--){
            if(nums[index1] < nums[index1 + 1]){  //we will find our index1 here
                break;
            }
        }
        
        if(index1 < 0){
            reverse(nums.begin(), nums.end());
        }else{
            for(index2 = size-1; index2 > index1; index2--){
                if(nums[index2] > nums[index1]){  //we will find our index2 here
                    break;
                }
            }
            
            swap(nums[index1], nums[index2]);
            reverse(nums.begin() + index1 + 1, nums.end());
        }
    }
};