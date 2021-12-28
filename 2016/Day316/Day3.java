package Day316;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {

    //Se desea conocer el numero de triangulos posibles del archivo donde cada linea indica los 3 lados1 del triangulo.
    //Un triangulo es posible si la suma de dos lados1 cualquiera es mayor al tercer lado.
    private static int puzzle1(File file) throws IOException{
        int posibles = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String triangulo = reader.readLine().trim();
        while(triangulo != null)
        {
            triangulo = triangulo.trim();
            String[] ladosString = triangulo.split("\\s+");
            int[] lados1 = new int[3];
            lados1[0] = Integer.parseInt(ladosString[0]);
            lados1[1] = Integer.parseInt(ladosString[1]);
            lados1[2] = Integer.parseInt(ladosString[2]);
            if(lados1[0]<lados1[1]+lados1[2] && lados1[1]<lados1[0]+lados1[2] && lados1[2]<lados1[0]+lados1[1])
                posibles++;
            triangulo = reader.readLine();
        }
        reader.close();
        return posibles;
    }
    //Se desea conocer el numero de triangulos posibles del archivo donde cada grupo vertical de tres valores indica los 3 lados1 del triangulo.
    //Un triangulo es posible si la suma de dos lados1 cualquiera es mayor al tercer lado.
    private static int puzzle2(File file) throws IOException{
        int posibles = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> columna1 = new ArrayList<String>();
        ArrayList<String> columna2 = new ArrayList<String>();
        ArrayList<String> columna3 = new ArrayList<String>();
        String linea = reader.readLine().trim();
        while(linea != null)
        {
            linea = linea.trim();
            String[] ladosString = linea.split("\\s+");
            columna1.add(ladosString[0]);
            columna2.add(ladosString[1]);
            columna3.add(ladosString[2]);
            linea = reader.readLine();
        }
        for(int i = 0; i < columna1.size(); i+=3)
        {
            int[] lados1 = new int[3];
            lados1[0] = Integer.parseInt(columna1.get(i));
            lados1[1] = Integer.parseInt(columna1.get(i + 1));
            lados1[2] = Integer.parseInt(columna1.get(i + 2));
            if(lados1[0]<lados1[1]+lados1[2] && lados1[1]<lados1[0]+lados1[2] && lados1[2]<lados1[0]+lados1[1])
                posibles++;

            int[] lados2 = new int[3];
            lados2[0] = Integer.parseInt(columna2.get(i));
            lados2[1] = Integer.parseInt(columna2.get(i + 1));
            lados2[2] = Integer.parseInt(columna2.get(i + 2));
            if(lados2[0]<lados2[1]+lados2[2] && lados2[1]<lados2[0]+lados2[2] && lados2[2]<lados2[0]+lados2[1])
                posibles++;
                
            int[] lados3 = new int[3];
            lados3[0] = Integer.parseInt(columna3.get(i));
            lados3[1] = Integer.parseInt(columna3.get(i + 1));
            lados3[2] = Integer.parseInt(columna3.get(i + 2));
            if(lados3[0]<lados3[1]+lados3[2] && lados3[1]<lados3[0]+lados3[2] && lados3[2]<lados3[0]+lados3[1])
                posibles++;
        }
        reader.close();
        return posibles;
     
    }
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day316\\input.txt");

        int sol1 = puzzle1(file);
        System.out.println("El numero de triangulos posibles para el puzzle1 es: " + sol1);

        int sol2 = puzzle2(file);
        System.out.println("El numero de triangulos posibles para el puzzle2 es: " + sol2);
 }
}
