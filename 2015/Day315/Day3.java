package Day315;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

//Day3 Perfectly Spherical Houses in a Vacuum
public class Day3
{
    //Se desea conocer por cuantos puntos paso santa al menos una vez segun las instrucciones del input
    //Se podria hacer uso de la clase Point2d de java.awt.geom para crear los puntos pero no funciona.
    //Creamos una set hash de Strings con los id de cada punto
    public static int puzzle1(String data)
    {
        Set<String> tabla = new HashSet<String>();
        Punto ActualSanta = new Punto(0, 0);
        tabla.add(ActualSanta.getId());

        for(int i = 0; i <data.length(); i++)
        {
            char c = data.charAt(i);
            ActualSanta = interpretar(c, ActualSanta);
            tabla.add(ActualSanta.getId());
        }      
        return tabla.size();
    }

    //Se desea conocer por cuantos puntos pasaron santa o el robot al menos una vez segun las instrucciones del input
    //hacemos lo mismo del puzzle 1 pero turnamos los input entre santa y el robot verificando si i es par o impar
    public static int puzzle2(String data)
    {
        Set<String> tabla = new HashSet<String>();
        Punto ActualSanta = new Punto(0, 0);
        Punto ActualRobot = new Punto(0, 0);

        tabla.add(ActualSanta.getId());
        tabla.add(ActualRobot.getId());

        for(int i = 0; i <data.length(); i++)
        {
            char c = data.charAt(i);
            if(i%2==0)
            {
                ActualSanta = interpretar(c, ActualSanta);
                tabla.add(ActualSanta.getId());
            }
            else
            {
                ActualRobot = interpretar(c, ActualRobot);
                tabla.add(ActualRobot.getId());
            }
            
        }      
        return tabla.size();
    }

    //Clase que repreenta un punto con id (concatenacion de sus coordenadas)
    private static class Punto
    {
        private int x, y;
        String id;
        public Punto(int x, int y)
        {
            this.x = x;
            this.y = y;
            id = "" + x + y;
        }
        public String getId()
        {
            return this.id;
        }
        public int getX()
        {
            return this.x;
        }
        public int getY()
        {
            return this.y;
        }
    }

    //clase que interpreta el caracter de entrada y crea un nuevo punto con las coordenadas correspodientes
    public static Punto interpretar(char c, Punto actual)
    {
        switch(c)
        {
            case '^':
                actual = new Punto(actual.getX(), actual.getY()+1);
                break;
            case 'v':
                actual = new Punto(actual.getX(), actual.getY()-1);
                break;
            case '<':
                actual = new Punto(actual.getX()-1, actual.getY());
                break;
            case '>':
                actual = new Punto(actual.getX()+1, actual.getY());
                break;
        }
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
