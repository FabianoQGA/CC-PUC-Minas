import java.util.*;

class Digitos {
    //metodo que verifica se entrada é "FIM"
    public static boolean f ( String s ) {
        boolean result = true;
        if ( s.length() >= 3) {
            result = s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M';
        } else {
            result = false;
        }
        return result;
    }

    /*
    public static int m ( int n ) { // 1234 - 1234%10 = 4 - 1234%100 = 34 - 1234%1000 =
        int soma = 0;
        int value = 0;
        int z= 0;
        for ( int y = 10; n%y != n; y = y * 10 ) {
            value = n%y;
            if ( value > 10 ) {
                z = y/10;
                value = (value - value%z)/z;
            }
            soma+=value;
        }
        return soma;
    }*/

   // metodo que soma digitos de um numero e retorna valor
    public static void main ( String args[] ) {
        String s = "";
        int n = 0;
        Scanner o = new Scanner (System.in);
        s = o.nextLine();
        while ( ! f(s) ) {
            n = 0;
            for ( int y = s.length(); y>0; y-- ) {
                n += (int)s.charAt(y-1)-48;
            }
            System.out.println(n);
            s = o.nextLine();
        }
    }
}