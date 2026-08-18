/**
Matricula: 782195
Aluno: Fabiano Q. G. Almeida
Curso: Iniciação a Computação - Tarde
*/
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int d;
    System.out.println("Acelerador de Partículas (Java) - Trabalho C-like\n\n");
    Scanner input = new Scanner(System.in);
    System.out.println("Entre com a distância total percorrida pela partícula: \n");
    d = input.nextInt();
    if ( ! ( 6 <= d && d <= 800008) )
    {
      System.out.println("ERRO: Valor da distância inválido.\n");
    }
    else
    {
      d += -3;
      d = d % 8;
      switch (d){
        case 3:
          System.out.println("A partícula vai do emissor até o sensor n°1\n");
        break;
        case 4:
          System.out.println("A partícula vai do emissor até o sensor n°2\n");
        break;
        case 5:
          System.out.println("A partícula vai do emissor até o sensor n°3\n");
        break;
        default:  
          System.out.println("A partícula não vai para nenhum sensor...\n");
        }
    }
  }
}

//●Os pseudocódigos (algoritmos em alto nível, com comandos em português)
//●Os códigos nas linguagens C-like (C, C++, C#, Java, Python)
//●Um print de exemplos de execuções