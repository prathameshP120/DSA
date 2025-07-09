public class KokoEating {
    public static int minEatingSpeed(int piles[], int h) {
        int minspeed = 1;
        int maxSpeed = 0;
        for (int i = 0; i < piles.length; i++) {
            maxSpeed = Math.max(maxSpeed, piles[i]);
        }
        while (minspeed < maxSpeed) {
            int mid = minspeed + (maxSpeed - minspeed) / 2;
            if (canEatIntime(piles, h, mid)) {
                maxSpeed = mid;
            } else {
                minspeed = mid + 1;
            }
        }
        return minspeed;
    }

    private static boolean canEatIntime(int piles[], int h, int speed) {
        int TH = 0;
        for (int i = 0; i < piles.length; i++) {
            TH += Math.ceil((double) (piles[i]) / (speed));
        }
        return TH <= h;
    }

    public static void main(String[] args) {
        int piles[] = { 3, 6, 7, 11 };
        System.out.println(minEatingSpeed(piles, 8));
    }
}
