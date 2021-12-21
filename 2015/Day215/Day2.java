package Day215;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
            //Se divide la linea para identificar las dimensiones
            String[] dimensiones = linea.split("x");
            int l = Integer.parseInt(dimensiones[0]);
            int w = Integer.parseInt(dimensiones[1]);
            int h = Integer.parseInt(dimensiones[2]);
            
            //Se calcula el area de las caras y se añaden a un arreglo
            int areaCara1 = l*w;
            int areaCara2 = w*h;
            int areaCara3 = h*l;
            ArrayList<Integer> areas = new ArrayList<Integer>();
            areas.add(areaCara1);
            areas.add(areaCara2);
            areas.add(areaCara3);

            //Se calcula el area total necesitada para la caja
            int areaInicial = 2*(areaCara1 + areaCara2 + areaCara3);
            int areaExtra = areas.get(min(areas));
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
            //Se divide la linea para identificar las dimensiones
            String[] dimensiones = linea.split("x");
            int l = Integer.parseInt(dimensiones[0]);
            int w = Integer.parseInt(dimensiones[1]);
            int h = Integer.parseInt(dimensiones[2]);

            ArrayList<Integer> dim = new ArrayList<Integer>();
            dim.add(l);
            dim.add(w);
            dim.add(h);
            //Se calcula el minimo de las dimensiones y se elimina de la lista X2
            //Tambien podria usar API stream que toma un Array y retorna una secuencia y cuenta con metodos como min()
            int posMin1 = min(dim);
            int min1 = dim.get(posMin1);
            dim.remove(posMin1);
            int posMin2 = min(dim);
            int min2 = dim.get(posMin2);
            dim.remove(posMin2);

            int longInicial = 2*(min1 + min2);
            int longExtra = l*w*h;
            int longTotal = longInicial + longExtra;

            resp2 += longTotal;
            linea = reader.readLine();
        }
        reader.close();
        return resp2;
    }

    //Retorna la pisicion del valor minimo en un arreglo de enteros
    public static int min(ArrayList<Integer> lista)
    {
        int pos = 0;
        int min = lista.get(0);
        for(int i = 1; i < lista.size(); i++)
        {
            if(lista.get(i)<min)
            {
                min = lista.get(i);
                pos = i;
            }
        }
        return pos;
    }

public static void main(String[] args) throws IOException
 {
     File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day2\\input.txt");
     
     int areaTotal = puzzle1(file);
     System.out.println("Area total: " + areaTotal);

     int cintaTotal = puzzle2(file);
     System.out.println("Cinta total: " + cintaTotal);
 }

}
