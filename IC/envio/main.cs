/**
Matricula: 782195
Aluno: Fabiano Q. G. Almeida
Curso: Iniciação a Computação - Tarde
*/

using System;

class MainClass {
  public static void Main(string[] args) 
  {
    int d;
    Console.WriteLine("Acelerador de Partículas (C#) - Trabalho C-like");
    Console.WriteLine("\nEntre com a distância total percorrida pela partícula: ");
    d = int.Parse(Console.ReadLine());
    if ( ! ( 6 <= d && d <= 800008) )
    {
      Console.WriteLine( "\nERRO: Valor da distância inválido.");
    }
    else
    {
      d += -3;
      d = d % 8;
      switch (d){
        case 3:
          Console.WriteLine( "A partícula vai do emissor até o sensor n°1");
        break;
        case 4:
          Console.WriteLine( "A partícula vai do emissor até o sensor n°2");
        break;
        case 5:
          Console.WriteLine( "A partícula vai do emissor até o sensor n°3");
        break;
        default:  
          Console.WriteLine( "A partícula não vai para nenhum sensor...");
        break;
        }
    }
  }
}

//●Os pseudocódigos (algoritmos em alto nível, com comandos em português)
//●Os códigos nas linguagens C-like (C, C++, C#, Java, Python)
//●Um print de exemplos de execuções