import java.util.*;

class Substring {
    //metodo que verifica se entrada é "FIM"
    public static boolean f(String s) {
        return ( s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M' );
    }

    //metodo que retorna length da substring mais longa de um trecho de uma string
    public static int substrings ( int a, int b, String s, boolean invertido ) {
        String temp = "";
        int sum = 0;
        if ( ! invertido ) {
            for ( int y = a; y<=b; y++ ) {
                for ( int z = 0; z<temp.length(); z++ ) {
                    if ( s.charAt(y) == temp.charAt(z) ) {
                        if ( sum < temp.length() ) { sum = temp.length(); }
                        temp = "";
                    }
                }
                temp += s.charAt(y);
            }
        } else {
            for ( int y = b; y>=a; y-- ) {
                for ( int z = 0; z<temp.length(); z++ ) {
                    if ( s.charAt(y) == temp.charAt(z) ) {
                        if ( sum < temp.length() ) { sum = temp.length(); }
                        temp = "";
                    }
                }
                temp += s.charAt(y);
            }
        }
        
        if ( sum < temp.length() ) { sum = temp.length(); }
        return sum;
    }

    //metodo que retorna length da substring mais longa de uma string
    public static int sub ( String s ) {
        String temp = "";
        int sum = 0;
        for ( int y = 0; y<s.length(); y++ ) {
            for ( int z = 0; z<temp.length(); z++ ) {
                if ( s.charAt(y) == temp.charAt(z) ) {
                    if ( sum < temp.length() ) { sum = temp.length(); }
                    temp = "";
                }
            }
            temp += s.charAt(y);
        }
        if ( sum < temp.length() ) { sum = temp.length(); }
        return sum;
    }

    //metodo que le entrada e retorna length da substring mais longa dessa entrada
    public static void main ( String args[] ) {
        String s = "";
        Scanner o = new Scanner (System.in);
        s = o.nextLine();
        int sum = 0;
        while ( ! f(s) ) {
            sum = 0;
            for (int y = 0; y<s.length(); y++) {
                if ( substrings(y, s.length()-1, s, false) > sum ) { 
                    sum = substrings(y, s.length()-1, s, false);
                }
            }
            for (int y = s.length()-1; y>0; y--) {
                if ( substrings(y, s.length()-1, s, true) > sum ) { 
                    sum = substrings(y, s.length()-1, s, true);
                }
            }
            
            System.out.println(sum);
            s = o.nextLine();
        }

    }
}