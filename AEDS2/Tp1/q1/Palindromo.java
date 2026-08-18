import java.util.*;

//checa se a string é palindromo
class Palindromo {
    public static boolean isPalindromo ( String s ) {
        boolean result = true;
        for ( int y = 0; y < s.length()/2 && result; y++ ) {
            if ( s.charAt(y) != s.charAt(s.length() - y - 1) ) {
                result = false;
            }
        }
        return result;
    }

    //main que le entrada e retorna se é palindromo
    public static void main (String args[]) {
        String s;
        s = MyIO.readLine();
        while ( ! (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') ) {
            if ( isPalindromo(s) ) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            s = MyIO.readLine();
        }
    }
}
