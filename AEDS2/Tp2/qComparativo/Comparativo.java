import java.util.*;

class Log {
    public int comparacoes;
    public int movimentacoes;
    public double stopwatch;
    public double now;
    public double then;

    public Log () {
        this.comparacoes = 0;
        this.movimentacoes = 0;
        this.stopwatch = 0.0;
        this.now = 0.0;
        this.then = 0.0;
    }

    public int getComparacoes() {
        return this.comparacoes;
    }

    public void setComparacoes ( int comp ) {
        this.comparacoes = comp;
    }

    public int getMovimentacoes() {
        return this.movimentacoes;
    }

    public void setMovimentacoes ( int mov ) {
        this.movimentacoes = mov;
    }

    public double getStopwatch() {
        return this.stopwatch;
    }

    public void setStopwatch ( double swatch ) {
        this.stopwatch = swatch;
    }

    public void startStopwatch ( ) {
        then = System.currentTimeMillis();
    }

    public void stopStopwatch ( ) {
        now = System.currentTimeMillis();
        setStopwatch(now-then);
    }
}

public class Comparativo {

    /**
     * Troca posicoes de elementos dentro de um array
     */
    public static void swap ( int x, int y, int array[], Log log ) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
        log.setMovimentacoes(log.getMovimentacoes()+3);
    }

    /**
     * Troca posicoes de elementos dentro de um array
     */
    public static void swap ( int x, int y, int array[] ) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
	 * Produz um array ordenado de modo crescente.
	 */
	public static void crescente(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

    /**
	 * Produz um array com numeros aleatorios.
	 */
	public static void aleatorio(int array[]) {
		Random rand = new Random();
		crescente(array);	
		for (int i = 0; i < array.length; i++) {
			swap(i, Math.abs(rand.nextInt()) % array.length, array);
		}
	}

    public static void selecao(int array[], Log log) {
        for (int i = 0; i < (array.length - 1); i++) {
			int menor = i;
			for (int j = (i + 1); j < array.length; j++){
                log.setComparacoes(log.getComparacoes()+1);
				if (array[menor] > array[j]){
					menor = j;
				}
			}
			swap(menor, i, array, log);
		}
        log.stopStopwatch();
    }

    public static void insercao(int array[], Log log) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0) {
                log.setComparacoes(log.getComparacoes()+1);
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                    log.setMovimentacoes(log.getMovimentacoes()+1);
                    j--;
                } else {
                    break;
                }
            }
            log.setMovimentacoes(log.getMovimentacoes()+1);
            array[j + 1] = tmp;
        }
        log.stopStopwatch();
    }

    public static void bolha(int array[], Log log) {
        for (int i = (array.length - 1); i > 0; i--) {
			for (int j = 0; j < i; j++) {
                log.setComparacoes(log.getComparacoes()+1);
				if (array[j] > array[j + 1]) {
                    swap(j, j+1, array, log);
				}
			}
		}
    }

    public static void quicksort(int esq, int dir, int array[], Log log) {
        int i = esq, j = dir;
        int pivo = array[(dir+esq)/2];
        while (i <= j) {
            while (array[i] < pivo) {
                i++;
                log.setComparacoes(log.getComparacoes()+1);
            }
            log.setComparacoes(log.getComparacoes()+1);
            while (array[j] > pivo) {
                j--;
                log.setComparacoes(log.getComparacoes()+1);
            } 
            log.setComparacoes(log.getComparacoes()+1);
            if ( i <= j ) {
                swap(i, j, array, log);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j, array, log);
        if (i < dir)  quicksort(i, dir, array, log);
    }

    public static void print ( int n, Log log_sel, Log log_ins, Log log_bol, Log log_qui ) {
        System.out.println("Vetor de " + n + " elementos:");
        System.out.println("Selecao => Movimentacoes " + log_sel.getMovimentacoes() + " Comparacoes: " + log_sel.getComparacoes() + " Tempo: " + log_sel.getStopwatch()/1000 );
        System.out.println("Insercao => Movimentacoes " + log_ins.getMovimentacoes() + " Comparacoes: " + log_ins.getComparacoes() + " Tempo: " + log_ins.getStopwatch()/1000 );
        System.out.println("Bolha => Movimentacoes " + log_bol.getMovimentacoes() + " Comparacoes: " + log_bol.getComparacoes() + " Tempo: " + log_bol.getStopwatch()/1000 );
        System.out.println("Quicksort => Movimentacoes " + log_qui.getMovimentacoes() + " Comparacoes: " + log_qui.getComparacoes() + " Tempo: " + log_qui.getStopwatch()/1000 );
    }    

    public static void reset ( Log log ) {
        log.setComparacoes(0);
        log.setMovimentacoes(0);
        log.startStopwatch();
    }

    public static void main ( String args[] ) {
        final int CEM = 100;
        final int MIL = 1000;
        final int DEZ_MIL = 10000;
        final int CEM_MIL = 100000;

        int array_cem[] = new int[CEM];
        int array_mil[] = new int[MIL];
        int array_dez_mil[] = new int[DEZ_MIL];
        int array_cem_mil[] = new int[CEM_MIL];
        int tmp_cem[] = new int[CEM];
        int tmp_mil[] = new int[MIL];
        int tmp_dez_mil[] = new int[DEZ_MIL];
        int tmp_cem_mil[] = new int[CEM_MIL];

        Log log_sel = new Log();
        Log log_ins = new Log();
        Log log_bol = new Log();
        Log log_qui = new Log();
        
        aleatorio(array_cem);
        aleatorio(array_mil);
        aleatorio(array_dez_mil);
        aleatorio(array_cem_mil);

        /*
        for ( int y = 0; y < tmp_cem.length; y++ ) {
            System.out.print(" X. " + tmp_cem[y] + " ");
        } */

        // CEM
        System.arraycopy(array_cem, 0, tmp_cem, 0, CEM);
        reset(log_sel);
        selecao(tmp_cem,log_sel);
        log_sel.stopStopwatch();

        System.arraycopy(array_cem, 0, tmp_cem, 0, CEM);
        reset(log_ins);
        insercao(tmp_cem,log_ins);
        log_ins.stopStopwatch();

        System.arraycopy(array_cem, 0, tmp_cem, 0, CEM);
        reset(log_bol);
        bolha(tmp_cem,log_bol);
        log_bol.stopStopwatch();

        System.arraycopy(array_cem, 0, tmp_cem, 0, CEM);
        reset(log_qui);
        quicksort(0,CEM-1,tmp_cem,log_qui);
        log_qui.stopStopwatch();

        print(CEM, log_sel, log_ins, log_bol, log_qui);
        
        // MIL
        System.arraycopy(array_mil, 0, tmp_mil, 0, MIL);
        reset(log_sel);
        selecao(tmp_mil,log_sel);
        log_sel.stopStopwatch();

        System.arraycopy(array_mil, 0, tmp_mil, 0, MIL);
        reset(log_ins);
        insercao(tmp_mil,log_ins);
        log_ins.stopStopwatch();

        System.arraycopy(array_mil, 0, tmp_mil, 0, MIL);
        reset(log_bol);
        bolha(tmp_mil,log_bol);
        log_bol.stopStopwatch();

        System.arraycopy(array_mil, 0, tmp_mil, 0, MIL);
        reset(log_qui);
        quicksort(0,MIL-1,tmp_mil,log_qui);
        log_qui.stopStopwatch();

        print(MIL, log_sel, log_ins, log_bol, log_qui);
        
        // DEZ MIL
        System.arraycopy(array_dez_mil, 0, tmp_dez_mil, 0, DEZ_MIL);
        reset(log_sel);
        selecao(tmp_dez_mil,log_sel);
        log_sel.stopStopwatch();

        System.arraycopy(array_dez_mil, 0, tmp_dez_mil, 0, DEZ_MIL);
        reset(log_ins);
        insercao(tmp_dez_mil,log_ins);
        log_ins.stopStopwatch();

        System.arraycopy(array_dez_mil, 0, tmp_dez_mil, 0, DEZ_MIL);
        reset(log_bol);
        bolha(tmp_dez_mil,log_bol);
        log_bol.stopStopwatch();

        System.arraycopy(array_dez_mil, 0, tmp_dez_mil, 0, DEZ_MIL);
        reset(log_qui);
        quicksort(0,DEZ_MIL-1,tmp_dez_mil,log_qui);
        log_qui.stopStopwatch();

        print(DEZ_MIL, log_sel, log_ins, log_bol, log_qui);

        // CEM MIL
        System.arraycopy(array_cem_mil, 0, tmp_cem_mil, 0, CEM_MIL);
        reset(log_sel);
        selecao(tmp_cem_mil,log_sel);
        log_sel.stopStopwatch();

        System.arraycopy(array_cem_mil, 0, tmp_cem_mil, 0, CEM_MIL);
        reset(log_ins);
        insercao(tmp_cem_mil,log_ins);
        log_ins.stopStopwatch();

        System.arraycopy(array_cem_mil, 0, tmp_cem_mil, 0, CEM_MIL);
        reset(log_bol);
        bolha(tmp_cem_mil,log_bol);
        log_bol.stopStopwatch();

        System.arraycopy(array_cem_mil, 0, tmp_cem_mil, 0, CEM_MIL);
        reset(log_qui);
        quicksort(0,CEM_MIL-1,tmp_cem_mil,log_qui);
        log_qui.stopStopwatch();

        print(CEM_MIL, log_sel, log_ins, log_bol, log_qui);
    }
}
