import java.util.*;

class Cifra {
    //verifica se é fim
    public static boolean isFim ( String s ) {
        return ( s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M' );
    }

    //cifra uma entrada com chave 3
    public static String cifra ( String s ) {
        String sai = "";
        for (int y = 0; y < s.length(); y++) {
            sai += ((char)(s.charAt(y) + 3));
            /** if ((int)s.charAt(y) != '?') {
            sai += ((char)(s.charAt(y) + 3));
            } else {
            sai += s.charAt(y);
            } 
            */
        }
        return sai;
    }

    //le e cifra uma entrada
    public static void main (String args[]) {
        String s;
        do {
            s = MyIO.readLine();
            MyIO.println(cifra(s));
        }
        while ( ! isFim(s) );
    }
}