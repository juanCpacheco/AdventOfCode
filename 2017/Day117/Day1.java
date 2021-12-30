package Day117;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Day1 Inverse Captcha
//Find the sum of all digits that match the next digit in the list
public class Day1 {

    private static int puzzle1(String linea) {
        int total = 0;
        for(int i = 0; i < linea.length(); i++)
        {
            int primero = Integer.valueOf(String.valueOf(linea.charAt(i)));
            int segundo = 0;
            if(i != linea.length() - 1)
                segundo = Integer.valueOf(String.valueOf(linea.charAt(i+1)));
            else
                segundo = Integer.valueOf(String.valueOf(linea.charAt(0)));
            if(primero == segundo)
                total += primero;
        }
        return total;
    }

    //Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list.
    //That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it.     
    private static int puzzle2(String linea) {
        int total = 0;
        int posSeg = 0;
        int pasos = linea.length()/2;
        for(int i = 0; i < linea.length(); i++)
        {
            int primero = Integer.valueOf(String.valueOf(linea.charAt(i)));
            int segundo = 0;
            if(i < linea.length() - pasos)
                segundo = Integer.valueOf(String.valueOf(linea.charAt(i+pasos)));
            else
            {
                segundo = Integer.valueOf(String.valueOf(linea.charAt(posSeg)));
                posSeg++;
            }
            if(primero == segundo)
                total += primero;
        }
        return total;
    }

    public static void main(String[] args) throws IOException
    {
        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2017\\Day117\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String linea = reader.readLine();
        reader.close();
        int sol1 = puzzle1(linea);
        System.out.println("La solucion al captcha es = " + sol1);
        int sol2 = puzzle2(linea);
        System.out.println("La solucion al captcha2 es = " + sol2);
    }

}
