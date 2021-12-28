package Day416;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day4 {
    
    private static ArrayList<String> reales = new ArrayList<String>();

    private static int puzzle1(File file) throws IOException{
        int total = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String room = reader.readLine();
        while(room != null)
        {
            room = room.trim();
            String[] tokens = room.split("-");
            String ultimo = tokens[tokens.length - 1];
            tokens[tokens.length - 1] = "";
            String nombre = String.join("", tokens);
            String id = ultimo.split("\\[")[0];
            String clave = ultimo.split("\\[")[1];

            char[] nom = nombre.toCharArray();
            Arrays.sort(nom);
            nombre = new String(nom);
            boolean es = true;
            for (int i = 0; i < clave.length()-1 && es; i++)
            {
                Character c = clave.charAt(i);
                Character masRepetido = null;
                int masVeces = 0;
                for(int j = 0; j < nombre.length(); j++)
                {
                    int cont = 1;
                    Character actual = nombre.charAt(j);
                    for(int k = j+1; k < nombre.length(); k++)
                    {
                        if(nombre.charAt(k) != actual)
                            break;
                        cont++;
                        j++;
                    }
                    if(cont > masVeces)
                    {
                        masRepetido = actual;
                        masVeces = cont;
                    }
                }
                if(masRepetido!=c)
                    es = false;
                else
                    nombre = nombre.replace(masRepetido.toString(), "");
            }
            if(es)
            {
                String completo = String.join(" ", tokens);
                reales.add(completo + id);
                total += Integer.parseInt(id);
            }
            room = reader.readLine();
        }
        reader.close();
        return total;
    }

    private static int puzzle2() {
        
        int id = 0;
        for (int i = 0; i < reales.size(); i++)
        {
            String roomDecode = "";
            String[] palabras = reales.get(i).split(" ");
            int idActual = Integer.parseInt(palabras[palabras.length-1]);
            for (int j = 0; j < palabras.length-1; j++)
            {
                roomDecode += decodificar(palabras[j], idActual) + " ";
            }
            if(roomDecode.trim().equals("northpole object storage"))
            {
                id = idActual;
                break;
            }
        }
        return id;
    }

    public static String decodificar(String cadenaOriginal, int id) 
    {    
        final int LONGITUD_ALFABETO = 26, INICIO_MINUSCULAS = 97, INICIO_MAYUSCULAS = 65;
		String decodificada = "";

		for (int x = 0; x < cadenaOriginal.length(); x++) {
			char caracterActual = cadenaOriginal.charAt(x);
			// Si no es una letra del alfabeto entonces ponemos el char tal y como está
			// y pasamos a la siguiente iteración
			if (!Character.isLetter(caracterActual)) {
				decodificada += caracterActual;
				continue;
			}

			int codigoAsciiDeCaracterActual = (int) caracterActual;
			boolean esMayuscula = Character.isUpperCase(caracterActual);

			// La posición (1 a 26) que ocupará la letra después de ser rotada
			int nuevaPosicionEnAlfabeto = ((codigoAsciiDeCaracterActual
					- (esMayuscula ? INICIO_MAYUSCULAS : INICIO_MINUSCULAS)) + id) % LONGITUD_ALFABETO;
			// Arreglar rotaciones negativas
			if (nuevaPosicionEnAlfabeto < 0)
				nuevaPosicionEnAlfabeto += LONGITUD_ALFABETO;
			int nuevaPosicionAscii = (esMayuscula ? INICIO_MAYUSCULAS : INICIO_MINUSCULAS) + nuevaPosicionEnAlfabeto;
			// Convertir el código ASCII numérico a su representación como símbolo o letra y
			// concatenar
			decodificada += Character.toString((char) nuevaPosicionAscii);
		}
		return decodificada;
    }

    public static void main(String[] args) throws IOException
    {
        File file = new File("C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day416\\input.txt");

        int sol1 = puzzle1(file);
        System.out.println("El numero de real rooms es: " + sol1);

        int sol2 = puzzle2();
        System.out.println("El id del cuarto con los objetos del polo norte es: " + sol2);
    }
}
