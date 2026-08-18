import java.util.*;

class Password {
    //metodo que verifica validade de senha 
    public static boolean p ( String s ) {
        boolean EightChar = s.length() >= 8;
        boolean Maiuscula = false;
        boolean Minuscula = false;
        boolean Numero = false;
        boolean Especial = false;
        for ( int y = 0; y<s.length(); y++ ) {
            if ( !Maiuscula && 'A' <= s.charAt(y) && s.charAt(y) <= 'Z' ) {
                Maiuscula = true;
            }
            if ( !Minuscula &&'a' <= s.charAt(y) && s.charAt(y) <= 'z' ) {
                Minuscula = true;
            }
            if ( !Numero && '0' <= s.charAt(y) && s.charAt(y) <= '9' ) {
                Numero = true;
            }
            if ( !Especial && ( (32 <= s.charAt(y) && s.charAt(y) <= 47) || (58 <= s.charAt(y) && s.charAt(y) <= 64) || (91 <= s.charAt(y) && s.charAt(y) <= 96) || (123 <= s.charAt(y) && s.charAt(y) <= 126)) ) {
                Especial = true;
            }
        }
        return EightChar && Maiuscula && Minuscula && Numero && Especial;
    }

    //metodo que verifica se entrada é "FIM"
    public static boolean f(String s) {
        return ( s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M' );
    }

    //metodo que retonra sim ou nao caso a senha for valida ou nao, respectivamente
    public static void main ( String args[] ) {
        String s = "";
        Scanner o = new Scanner(System.in);
        s = o.nextLine();
        while ( ! f(s) ) {
            if (p(s)) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
            s = o.nextLine();
        }
    }
}