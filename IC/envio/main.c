/**
Matricula: 782195
Aluno: Fabiano Q. G. Almeida
Curso: Iniciação a Computação - Tarde
*/

#include <stdio.h>

int main(void) {
  int d = 0;
  printf ("\nAcelerador de Partículas (C) - Trabalho C-like\n\n");
  printf("\nEntre com a distância total percorrida pela partícula: \n");
  scanf ( "%d", &d );
  if ( ! ( 6 <= d && d <= 800008) )
  {
    printf ( "\nERRO: Valor da distância inválido.\n");
  }
  else
  {
    d += -3;
    d = d % 8;
    switch (d){
      case 3:
        printf ( "\nA partícula vai do emissor até o sensor n°1\n");
      break;
      case 4:
        printf ( "\nA partícula vai do emissor até o sensor n°2\n");
      break;
      case 5:
        printf ( "\nA partícula vai do emissor até o sensor n°3\n");
      break;
      default:  
        printf ( "\nA partícula não vai para nenhum sensor...\n");
      }
  }
  return 0;
}

//●Os pseudocódigos (algoritmos em alto nível, com comandos em português)
//●Os códigos nas linguagens C-like (C, C++, C#, Java, Python)
//●Um print de exemplos de execuções