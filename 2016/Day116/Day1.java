package Day116;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Day1 No Time for a Taxicab
public class Day1 {

    enum Dir {
        N, S, E, W;
    }

    //Se desea conocer la distancia a la que termina respento al punto inicial (0,0) al seguir las instrucciones donde R y L son giros de 90° y el numero son los pasos que da en esta direccion
    //Para calcular la distancia se utilizo la geometria del taxista
    public static int puzzle1(BufferedReader reader) throws IOException {
        String linea = reader.readLine();
        String[] instrucciones = linea.split(", ");
        int[] pos = new int[2];
        pos[0] = 0;
        pos[1] = 0;
        Dir direccion = Dir.N;

        for (int i = 0; i < instrucciones.length; i++) {
            String actual = instrucciones[i];
            char nuevaDir = actual.charAt(0);
            String StringPasos = "";
            for (int j = 1; j < actual.length(); j++) 
            {
                StringPasos += actual.charAt(j);
            }
            int pasos = Integer.parseInt(StringPasos);
            direccion = cambiarDir(direccion, nuevaDir);
            pos = cambiarPos(direccion, pos, pasos);
        }
        return Math.abs(pos[0]) + Math.abs(pos[1]);
    }

   //Indica en que posicion queda tras avanzar los pasos que llegan por parametro en la direccion que llega por parametro
    private static int[] cambiarPos(Dir direccion, int[] pos, int pasos) {
        if (direccion == Dir.N)
            pos[1] = pos[1] + pasos;
        else if (direccion == Dir.E)
            pos[0] = pos[0] + pasos;
        else if (direccion == Dir.S)
            pos[1] = pos[1] - pasos;
        else
            pos[0] = pos[0] - pasos;
        return pos;
    }

    //Cambia la direccion hacia la cual caminara segun el giro que deba realizar
    private static Dir cambiarDir(Dir direccion, char nuevaDir) {
        switch (nuevaDir) {
            case 'R':
                if (direccion == Dir.N)
                    direccion = Dir.E;
                else if (direccion == Dir.E)
                    direccion = Dir.S;
                else if (direccion == Dir.S)
                    direccion = Dir.W;
                else
                    direccion = Dir.N;
                break;
            case 'L':
                if (direccion == Dir.N)
                    direccion = Dir.W;
                else if (direccion == Dir.W)
                    direccion = Dir.S;
                else if (direccion == Dir.S)
                    direccion = Dir.E;
                else
                    direccion = Dir.N;
                break;

        }
        return direccion;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day116\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int sol1 = puzzle1(reader);
        System.out.println("Esta a " + sol1 + " bloques");
    }
}