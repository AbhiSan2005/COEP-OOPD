import java.util.Arrays;

public class Array{
    public static void main(String[] args) {
        int[] a = new int[100]; //Analogous to int* a = new int[100] in cpp
        int[] smallPrimes = { 2, 3, 5, 7, 11, 13 };

        //By Default all array elements are 0, false or null (for non-primitives)!!

        for (int element : a) System.out.println(element); //For each loop

        //Splendid way to print an entire array for debugging ig
        System.out.println(Arrays.toString(a));

        //This only creates reference
        int[] luckyNumbers = smallPrimes;
        luckyNumbers[5] = 12; //Now smallPrimes[5] is also 12

        luckyNumbers = Arrays.copyOf(luckyNumbers, 2 * luckyNumbers.length);

        double[][] balances = new double[10][6]; //Not double (*balances)[6] = new double[10][6] but double** balances = new double*[10]
        int[][] magicSquare =
        {
            {16, 3, 2, 13},
            {5, 10, 11, 8},
            {9, 6, 7, 12},
            {4, 15, 14, 1}
        };
    }
}