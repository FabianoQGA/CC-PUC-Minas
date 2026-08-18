import java.util.*;

class Celula {
    int elemento;
    Celula esq, dir, sup, inf;

    public Celula ( ) {
        this(0);
    } 

    public Celula ( int elemento ) {
        this(elemento, null, null, null, null);
    } 

    public Celula ( int elemento, Celula inf, Celula sup, Celula esq, Celula dir ) {
        this.elemento = elemento;
        this.inf = inf;
        this.sup = sup;
        this.esq = esq;
        this.dir = dir;
    }
}

class Matriz {
    public Celula cantoSupEsq;
    public int lin, col;

    public Matriz ( ) {
        this(3,3);
    }

    public Matriz ( int l, int c ) {
        cantoSupEsq = new Celula();
        lin = l;
        col = c;

        Celula cursor = cantoSupEsq;
        for ( int i = 1; i < col; i++ ) {
            Celula make = new Celula();
            cursor.dir = make;
            make.esq = cursor;
            cursor = cursor.dir;
        }

        Celula cursorSup = cantoSupEsq;
        for ( int i = 1; i < lin; i++ ) {
            cursor = new Celula();
            cursor.sup = cursorSup;
            cursorSup.inf = cursor;

            Celula colMakeEsq = cursor;
            Celula colMakeSup = cursorSup;
            for ( int j = 1; j < col; j++ ) {
                Celula colMakeCursor = new Celula();
                colMakeEsq.dir = colMakeCursor;
                colMakeCursor.esq = colMakeEsq;

                colMakeSup = colMakeSup.dir;
                colMakeCursor.sup = colMakeSup;
                colMakeSup.inf = colMakeCursor;

                colMakeEsq = colMakeCursor;
            }

            cursorSup = cursor;
        }
    }

    public void inserir ( int linha, int coluna, int elemento ) {
        Celula cursor = cantoSupEsq;
        for ( int i = 1; i < linha; i++, cursor = cursor.inf );
        for ( int j = 1; j < coluna; j++, cursor = cursor.dir );
        cursor.elemento = elemento;
    }

    public Matriz soma ( Matriz m2 ) throws Exception {
        if ( lin != m2.lin || col != m2.col ) {
            throw new Exception ("Matriz invalida");
        }
        Matriz result = new Matriz(lin, col);
        Celula cursor = cantoSupEsq;
        Celula cursor2 = m2.cantoSupEsq;
        for ( int i = 1; i <= lin; i++ ) {
            for ( int j = 1; j <= col; j ++) {
                result.inserir(i,j,cursor.elemento + cursor2.elemento);
                cursor = cursor.dir;
                cursor2 = cursor2.dir;
            }
            cursor = cantoSupEsq;
            cursor2 = m2.cantoSupEsq;
            for ( int z = 1; z < i+1; z++, cursor = cursor.inf, cursor2 = cursor2.inf);
        }
        return result;
    }

    public Matriz mult ( Matriz m2 ) throws Exception {
        if ( col != m2.lin ) {
            throw new Exception ("Matriz invalida");
        }
        Matriz result = new Matriz(lin, col);
        Celula cursor = cantoSupEsq;
        Celula cursor2;
        int sum;
        
        for ( int i = 1; i <= lin; i++ ) {
            for ( int j = 1; j <= m2.col; j ++) {
                sum = 0;
                cursor = cantoSupEsq;
                cursor2 = m2.cantoSupEsq;
                for ( int z = 1; z < i; z++, cursor = cursor.inf); // posicionar na linha certa
                for ( int z = 1; z < j; z++, cursor2 = cursor2.dir); // posicionar na coluna certa
                for ( int z = 0; z < col; z++ )  {
                    sum += cursor.elemento * cursor2.elemento; // multiplicacao: soma das multiplicacoes
                    cursor = cursor.dir; // movimentando cursor dentro da linha
                    cursor2 = cursor2.inf; // movimentando cursor2 dentro da coluna
                }
                result.inserir(i,j,sum); // insercao na posicao i j da matriz resultado
            }
        }
        
        return result;
    }

    public void mostrarDiagonalPrincipal ( ) throws Exception {
        if ( lin != col ) {
            throw new Exception ("Matriz invalida");
        }
        Celula cursor = cantoSupEsq;
        for ( int i = 1; i <= lin; i++ ) {
            for ( int j = 1; j <= col; j ++) {
                if ( i == j ) {
                    System.out.print(cursor.elemento + " ");
                }
                cursor = cursor.dir;
            }
            cursor = cantoSupEsq;
            for ( int z = 1; z < i+1; z++, cursor = cursor.inf);
        }
        System.out.println();
    }

    public void mostrarDiagonalSecundaria ( ) throws Exception {
        if ( lin != col ) {
            throw new Exception ("Matriz invalida");
        }
        Celula cursor = cantoSupEsq;
        for ( int i = 0; i < lin; i++ ) {
            for ( int j = 0; j < col; j ++) {
                if ( i+j == lin-1 ) {
                    System.out.print(cursor.elemento + " ");
                }
                cursor = cursor.dir;
            }
            cursor = cantoSupEsq;
            for ( int z = 0; z < i+1; z++, cursor = cursor.inf);
        }
        System.out.println();
    }

    public void mostrar ( ) {
        Celula cursor = cantoSupEsq;
        for ( int i = 1; i <= lin; i++ ) {
            for ( int j = 1; j <= col; j ++) {
                System.out.print(cursor.elemento + " ");
                cursor = cursor.dir;
            }
            System.out.println();
            cursor = cantoSupEsq;
            for ( int z = 1; z < i+1; z++, cursor = cursor.inf);
        }
    }

    public static void main ( String args[] ) {
        try {
            int casos;
            int lin1, col1;
            int lin2, col2;
            Scanner object = new Scanner (System.in);

            int y = 0;
            casos = object.nextInt();
            while ( y < casos ) {
                lin1 = object.nextInt();
                col1 = object.nextInt();
                Matriz m1 = new Matriz(lin1, col1);
                
                for ( int i = 1; i <= lin1; i++ ) {
                    for ( int j = 1; j <= col1; j++ ) {
                        int integer = object.nextInt();
                        m1.inserir(i,j,integer);
                    }
                }

                m1.mostrarDiagonalPrincipal();
                m1.mostrarDiagonalSecundaria();
                
                lin2 = object.nextInt();
                col2 = object.nextInt();
                Matriz m2 = new Matriz(lin2, col2);
                for ( int i = 1; i <= lin2; i++ ) {
                    for ( int j = 1; j <= col2; j++ ) {
                        int integer = object.nextInt();
                        m2.inserir(i,j,integer);
                    }
                }

                Matriz m3 = m1.soma(m2);
                m3.mostrar();

                Matriz m4 = m1.mult(m2);
                m4.mostrar();

                y++;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}