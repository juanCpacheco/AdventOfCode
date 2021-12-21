package Day415;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//Day4 The Ideal Stocking Stuffer
public class Day4 
{
    //Busca el numero que al unirse con el input(input+num) genera un MD5 hash que en hexadecimal comienza por n ceros que llegan por parametro
    public static int puzzles(String key, int ceros) throws UnsupportedEncodingException, NoSuchAlgorithmException 
    {
        boolean cumple = false;
        int i = 0;
        while (!cumple) 
        {
            String newKey = key + i;
            cumple = verificar(newKey, ceros);
            i++;
        }
        i--;
        return i;
    }
    
    private static boolean verificar(String key, int ceros) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        //Opcion1 -----------------------------------------------------
        //byte[] bytes = key.getBytes();
        //MessageDigest md = MessageDigest.getInstance("MD5");
        //md.update(bytes);
        //byte[] theMD5digest = md.digest(bytes);
        //-------------------------------------------------------------------------

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(key.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);
        while (hashtext.length() < 32)
            hashtext = "0" + hashtext;

        return probar(hashtext, ceros);
    }

    private static boolean probar(String hashtext, int ceros) 
    {
        String n = "";
        for(int i = 0; i < ceros; i++)
            n += "0";

        return hashtext.startsWith(n);
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        //System.out.println("Ingrese llave. ");
        //String key = System.console().readLine();
        int sol1 = puzzles("yzbqklnj", 5);
        System.out.println("Numero puzzle1: " + sol1);

        int sol2 = puzzles("yzbqklnj", 6);
        System.out.println("Numero puzzle2: " + sol2);
    }
}
