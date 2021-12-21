package Day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Day5 Doesn't He Have Intern-Elves For This?
public class Day5 
{
    //Retorna el numero de cadenas que cumplen con las condiciones 1,2 y 3
    public static int puzzle1(BufferedReader reader) throws IOException
    {
        int contador = 0;
        String line = reader.readLine();
        while( line != null)
        {
            line = line.toLowerCase();
            if(condicion1(line) && condicion2(line) && condicion3(line))
                contador ++;
            line = reader.readLine();
        }
        return contador;
    }

    //La cadena tiene por lo menos 3 vocales
    private static boolean condicion1(String line) 
    {
        int contVocales = 0;
        for(int i = 0; i < line.length() && contVocales < 3; i++)
        {
            Character c = line.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                contVocales++;
        }
        if(contVocales == 3)
            return true;
        return false;
    }

    //La cadena tiene por lo menos una letra que aparece 2 veces seguidas
    private static boolean condicion2(String line) 
    {
        for(int i = line.length()-1; i > 0; i--)
        {
            if(line.charAt(i)==line.charAt(i-1))
                return true;
        }
        return false;
    }

    //La cadena no contiene los Strings ab, cd, pq o xy
    private static boolean condicion3(String line) 
    {
        for(int i = line.length()-1; i > 0; i--)
        {
            String pareja = "" + line.charAt(i-1) + line.charAt(i);
            if(pareja.equals("ab") || pareja.equals("cd") || pareja.equals("pq") || pareja.equals("xy"))
                return false;
        }
        return true;
    }
    //Retorna el numero de cadenas que cumplen con las condiciones 4 y 5
    public static int puzzle2(BufferedReader reader2) throws IOException
    {
        int contador = 0;
        String line = reader2.readLine();
        while( line != null)
        {
            line = line.toLowerCase();
            if(condicion4(line) && condicion5(line))
                contador ++;
            line = reader2.readLine();
        }
        return contador;
    }

    //La cadena tiene por lo menos un par de letras que aparece 2 veces
    private static boolean condicion4(String line) 
    {
        for(int i = line.length()-1; i > 2; i--)
        {
            String pareja = "" + line.charAt(i-1) + line.charAt(i);
            for(int j = i-2; j > 0; j--)
            {
                String pareja2 = "" + line.charAt(j-1) + line.charAt(j);
                if(pareja.equals(pareja2))
                    return true;
            }
        }
        return false;
    }

    //La cadena tiene por lo menos una letra que se repite con exactamente 1 letra en medio
    private static boolean condicion5(String line) 
    {
        for(int i = line.length()-1; i > 1; i--)
        {
            if(line.charAt(i)==line.charAt(i-2))
                return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException
    {
        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day5\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int sol1 = puzzle1(reader);
        System.out.println("Cadenas nice puzzle1: " + sol1);
        reader.close();

        BufferedReader reader2 = new BufferedReader(new FileReader(file));
        int sol2 = puzzle2(reader2);
        System.out.println("Cadenas nice puzzle2: " + sol2);
        reader2.close();
    }    
}
