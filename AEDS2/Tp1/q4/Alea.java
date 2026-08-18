import java.util.*;

class Alea {
    //testa se é fim
    public static boolean isFim ( String s ) {
        return ( s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //altera aleatoriamente uma string
    public static String decod ( String s ) {
        String temp = "";
        Random gerador = new Random();
        gerador.setSeed(4);
        char a = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        char b = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        for (int y = 0; y < s.length(); y++) {
            if ( s.charAt(y) == a ) {
                temp += b;
            } else {
                temp += s.charAt(y);
            }
        }
        return temp;
    }

    //le e retorna a alteracao
    public static void main ( String args[] ) {
        String s;
        do {
        s = MyIO.readLine();
        MyIO.println(decod(s));
        }
        while ( ! isFim(s) );
    }
}