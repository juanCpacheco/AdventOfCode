
public class prueba {

    public static String getName() {
        String respuesta = "siguiente";
        return respuesta;
    }

    public static void main(String[] args) {
        String[] tokens = {"hola", "chao", "ultimo"};
        String tok = String.join(", ", tokens);
        System.out.println(tok);
        tokens[tokens.length - 1] = null;
        tok = String.join(", ", tokens);
        System.out.println(tok);
    }

}
