package Day315;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

//Day3 Perfectly Spherical Houses in a Vacuum
public class Day3Easier
{
    //Se desea conocer por cuantos puntos paso santa al menos una vez segun las instrucciones del input
    //Se podria hacer uso de la clase Point2d de java.awt.geom para crear los puntos pero no funciona.
    //Creamos una set hash de String con la concatenacion de las coordenadas de cada punto
    public static int puzzle1(String data)
    {
        Set<String> tabla = new HashSet<String>();
        int[] actual = new int[2];
        actual[0] = 0;
        actual[1] = 0;
        for(int i = 0; i <data.length(); i++)
        {
            char c = data.charAt(i);
            tabla.add("" + actual[0] + "" + actual[1]);
            actual = interpretar(c, actual);
        }      
        return tabla.size();
    }

    //Se desea conocer por cuantos puntos pasaron santa o el robot al menos una vez segun las instrucciones del input
    //hacemos lo mismo del puzzle 1 pero turnamos los input entre santa y el robot verificando si i es par o impar
    public static int puzzle2(String data)
    {
        Set<String> tabla = new HashSet<String>();
        int[] actualSanta = new int[2];
        actualSanta[0] = 0;
        actualSanta[1] = 0;
        int[] actualRobot = new int[2];
        actualRobot[0] = 0;
        actualRobot[1] = 0;
        for(int i = 0; i <data.length(); i++)
        {
            char c = data.charAt(i);
            if(i%2==0)
            {
                actualSanta = interpretar(c, actualSanta);
                tabla.add("" + actualSanta[0] + "" + actualSanta[1]);
            }
            else
            {
                actualRobot = interpretar(c, actualRobot);
                tabla.add("" + actualRobot[0] + "" + actualRobot[1]);
            }
            
        }      
        return tabla.size();
    }

    //clase que interpreta el caracter de entrada y crea un nuevo punto con las coordenadas correspodientes
    public static int[] interpretar(char c, int[] actual)
    {
        int x = actual[0];
        int y = actual[1];
        switch(c)
            {
            case '^':
                y+=1;
                break;
            case 'v':
                y-=1; 
                break;
            case '<':
                x-=1; 
                break;
            case '>':
                x+=1;
                break;
            }
        actual[0] = x;
        actual[1] = y;
        return actual;
    }
    public static void main(String[] args) throws Exception
    {
        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day315\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String data = reader.readLine();
        reader.close();

        int sol1 = puzzle1(data);
        System.out.println("Puzzle1: " + sol1);

        int sol2 = puzzle2(data);
        System.out.println("Puzzle2: " + sol2);
        
    }
    
}
