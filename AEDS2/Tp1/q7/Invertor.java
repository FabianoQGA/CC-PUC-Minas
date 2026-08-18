import java.util.*;  // Import the File class


class Invertor {
    //metodo invertor de entradas
    public static String m ( String s ) {
        String temp = "";
        for ( int y = 0; y < s.length(); y++ ) {
            temp += s.charAt(s.length()-y-1);
        }
        return temp;
    }

    //main que le entrada ate "FIM" e inverte ela
    public static void main ( String args[] ) {
        String s = "";
        Scanner o = new Scanner (System.in);
        s = o.nextLine();
        while ( ! (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') ) {
            System.out.println(m(s));
            s = o.nextLine();
        }
    }
}