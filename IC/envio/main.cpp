/**
Matricula: 782195
Aluno: Fabiano Q. G. Almeida
Curso: Iniciação a Computação - Tarde
*/

#include <iostream>

int main(void) {
  int d = 0;
  std::cout << "\nAcelerador de Partículas (C++) - Trabalho C-like\n\n";
  std::cout << "\nEntre com a distância total percorrida pela partícula: \n";
  std::cin >> d;
  if ( ! ( 6 <= d && d <= 800008) )
  {
    std::cout << "\nERRO: Valor da distância inválido.\n";
  }
  else
  {
    d += -3;
    d = d % 8;
    switch (d){
      case 3:
        std::cout << "\nA partícula vai do emissor até o sensor n°1\n";
      break;
      case 4:
        std::cout << "\nA partícula vai do emissor até o sensor n°2\n";
      break;
      case 5:
        std::cout << "\nA partícula vai do emissor até o sensor n°3\n";
      break;
      default:  
        std::cout << "\nA partícula não vai para nenhum sensor...\n";
      }
  }
}

//●Os pseudocódigos (algoritmos em alto nível, com comandos em português)
//●Os códigos nas linguagens C-like (C, C++, C#, Java, Python)
//●Um print de exemplos de execuções