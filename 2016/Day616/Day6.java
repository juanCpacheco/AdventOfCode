package Day616;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//Day6 Probably a Fire Hazard

public class Day6 {
    
    //Se desea conocer las claves secretas conformadas por la letra que mas y menos se repite respectivamente de cada columna del input 
    public static String[] puzzles(BufferedReader reader) throws IOException 
    {
        String[] respuesta = new String[2];
        ArrayList<ArrayList<String>> columnas = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 8; i++)
            columnas.add(new ArrayList<String>());
        String linea  = reader.readLine();
        while (linea != null)
        {
            for (int i = 0; i < linea.length(); i++)
            {
                String letra = String.valueOf(linea.charAt(i));
                columnas.get(i).add(letra);
            }
            linea = reader.readLine();
        }

        String clave1 = "";
        String clave2 = "";
        for (ArrayList<String> columna: columnas)
        {
            Set<String> st = new HashSet<String>(columna); 
            String masRepetida = "";
            int masVeces = 0;
            String menosRepetida = "";
            int menosVeces = columna.size();
            Collections.sort(columna);
            for (String actual: st)
            {
                int veces = Collections.frequency(columna, actual);
                if (veces > masVeces)
                {
                    masVeces = veces;
                    masRepetida = actual;
                }
                if (veces < menosVeces)
                {
                    menosVeces = veces;
                    menosRepetida = actual;
                }
            }
            clave1 += masRepetida;
            clave2 += menosRepetida;
        }
        respuesta[0] = clave1;
        respuesta[1] = clave2;
        return respuesta;
        
    }
    public static void main(String[] args) throws IOException{

        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day616\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String[] sol = puzzles(reader);
        System.out.println("La clave1 es: " + sol[0]);
        System.out.println("La clave2 es: " + sol[1]);
    }
}
