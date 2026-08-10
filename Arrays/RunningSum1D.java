import java.util.*;
public class RunningSum1D{
    public static main void(String[] args){
        public int[] runningSum(int[] nums) {
        for (int i=1; i<nums.length;i++){
            nums[i]+= nums[i-1];
        }
        return nums;

}
    
}
