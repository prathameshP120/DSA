


public class TrapingRainWater {
    public static int calculateRainWater(int height[]) {
        int n = height.length;
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];

        leftMax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int trapedWater = 0;

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trapedWater += waterLevel - height[i];
        }

        return trapedWater;

        //this will take the time complexity=O(n+n+n)=O(3n)
        //Sc=O(2n)
        //the sc can be optimize using the stack 
        
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println("RainWater traped is" + calculateRainWater(height));
    }

}
