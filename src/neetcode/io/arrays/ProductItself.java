package neetcode.io.arrays;

public class ProductItself {
    public static void main(String[] args) {
        ProductItself productItself = new ProductItself();
        productItself.productExceptSelf(new int[] {1,2,3,4});
    }

    /**
     * 
     * 
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

        You must write an algorithm that runs in O(n) time and without using the division operation.

        

        Example 1:

        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
        Example 2:

        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]
     * 
     * 
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 0;
        for(int i =0; i < nums.length; i++) {
            totalProduct  *= nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if(currentNum == 1 || currentNum == 0) {
                nums[i] = totalProduct;
            } else {
                
            }
        }
        return null;   
    }

        // Function to perform division `x/y` of two numbers `x` and `y`
    // without using the division operator in the code
    public static int divide(int x, int y)
    {
        // handle divisibility by 0
        if (y == 0)
        {
            System.out.printf("Error!! Divisible by 0");
            System.exit(-1);
        }
 
        // store sign of the result
        int sign = 1;
        if (x * y < 0) {
            sign = -1;
        }
 
        // convert both dividend and divisor to positive
        x = Math.abs(x);
        y = Math.abs(y);
 
        int mask = 1;
        int quotient = 0;
 
        while (y <= x)
        {
            y <<= 1;
            mask <<= 1;
        }
 
        while (mask > 1)
        {
            y >>= 1;
            mask >>= 1;
            if (x >= y)
            {
                x -= y;
                quotient |= mask;
            }
        }
 
        System.out.printf("The remainder is %d\n", x);
        return sign * quotient;
    }
}
