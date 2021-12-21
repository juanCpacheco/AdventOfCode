package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day6 
{
    //Se desea saber cuantas luces quedaron encendidas al seguir las instrucciones del input
    //donde Turn on: encender, Turn off: apagar y Toogle: enciende apagadas y apaga encendidas.
    private static int puzzle1(BufferedReader reader) throws IOException 
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
        private Boolean lit;

        public Luz(int x, int y)
        {
            this.x = x;
            this.y = y;
            this.lit = false;
        }
        public void setLit()
        {
            this.lit = true;
        }
        public void setOff()
        {
            this.lit = false;
        }
        public boolean getLit()
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

    //Clase que interpreta una instruccion, acctualiza el estado de una luz y el contador de luces encendidas
    public static int interpretar(Luz actual, String instruccion, int contador)
    {
        switch(instruccion)
        {
            case "turn on":
                if(!actual.getLit())
                {  
                    actual.setLit();
                    contador++;
                }
                break;
            case "turn off":
                if(actual.getLit())
                {
                    actual.setOff();
                    contador--;
                }
                break;
            case "toggle":
                if(actual.getLit())
                {
                    actual.setOff();
                    contador--;
                }
                else
                {
                    actual.setLit();
                    contador++;
                }
                break;
        }
        return contador;
    }
    /*
    public static int contarLit(ArrayList<Luz> luces)
    {
        int contador = 0;
        for(Luz actual : luces)
        {
            if(actual.getLit())
                contador++;
        }
        return contador;

    }
    */
    public static void main(String[] args) throws IOException
    {
        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day6\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int sol1 = puzzle1(reader);
        System.out.println("Luces prendidas: " + sol1);
    }

}
