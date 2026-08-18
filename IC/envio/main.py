#Matricula: 782195
#Aluno: Fabiano Q. G. Almeida
#Curso: Iniciação a Computação - Tarde

print ("\nAcelerador de Partículas (Python) - Trabalho C-like\n\n");
d = int(input( "Entre com a distância total percorrida pela partícula: \n" ));
if not (6 <= d and d <= 800008):
  print ( "\nERRO: Valor da distância inválido.\n");
else:
  d += -3;
  d = d % 8;
  if d == 3:
    print( "\nA partícula vai do emissor até o sensor n°1\n");
  elif d == 4:
    print( "\nA partícula vai do emissor até o sensor n°2\n");
  elif d == 5:
    print( "\nA partícula vai do emissor até o sensor n°3\n");
  else:
    print( "\nA partícula não vai para nenhum sensor...\n");

#●Os pseudocódigos (algoritmos em alto nível, com comandos em português)
#●Os códigos nas linguagens C-like (C, C++, C#, Java, Python)
#●Um print de exemplos de execuções