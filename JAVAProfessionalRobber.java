import java.util.Scanner;

abstract class Robber {
    public abstract void RobbingClass();

    public void MachineLearning() {
        System.out.println("I love MachineLearning.");
    }

    public abstract int RowHouses(int[] houses);
    public abstract int RoundHouses(int[] houses);
    public abstract int SquareHouse(int[] houses);
    public abstract int MuliHouseBuilding(int[][] houseTypes);
}

class JAVAProfessionalRobber extends Robber {
    @Override
    public void RobbingClass() {
        System.out.println("MScAI&ML");
    }

    @Override
    public int RowHouses(int[] houses) {
        if (houses == null || houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];

        int prev2 = 0;
        int prev1 = houses[0];

        for (int i = 1; i < houses.length; i++) {
            int current = Math.max(prev1, prev2 + houses[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public int RoundHouses(int[] houses) {
        if (houses == null || houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];
        if (houses.length == 2) return Math.max(houses[0], houses[1]);

        int includeFirst = robCircular(houses, 0, houses.length - 2);
        int includeLast = robCircular(houses, 1, houses.length - 1);

        return Math.max(includeFirst, includeLast);
    }

    private int robCircular(int[] houses, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + houses[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    @Override
    public int SquareHouse(int[] houses) {
        return RowHouses(houses);
    }

    @Override
    public int MuliHouseBuilding(int[][] houseTypes) {
        int totalMax = 0;

        for (int i = 0; i < houseTypes.length; i++) {
            int[] houses = houseTypes[i];
            if (i % 3 == 0) {
                totalMax += RoundHouses(houses);
            } else if (i % 3 == 1) {  
                totalMax += RoundHouses(houses);
            } else if (i % 3 == 2) {
                totalMax += SquareHouse(houses);
            }
        }

        return totalMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();

        robber.RobbingClass();
        robber.MachineLearning();

        
        System.out.print("Enter number of houses in a row: ");
        int nRow = scanner.nextInt();
        int[] rowHousesTest = new int[nRow];
        System.out.println("Enter the money in each house for Row Houses:");
        for (int i = 0; i < nRow; i++) {
            rowHousesTest[i] = scanner.nextInt();
        }

        
        System.out.print("Enter number of houses in a round: ");
        int nRound = scanner.nextInt();
        int[] roundHousesTest = new int[nRound];
        System.out.println("Enter the money in each house for Round Houses:");
        for (int i = 0; i < nRound; i++) {
            roundHousesTest[i] = scanner.nextInt();
        }

        
        System.out.print("Enter number of houses in a square: ");
        int nSquare = scanner.nextInt();
        int[] squareHouseTest = new int[nSquare];
        System.out.println("Enter the money in each house for Square House:");
        for (int i = 0; i < nSquare; i++) {
            squareHouseTest[i] = scanner.nextInt();
        }

        
        System.out.print("Enter the number of types of houses (rows) in Multi House Building: ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of houses in each type: ");
        int p = scanner.nextInt();
        int[][] multiHouseTest = new int[m][p];
        System.out.println("Enter the money in each house for Multi House Building:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                multiHouseTest[i][j] = scanner.nextInt();
            }
        }

        
        System.out.println("Max money from Row Houses: " + robber.RowHouses(rowHousesTest));
        System.out.println("Max money from Round Houses: " + robber.RoundHouses(roundHousesTest));
        System.out.println("Max money from Square House: " + robber.SquareHouse(squareHouseTest));
        System.out.println("Max money from Multi House Building: " + robber.MuliHouseBuilding(multiHouseTest));
        
        scanner.close();
    }
}
