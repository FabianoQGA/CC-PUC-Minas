import java.io.FileNotFoundException;  // Import the File class
import java.io.IOException;  // Import this class to handle errors
import java.io.RandomAccessFile;
import java.util.*;

class Files2 {
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

    //metodo que le arquivo e realiza operacoes sobre ele sem usar estruturas de dados
    public static void main ( String args[] ) {
        try {
            int n = 0; // dado primitivo indicando num de valores reais a serem lidos.
            double d = 0.0; // dado primitivo usado para armazenar doubles
            int di = 0; // dado primitivo para armazenar ints
            int y = 0;
            Scanner o = new Scanner(System.in);
            RandomAccessFile fo = new RandomAccessFile("temp.out", "rw");

            n = Integer.parseInt(o.nextLine());
            for (y = 0; y < n; y++) {
                d = Double.parseDouble(o.nextLine());
                fo.writeBytes("" + d);
                fo.writeBytes("\n");
            }

            fo.close();

            RandomAccessFile fileRead = new RandomAccessFile("temp.out", "r");
            
            boolean println = false;
            long lastN = fileRead.length();
            long marked = fileRead.length()-1;
            for (long i = fileRead.length()-1; i >= 0; i--) {
                fileRead.seek(i);
                char c = (char) fileRead.read(); 
                if ( c == '\n' ) {
                    if ( fileRead.getFilePointer() != fileRead.length() ) {
                        marked = lastN;
                    }
                    lastN = fileRead.getFilePointer()-1;
                    long flag = fileRead.getFilePointer();

                    int contador = 0;

                    for ( long z = flag; z < marked; z++ ) 
                    {
                        c = (char) fileRead.read();
                        if ( z == flag && c == '.' ) {
                            System.out.print("0");
                        }

                        if (c == '.') {contador = 1;}
                        else if (c == '0' && contador == 1) {contador = 2;}
                        else if (c == '\n' && contador == 2) {z = marked;}
                        else if (contador == 2) {System.out.print(".0" + c); contador = 0;}
                        else if (contador == 1) {System.out.print ("." + c); contador = 0;}
                        else {System.out.print(c); contador = 0;}


                        println = true;
                    }
                    if ( println ) { System.out.println(); println = false; }
                } else if ( i == 0 ) { // só roda no final do arquivo
                    marked = lastN;
                    long flag = fileRead.getFilePointer();
                    System.out.print(c);            

                    int contador = 0;

                    for ( long z = flag; z < marked; z++ ) 
                    {
                        c = (char) fileRead.read();
                        if ( z == flag && c == '.' ) {
                            System.out.print("0.");
                        }
                        
                        if (c == '.') {contador = 1;}
                        else if (c == '0' && contador == 1) {contador = 2;}
                        else if (c == '\n' && contador == 2) {z = marked;}
                        else if (contador == 2) {System.out.print(".0" + c); contador = 0;}
                        else if (contador == 1) {System.out.print("." + c); contador = 0;}
                        else {System.out.print(c); contador = 0;}
                        
                    }
                    
                    System.out.println();
                }
            }

            fileRead.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERRO AO ABRIR ARQUIVO");
            e.printStackTrace();
        } catch ( IOException e ) {
            System.out.println("ERRO AO LER DO ARQUIVO");
            e.printStackTrace();    
        }
    }
}