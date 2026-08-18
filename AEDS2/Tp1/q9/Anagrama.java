import java.util.*;

class Anagrama {
    //metodo que verifica se entrada é "FIM"
    public static boolean f(String s) {
        return ( s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M' );
    }

    //funcao que separa string em dois de acordo com o delimitador
    public static String[] splito ( String s ) {
        String[] temp = {"", ""};
        String temp1 = "";
        String temp2 = "";
        boolean flag = false;
        for ( int y = 0; y<s.length(); y++ ) {
            if ( s.charAt(y) == ' ') {
                flag = true;
            }
            if ( ! flag ) {
                temp1 += s.charAt(y);
            } else {
                if (s.charAt(y) != ' ' && s.charAt(y) != '-') {
                    temp2 += s.charAt(y);
                }
            }
        }
        temp[0] = temp1;
        temp[1] = temp2;
        
        return temp;
    }

    //metodo que retorna string com dois caracteres trocados
    public static String r ( String s, int y, int z ) {
        String temp = "";
        char a1 = s.charAt(y);
        char a2 = s.charAt(z);
        for ( int i = 0; i < s.length(); i++ ) {
            if ( i == y ) {
                temp += a2;
            } else if ( i == z ) {
                temp += a1;
            } else {
                temp += s.charAt(i);
            }
        }
        return temp;
    }

    //metodo que converte char maiusculo para minusculo
    public static char ifMaiuscula ( char c ) {
        char temp = c;
        if ( c >= 'A' && c <= 'Z') {
            temp = (char)(c + 32); 
        }
        return temp;
    }

    //metodo que verifica se duas strings sao anagramas
    public static boolean m ( String sA, String sB ) {
        boolean result = true;
        String temp = sB;
        for ( int y = 0; y<sA.length(); y++ ) {
            for ( int z = y; z<sB.length(); z++ ) {
                if(ifMaiuscula(sA.charAt(y)) == ifMaiuscula(temp.charAt(z))) {
                    //System.out.println(temp + " " + y + " " + z + " " + sA.length() + " " + sB.length());
                    temp = r(temp,y,z);
                }
            }
        }
        for ( int i = 0; i < sA.length() && result; i++ ) {
            if (ifMaiuscula(sA.charAt(i)) != ifMaiuscula(temp.charAt(i))) {
                result = false;
                //System.out.println(sA.charAt(i) + " " + sB.charAt(i) + " ");
            }
        }
        return result;
    }

    //metodo main que le uma string divide a em duas e verifica se as duas strings sao um anagrama entre si
    public static void main ( String args[] ) {
        try {
            String sA = "";
            String sB = "";
            String s = "";
            Scanner o = new Scanner (System.in);
            s = o.nextLine();
            while ( ! f(s) ) {
                sA = splito(s)[0];
                sB = splito(s)[1];
                //System.out.println(sA);
                //System.out.println(sB);
                if ( m(sA,sB) ) {
                    MyIO.println("SIM");
                } else {
                    MyIO.println("NÃO");
                }
                s = o.nextLine();
            }
        } catch (Exception e) {
            //
        }
        
    }
}