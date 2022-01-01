package Day217;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Day2 Corruption Checksum
public class Day2 {
    
    //For each row, determine the difference between the largest value and the smallest value; the checksum is the sum of all of these differences.
    private static int puzzle1(File file) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int total = 0;
        String line = reader.readLine();
        while (line != null) {
            int mayor = 0;
            int menor = 10000;
            String[] valores = line.trim().split("\\s+");
            int[] numeros = new int[valores.length];
            for (int i = 0; i < valores.length; i++) {
                int actual = Integer.parseInt(valores[i]);
                numeros[i] = actual;
                if(actual > mayor)
                    mayor = actual;
                if(actual < menor)
                    menor = actual;
            }
            int dif = mayor - menor;
            total += dif;
            line = reader.readLine();
        }
        return total;
    }

    //Find the only two numbers in each row where one evenly divides the other - that is, where the result of the division operation is a whole number. They would like you to find those numbers on each line, divide them, and add up each line's result.
    private static int puzzle2(File file) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int total = 0;
        String line = reader.readLine();
        while (line != null) {
            boolean encontro = false;
            String[] valores = line.trim().split("\\s+");
            for (int i = 0; i < valores.length && !encontro; i++) {
                int actual = Integer.parseInt(valores[i]);
                for (int j = 0; j < valores.length && !encontro; j++) {
                    int actual2 = Integer.parseInt(valores[j]);
                    if(actual2!=actual)
                    {
                        if(actual%actual2==0)
                            {
                                encontro = true;
                                total += actual/actual2;
                            }
                    }
                }
            }
            line = reader.readLine();
        }
        return total;
    }

    public static void main(String[] args) throws IOException
    {
        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2017\\Day217\\input.txt");

        int sol1 = puzzle1(file);
        System.out.println("Checksum: " + sol1);

        int sol2 = puzzle2(file);
        System.out.println("Suma: " + sol2);
    }
}
