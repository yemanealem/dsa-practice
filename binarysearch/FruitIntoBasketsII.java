public class FruitIntoBasketsII {

    public int countUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] used = new boolean[baskets.length];
        int unplaced = 0;

        for (int fruit : fruits) {
            boolean placed = false;

            for (int i = 0; i < baskets.length; i++) {
                if (!used[i] && baskets[i] >= fruit) {
                    used[i] = true; // use basket
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                unplaced++;
            }
        }

        return unplaced;
    }

    // Main method to test
    public static void main(String[] args) {
        FruitIntoBasketsII sol = new FruitIntoBasketsII();

        int[] fruits = {4, 2, 5};
        int[] baskets = {3, 5, 4};

        System.out.println(sol.countUnplacedFruits(fruits, baskets)); // Output: 1
    }
}
