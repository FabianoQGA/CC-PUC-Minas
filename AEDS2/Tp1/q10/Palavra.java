import java.util.*;

class Palavra {
    //metodo que verifica se entrada é "FIM"
    public static boolean f(String s) {
        return ( s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M' );
    }

    //metodo que retorna array de strings de acordo com numero de palavras espaçadas por espaço
    public static String[] split (String s) {
        String[] temp = new String[800];
        boolean flag = false;
        String tempS = "";
        int x = 0;
        for ( int y = 0; y<s.length(); y++ ) {
            if ( flag ) {
                if ( s.charAt(y) != ' ' ) {
                    tempS += s.charAt(y);
                } else {
                    if ( tempS != "" ) {
                        temp[x++] = tempS;
                    }
                    flag = false;
                }
                
            } else {
                if ( s.charAt(y) != ' ' ) {
                    flag = true;
                    tempS = "";
                    tempS += s.charAt(y);
                }
            }
        }
        if ( flag ) {
            temp[x++] = tempS;
        }
        return temp;
    }

    //conta um array de strings e retorna o numero de elementos
    public static int p ( String[] s ) {
        int sum = 0;
        for ( int y = 0; s[y] != null; y++ ) {
            sum++;
        }
        return sum;
    }

    //metodo que conta o numero de palavra numa string
    public static void main ( String[] args ) {
        try {
            String s = "";
            Scanner o = new Scanner (System.in);
            s = o.nextLine();
            while ( ! f(s) ) {
                MyIO.println(p(split(s)));
                s = o.nextLine();
            }
        } catch (Exception e) {
            //
        }
    }
}