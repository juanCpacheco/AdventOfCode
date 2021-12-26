package Day215;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Day2 I Was Told There Would Be No Math
public class Day2 
{
    //se desea el area total del papel de regalo que se necesita
    public static int puzzle1(File file) throws IOException 
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int resp1 = 0;
        String linea = reader.readLine();
        while(linea != null)
        {
            String[] dimensiones = linea.split("x");
            int l = Integer.parseInt(dimensiones[0]);
            int w = Integer.parseInt(dimensiones[1]);
            int h = Integer.parseInt(dimensiones[2]);
            
            List<Integer> areas = new ArrayList<Integer>();
            areas.add(l*w);
            areas.add(h*w);
            areas.add(h*l);
            Collections.sort(areas);
            int areaInicial = 2*(areas.get(0) + areas.get(1) + areas.get(2));
            int areaExtra = areas.get(0);
            int areaTotal = areaInicial + areaExtra;

            resp1 += areaTotal;
            linea = reader.readLine();
        }
        reader.close();
        return resp1;
    } 
    
    //Se desea saber la longitud total de la cinta para los regalos
    public static int puzzle2(File file) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int resp2 = 0;
        String linea = reader.readLine();
        while(linea != null)
        {
            String[] dimensiones = linea.split("x");
            int l = Integer.parseInt(dimensiones[0]);
            int w = Integer.parseInt(dimensiones[1]);
            int h = Integer.parseInt(dimensiones[2]);

            ArrayList<Integer> dim = new ArrayList<Integer>();
            dim.add(l);
            dim.add(w);
            dim.add(h);

            Collections.sort(dim);
            int longInicial = 2*(dim.get(0) + dim.get(1));
            int longExtra = l*w*h;
            int longTotal = longInicial + longExtra;

            resp2 += longTotal;
            linea = reader.readLine();
        }
        reader.close();
        return resp2;
    }


public static void main(String[] args) throws IOException
 {
     File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day215\\input.txt");
     
     int areaTotal = puzzle1(file);
     System.out.println("Area total: " + areaTotal);

     int cintaTotal = puzzle2(file);
     System.out.println("Cinta total: " + cintaTotal);
 }

}
