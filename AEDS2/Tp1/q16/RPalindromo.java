import java.util.*;

//checa se a string é palindromo
class RPalindromo {
    public static boolean isPalindromo ( String s, int y ) {
        boolean result = true;
        if ( y < s.length()/2 ) {
            if ( s.charAt(y) != s.charAt(s.length() - y - 1) ) {
                result = false;
            }
            else {
                y++;
                result = isPalindromo(s,y);
            }
        }
        return result;
    }

    //main que le entrada e retorna se é palindromo
    public static void main (String args[]) {
        //Scanner obj = new Scanner (System.in);
        String s;
        //s = obj.nextLine();
        s = MyIO.readLine();
        while ( ! (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') ) {
            if ( isPalindromo(s,0) ) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            //s = obj.nextLine();
            s = MyIO.readLine();
        }
    }
}

//s.charAt(y).equals( s.charAt(s.length() - y - 1)