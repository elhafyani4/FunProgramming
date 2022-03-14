public class Problem1822
{
     public int ArraySign(int[] nums) {
        int sum = 1;
        foreach(int n in nums)
        {
            sum *= n;
        }

        if(sum > 0) return 1;
        if(sum < 0) return -1;
        if(sum == 0) return 0;
    }
}