
class Is {
    //verifica se é fim
    public static boolean isFim ( String s ) {
        return ( s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //verifica se entrada so tem vogais
    public static boolean isV( String s ) {
        boolean result = true;
        for (int y = 0; y < s.length(); y++) {
            if ( s.charAt(y) != 'a' && s.charAt(y) != 'e' && s.charAt(y) != 'i' && 
                 s.charAt(y) != 'o' && s.charAt(y) != 'u' && s.charAt(y) != 'A' &&
                 s.charAt(y) != 'E' && s.charAt(y) != 'I' && s.charAt(y) != 'O' &&
                 s.charAt(y) != 'U' ) {
                    result = false;
                    y = s.length();
                }
        }
        return (result);
    }

    //verifica se entrada so tem consoantes
    public static boolean isC( String s ) {
        boolean result = true;
        for (int y = 0; y < s.length(); y++) {
            if  ( s.charAt(y) != 'q' && s.charAt(y) != 'w' && s.charAt(y) != 'r' && 
                  s.charAt(y) != 't' && s.charAt(y) != 'y' && s.charAt(y) != 'p' &&
                  s.charAt(y) != 's' && s.charAt(y) != 'd' && s.charAt(y) != 'f' &&
                  s.charAt(y) != 'g' && s.charAt(y) != 'h' && s.charAt(y) != 'j' && 
                  s.charAt(y) != 'k' && s.charAt(y) != 'l' &&  
                  s.charAt(y) != 'z' && s.charAt(y) != 'x' && s.charAt(y) != 'c' && 
                  s.charAt(y) != 'v' && s.charAt(y) != 'b' && s.charAt(y) != 'n' && 
                  s.charAt(y) != 'm' &&
                  s.charAt(y) != 'Q' && s.charAt(y) != 'W' && s.charAt(y) != 'R' && 
                  s.charAt(y) != 'T' && s.charAt(y) != 'Y' && s.charAt(y) != 'P' &&
                  s.charAt(y) != 'S' && s.charAt(y) != 'D' && s.charAt(y) != 'F' &&
                  s.charAt(y) != 'G' && s.charAt(y) != 'H' && s.charAt(y) != 'J' && 
                  s.charAt(y) != 'K' && s.charAt(y) != 'L' &&  
                  s.charAt(y) != 'Z' && s.charAt(y) != 'X' && s.charAt(y) != 'C' && 
                  s.charAt(y) != 'V' && s.charAt(y) != 'B' && s.charAt(y) != 'N' && 
                  s.charAt(y) != 'M' ) {
                    result = false;
                    y = s.length();
                }
        }
        return (result);
    }

    //verifica se entrada é inteira
    public static boolean isI ( String s ) {
        boolean result = true;
        for ( int y = 0; y<s.length(); y++ ) {
            if (! ( s.charAt(y) >= '0' && s.charAt(y) <= '9') ) {
                result = false;
                y = s.length();
            } 
        }
        return result;
    }

    //verifica se entrada é um numero real
    public static boolean isR ( String s ) {
        boolean result = true;
        boolean flag = false;
        for ( int y = 0; y<s.length(); y++ ) {
            if ( s.charAt(y) == '.' || s.charAt(y) == ',' ) {
                if ( flag = false ) {
                    flag = true;
                } else {
                    result = false;
                    y = s.length();
                }
            } else if (! ( s.charAt(y) >= '0' && s.charAt(y) <= '9') ) {
                result = false;
                y = s.length();
            }
        }
        return result;
    }

    //printa X1 X2 X3 X4 para cada entrada como pedido no enunciado
    public static void main ( String args[] ) {
        String s = "";
        s = MyIO.readLine();
        while ( ! isFim(s) ) {
            if ( isV(s) ) {
                MyIO.print("SIM ");
            }
            else {
                MyIO.print("NAO ");
            }
            if ( isC(s)) {
                MyIO.print("SIM ");
            }
            else {
                MyIO.print("NAO ");
            }

            if ( isI(s)) {
                MyIO.print("SIM ");
            }
            else {
                MyIO.print("NAO ");
            }

            if ( isR(s)) {
                MyIO.println("SIM");
            }
            else {
                MyIO.println("NAO");
            }
            s = MyIO.readLine();
        }
    }
}