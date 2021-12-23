package Day216;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

    // Se desea conocer la clave de 5 digitos los cuales se descubren al seguir cada
    // linea correspondiente del input donde U indica un movimiento hacia arriba
    // D hacia abajo, R hacia la derecha y L hacia la izquierda partiendo desde 5 en
    // una grilla de digitos 3x3.
    public static String puzzle1(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String clave = "";
        int actual = 5;
        String linea = reader.readLine();
        while (linea != null) {
            for (int i = 0; i < linea.length(); i++) {
                Character instruccion = linea.charAt(i);
                switch (instruccion) {
                    case 'U':
                        if (actual != 1 && actual != 2 && actual != 3)
                            actual = actual - 3;
                        break;
                    case 'D':
                        if (actual != 7 && actual != 8 && actual != 9)
                            actual = actual + 3;
                        break;
                    case 'R':
                        if (actual != 3 && actual != 6 && actual != 9)
                            actual = actual + 1;
                        break;
                    case 'L':
                        if (actual != 1 && actual != 4 && actual != 7)
                            actual = actual - 1;
                        break;
                }
            }
            clave += actual;
            linea = reader.readLine();
        }
        reader.close();
        return clave;
    }

    // Se desea conocer la clave de 5 digitos los cuales se descubren al seguir cada
    // linea correspondiente del input donde U indica un movimiento hacia arriba
    // D hacia abajo, R hacia la derecha y L hacia la izquierda partiendo desde 5 en
    // la siguiente grilla
    //     1
    //   2 3 4
    // 5 6 7 8 9
    //   A B C
    //     D
    public static String puzzle2(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String clave = "";
        String actual = "5";
        String linea = reader.readLine();
        while (linea != null) {
            for (int i = 0; i < linea.length(); i++) {
                Character instruccion = linea.charAt(i);
                switch (instruccion) {
                    case 'U':
                        actual = sube(actual);
                        break;
                    case 'D':
                        actual = baja(actual);
                        break;
                    case 'R':
                        actual = derecha(actual);
                        break;
                    case 'L':
                        actual = izquierda(actual);
                        break;
                }
            }
            clave += actual;
            linea = reader.readLine();
        }
        reader.close();
        return clave;
    }

    private static String izquierda(String actual) {
        switch (actual.charAt(0)) {
            case '6':
                actual = "5";
                break;
            case '3':
                actual = "2";
                break;
            case '7':
                actual = "6";
                break;
            case 'B':
                actual = "A";
                break;
            case 'C':
                actual = "B";
                break;
            case '8':
                actual = "7";
                break;
            case '4':
                actual = "3";
                break;
            case '9':
                actual = "8";
                break;
            default:
        }
        return actual;
    }

    private static String derecha(String actual) {
        switch (actual.charAt(0)) {
            case '8':
                actual = "9";
                break;
            case '3':
                actual = "4";
                break;
            case '7':
                actual = "8";
                break;
            case 'B':
                actual = "C";
                break;
            case 'A':
                actual = "B";
                break;
            case '6':
                actual = "7";
                break;
            case '2':
                actual = "3";
                break;
            case '5':
                actual = "6";
                break;
            default:
        }
        return actual;
    }

    private static String baja(String actual) {
        switch (actual.charAt(0)) {
            case '2':
                actual = "6";
                break;
            case '1':
                actual = "3";
                break;
            case '4':
                actual = "8";
                break;
            case '6':
                actual = "A";
                break;
            case '7':
                actual = "B";
                break;
            case '8':
                actual = "C";
                break;
            case 'B':
                actual = "D";
                break;
            case '3':
                actual = "7";
                break;
            default:
        }
        return actual;
    }

    private static String sube(String actual) {
        switch (actual.charAt(0)) {
            case '3':
                actual = "1";
                break;
            case '6':
                actual = "2";
                break;
            case '7':
                actual = "3";
                break;
            case '8':
                actual = "4";
                break;
            case 'A':
                actual = "6";
                break;
            case 'B':
                actual = "7";
                break;
            case 'C':
                actual = "8";
                break;
            case 'D':
                actual = "B";
                break;
            default:
        }
        return actual;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day216\\input.txt");

        String sol1 = puzzle1(file);
        System.out.println("La clave del puzzle1 es: " + sol1);

        String sol2 = puzzle2(file);
        System.out.println("La clave del puzzle2 es: " + sol2);
    }
}