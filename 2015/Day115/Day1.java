package Day115;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Day1 Not Quite Lisp
public class Day1
{
    //Reterna el valor de la posicion actual en la que termina Santa comenzando en 0, aumentando 1 en '(' y disminuyendo 1 en ')'
    public static int puzzle1(String data) throws IOException
    {
        int actualPos = 0;
        for (int i = 0; i < data.length(); i++)
            {
                Character c = data.charAt(i);
                if (c.equals('('))
                    actualPos++;
                else
                    actualPos--;
            }
        
        return actualPos;
    }

    //Retorna la posicion+1 de la instruccion '(' o ')' que hace que actualPos sea -1, es decir el momento en el que santa llega al sotano
    public static int puzzle2(String data)
    {
        int pos = 0;
        int actualPos = 0;
        for (int i = 0; i < data.length() && pos == 0; i++)
            {
                Character c = data.charAt(i);
                if (c.equals('('))
                    actualPos++;
                else
                    actualPos--;
                if(actualPos==-1)
                    pos = i+1;
            }
        
        return pos;
    }

    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day1\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String data = reader.readLine();
        reader.close();

        //Si puzzle1 no es static se debe invocar sobre un objeto creado
        //Day1 day1 = new Day1();
        //int sol1 = day1.puzzle1();
        int sol1 = puzzle1(data);
        System.out.println("Puzzle1:" + sol1);

        int sol2 = puzzle2(data);
        System.out.println("Puzzle2:" + sol2);
    }
}

