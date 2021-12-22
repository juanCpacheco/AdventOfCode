package Day116;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day1Puzzle2 {
    enum Dir {
        N, S, E, W;
    }

    //Se desea saber a que distancia segun la geometria del taxista se encuentra el primer punto por el cual pasa dos veces
    //para ellos se creo un setHash con los id de los puntos que visitaba y en caso que que ya lo haya visitado se marca como repetido y lo retorna
    public static int puzzle2(BufferedReader reader) throws IOException {
        Set<String> tabla = new HashSet<String>();
        String linea = reader.readLine();
        String[] instrucciones = linea.split(", ");
        Punto pos = new Punto(0, 0);
        tabla.add(pos.getId());
        Dir direccion = Dir.N;

        for (int i = 0; i < instrucciones.length && !pos.isRepetido(); i++) {
            String actual = instrucciones[i];
            char nuevaDir = actual.charAt(0);
            String StringPasos = "";
            for (int j = 1; j < actual.length(); j++) {
                StringPasos += actual.charAt(j);
            }
            int pasos = Integer.parseInt(StringPasos);
            direccion = cambiarDir(direccion, nuevaDir);
            pos = cambiarPos(direccion, pos, pasos, tabla);
        }
        return Math.abs(pos.getX()) + Math.abs(pos.getY());
    }

    //Se realiza el avance paso a paso en la direccion que llega por parametro para poder identificar cada punto que atravieza y verificar si ya se habia pasado por ahi o de lo contrario se añade a la tabla hash
    private static Punto cambiarPos(Dir direccion, Punto pos, int pasos, Set<String> tabla) throws IOException {
        if (direccion == Dir.N) {
            for (int i = 0; i < pasos && !pos.isRepetido(); i++) {
                Punto nuevo = new Punto(pos.getX(), pos.getY() + 1);
                if (!tabla.contains(nuevo.getId()))
                    tabla.add(nuevo.getId());
                else
                    nuevo.setRepetido();
                pos = nuevo;
            }
        } else if (direccion == Dir.E)
            for (int i = 0; i < pasos && !pos.isRepetido(); i++) {
                Punto nuevo = new Punto(pos.getX() + 1, pos.getY());
                if (!tabla.contains(nuevo.getId()))
                    tabla.add(nuevo.getId());
                else
                    nuevo.setRepetido();
                pos = nuevo;
            }
        else if (direccion == Dir.S)
            for (int i = 0; i < pasos && !pos.isRepetido(); i++) {
                Punto nuevo = new Punto(pos.getX(), pos.getY() - 1);
                if (!tabla.contains(nuevo.getId()))
                    tabla.add(nuevo.getId());
                else
                    nuevo.setRepetido();
                pos = nuevo;
            }
        else
            for (int i = 0; i < pasos && !pos.isRepetido(); i++) {
                Punto nuevo = new Punto(pos.getX() - 1, pos.getY());
                if (!tabla.contains(nuevo.getId()))
                    tabla.add(nuevo.getId());
                else
                    nuevo.setRepetido();
                pos = nuevo;
            }
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

    // Clase que repreenta un punto con id (concatenacion de sus coordenadas)
    private static class Punto {
        private int x, y;
        String id;
        boolean repetido;

        public Punto(int x, int y) {
            this.x = x;
            this.y = y;
            id = "" + x + y;
            this.repetido = false;
        }

        public String getId() {
            return this.id;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public boolean isRepetido() {
            return repetido;
        }

        public void setRepetido() {
            this.repetido = true;
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day116\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int sol2 = puzzle2(reader);
        System.out.println("La primera posicion que visita dos veces esta a " + sol2 + " bloques");
    }
}
