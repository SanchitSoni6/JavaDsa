class Solution {
    public boolean increasingTriplet(int[] nums) {
        int j = Integer.MAX_VALUE;
        int i = Integer.MAX_VALUE;
        for(int num : nums){
            if (num<=i){
                i=num;
            }else if (num<=j){
                j=num;

           }else{
                return true;
            }
        }
        return false;
    
        
    }
}