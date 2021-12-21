package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day6Puzzle2
{
    //Se desea saber el brllo total al seguir las instrucciones del input (una luz tiene brillo de 0 en adelante)
    //donde Turn on: aumenta el brillo en 1, Turn off: disminuye el brillo en 1 y Toogle: aumenta el brillo en 2.
    private static int puzzle2(BufferedReader reader) throws IOException 
    {
        int contador = 0;
        ArrayList<Luz> luces = new ArrayList<Luz>();
        for (int i = 0; i < 1000; i++)
        {
            for (int j = 0; j < 1000; j++)
            {
               luces.add(new Luz(i, j));
            }
        }
        String linea = reader.readLine();
        while (linea != null)
        {
            String[] partesInstruccion = linea.split(" ");
            String instruccion = "";
            String[] desdeString = null;
            String[] hastaString = null;
            if(!partesInstruccion[0].equals("toggle"))
            {
               instruccion = partesInstruccion[0] + " " +partesInstruccion[1];
               desdeString = partesInstruccion[2].split(",");
               hastaString = partesInstruccion[4].split(",");
            }
            else
            {
                instruccion = "toggle";
                desdeString = partesInstruccion[1].split(",");
                hastaString = partesInstruccion[3].split(",");
            }

            int[] desde = new int[2];
            desde[0] = Integer.parseInt(desdeString[0]);
            desde[1] = Integer.parseInt(desdeString[1]);
            
            int[] hasta = new int[2];
            hasta[0] = Integer.parseInt(hastaString[0]);
            hasta[1] = Integer.parseInt(hastaString[1]);

            for(int i = 0; i < luces.size(); i++)
            {
                Luz actual = luces.get(i);
                if(actual.getX() >= desde[0] && actual.getX() <= hasta[0] && actual.getY() >= desde[1] && actual.getY() <= hasta[1])
                {
                    contador = interpretar(actual, instruccion, contador);
                }
            }
            linea = reader.readLine();
        }
        return contador;
    }    

    //Clase que repreenta una luz.
    private static class Luz
    {
        private int x, y;
        private int lit;

        public Luz(int x, int y)
        {
            this.x = x;
            this.y = y;
            this.lit = 0;
        }
        public void increase()
        {
            this.lit++;
        }
        public void decrease()
        {
            this.lit--;
        }
        public int getLit()
        {
            return this.lit;
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

    //Clase que interpreta una instruccion, actualiza el brillo de una luz y el contador de brillo total.
    public static int interpretar(Luz actual, String instruccion, int contador)
    {
        switch(instruccion)
        {
            case "turn on":
                actual.increase();
                contador++;
                break;
            case "turn off":
                if(actual.getLit()!=0)
                {
                    actual.decrease();
                    contador--;
                }
                break;
            case "toggle":
                actual.increase();
                actual.increase();
                contador++;
                contador++;
                break;
        }
        return contador;
    }

    public static void main(String[] args) throws IOException
    {
        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day6\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int sol1 = puzzle2(reader);
        System.out.println("Brillo total incrementado : " + sol1);
    }

}
