class RCifra {
    //verifica se é fim
    public static boolean isFim ( String s ) {
        return ( s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M' );
    }

    //cifra uma entrada com chave 3
    public static String cifra ( String s, String sai, int y ) {
        if ( y < s.length() ) {
            sai += ((char)(s.charAt(y) + 3));   
            sai = cifra(s,sai,++y);
        }
        return sai;
    }

    //le e cifra uma entrada
    public static void main (String args[]) {
        //Scanner obj = new Scanner (System.in);
        String s;
        do {
            s = MyIO.readLine();
            MyIO.println(cifra(s,"",0));
        }
        while ( ! isFim(s) );
    }
}