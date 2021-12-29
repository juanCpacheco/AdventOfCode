package Day516;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//Day5 How About a Nice Game of Chess?
public class Day5 {
    public static String puzzles(String key, int ceros) throws UnsupportedEncodingException, NoSuchAlgorithmException 
    {
        int i = 0;
        String clave = "";
        while (clave.length()<8) 
        {
            String newKey = key + i;
            String dig = verificar(newKey, ceros);
            if (!dig.equals(""))
                clave += dig;
            i++;
        }
        return clave;
    }

    public static String puzzle2(String key, int ceros) throws UnsupportedEncodingException, NoSuchAlgorithmException 
    {
        int i = 0;
        int digitosResueltos = 0;
        String[] clave = new String[8];
        while(digitosResueltos<8)  
        {
            String newKey = key + i;
            String[] posDig = verificar2(newKey, ceros);
            if (posDig!=null && clave[Integer.parseInt(posDig[0])] == null)
            {
                clave[Integer.parseInt(posDig[0])] = posDig[1];
                digitosResueltos++;
            }
            i++;
        }
        return String.join("", clave);
    }
    
    private static String verificar(String key, int ceros) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        boolean cumple = false;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(key.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);

        String hashtext = no.toString(16);
        while (hashtext.length() < 32)
            hashtext = "0" + hashtext;
        cumple = probar(hashtext, ceros);
        if(cumple)
        {
            return String.valueOf(hashtext.charAt(5));
        }
        return "";
    }

    private static String[] verificar2(String key, int ceros) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        String[] respuesta = new String[2];
        boolean cumple = false;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(key.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);

        String hashtext = no.toString(16);
        while (hashtext.length() < 32)
            hashtext = "0" + hashtext;
        cumple = probar(hashtext, ceros);
        Character pos = hashtext.charAt(5);
        if(cumple && Character.isDigit(pos) && Character.getNumericValue(pos)<8)
        {
            respuesta[0] = String.valueOf(pos);
            respuesta[1] = String.valueOf(hashtext.charAt(6));
            return respuesta;
        }
        return null;
    }

    private static boolean probar(String hashtext, int ceros) 
    {
        String n = "";
        for(int i = 0; i < ceros; i++)
            n += "0";
        return hashtext.startsWith(n);
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException
    {
        String sol1 = puzzles("uqwqemis", 5);
        System.out.println("Clave puzzle1: " + sol1);

        String sol2 = puzzle2("uqwqemis", 5);
        System.out.println("Clave puzzle2: " + sol2);
    }
}
