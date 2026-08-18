import java.io.File;
import java.io.FileNotFoundException;  // class para files
import java.util.*; // class para file read

class Maths {

    public static boolean notir ( boolean a, boolean b, boolean c, String s ) {
        
        boolean result = false;
        String returno = "";
        String indexo = "";
        int max = s.length();
        boolean flag1 = false;
        boolean value = false;

        boolean flag2 = false;
        boolean skipped = false;
        int flaggy = 0;

        int o = 0; // numero de operandos que um metodo dentro deste possui
        
        for ( int z = 0; z < max; z ++ ) {
            if ( s.charAt(z) >= 'a' && s.charAt(z) <= 'z' ) {

                if ( ! flag1 ) {
                    flag1 = true; // ativa lock de operacao // flag1: ativado quando indexo esta sendo escrito ou terminou de escrever. 
                    indexo = "";
                } 
                indexo += s.charAt(z);

            } else {

                // esse if testa se o caractere atual nao é uma maiuscula e se flag1 esta ativa(estava escrevendo uma string de operador indexo, e tal string ja esta completa)
                if ( flag1 ) {
                    flag2 = false;
                    returno = "";
                    skipped = false;
                    flaggy = 0;

                    for ( int y = z; flag1 && y<max; y++ ) {

                       if ( s.charAt(y) >= 'a' && s.charAt(y) <= 'z' ) {
                            if ( ! flag2 ) {
                                flaggy++; // indica se dentro do operador tem outro operador atuando (se for maior que zero)
                                flag2 = true; //indica se um grupo de caracteres esta sendo escrito como operador
                            }
                            returno += s.charAt(y);
                        } else if ( s.charAt(y) == '(' && ! skipped ) {
                            skipped = true;
                        } else if ( flaggy>0 && s.charAt(y) == ')' ) {  //not(and(and()))
                            flaggy--;
                            flag2=false;
                        } else if ( flaggy == 0 && s.charAt(y) == ',' ) {
                            o++;
                            returno += s.charAt(y);
                            flag2 = false;
                        } else if ( flaggy == 0 && s.charAt(y) == ')' ) {
                            flag1 = false; 
                            z = y;
                        } else {
                            returno += s.charAt(y);
                            flag2 = false;
                        }

                    }

                    if ( indexo.compareTo("or") == 0 ) { // atribuindo valores as variaveis dos operandos
                        value = orir(a,b,c,returno);
                    }
                    else if ( indexo.compareTo("and") == 0 ) {
                        value = andir(a,b,c,returno);
                    }
                    else if ( indexo.compareTo("not") == 0 ) {
                        value = notir(a,b,c,returno);
                    }

                }
                    
                // se operando for uma letra
                else if ( s.charAt(z) == 'A' ) {
                    value = a;
                } else if ( s.charAt(z) == 'B' ) {
                    value = b;
                } else if ( s.charAt(z) == 'C' ) {
                    value = c; 
                }

                } //analisar se precisa de um flag1 no else if
                
            }  

        result = ! value;
        
        return result;  
    }

    public static boolean andir ( boolean a, boolean b, boolean c, String s ) {

        boolean result = false;
        String returno = "";
        String indexo = "";
        int max = s.length();
        boolean final1 = false; boolean final2 = false; boolean final3 = false;
        boolean flag1 = false;

        boolean flag2 = false;
        boolean skipped = false;
        int flaggy = 0;

        int o = 0; // numero de operandos que um metodo dentro deste possui
        int h = 0; // numero de operandos que este metodo possui

        for ( int z = 0; z < max; z ++ ) {
            if ( s.charAt(z) >= 'a' && s.charAt(z) <= 'z' ) {

                if ( ! flag1 ) {
                    flag1 = true; // ativa lock de operacao // flag1: ativado quando indexo esta sendo escrito ou terminou de escrever. 
                    indexo = "";
                } 
                indexo += s.charAt(z);

            } else {

                // esse if testa se o caractere atual nao é uma maiuscula e se flag1 esta ativa(estava escrevendo uma string de operador indexo, e tal string ja esta completa)
                if ( flag1 ) {
                    flag2 = false;
                    returno = "";
                    skipped = false;
                    flaggy = 0;

                    for ( int y = z; flag1 && y<max; y++ ) {

                        if ( s.charAt(y) >= 'a' && s.charAt(y) <= 'z' ) {
                            if ( ! flag2 ) {
                                flaggy++; // indica se dentro do operador tem outro operador atuando (se for maior que zero)
                                flag2 = true; //indica se um grupo de caracteres esta sendo escrito como operador
                            }
                            returno += s.charAt(y);
                        } else if ( s.charAt(y) == '(' && ! skipped ) {
                            skipped = true;
                        } else if ( flaggy>0 && s.charAt(y) == ')' ) {  
                            flaggy--;
                            flag2=false;
                            returno += s.charAt(y);
                        } else if ( flaggy == 0 && s.charAt(y) == ',' ) {
                            o++;
                            returno += s.charAt(y);
                            flag2 = false;
                        }
                        else if ( flaggy == 0 && s.charAt(y) == ')' ) {
                            flag1 = false; 
                            z = y;
                        } else {
                            returno += s.charAt(y);
                            flag2 = false;
                        }
                    }
                    
                    if ( indexo.compareTo("or") == 0 ) { // atribuindo valores as variaveis dos operandos
                        if ( h==0 ) {
                            final1 = orir(a,b,c,returno);
                            h++;
                        } else if ( h==1 ) {
                            final2 = orir(a,b,c,returno);
                            h++;
                        } else if ( h >= 2 ) {
                            final3 = orir(a,b,c,returno);
                            h++;
                        }
                    } else if ( indexo.compareTo("and") == 0 ) {
                        if ( h==0 ) {
                            final1 = andir(a,b,c,returno);
                            h++;
                        } else if ( h==1 ) {
                            final2 = andir(a,b,c,returno);
                            h++;
                        } else if ( h >= 2 ) {
                            final3 = andir(a,b,c,returno);
                            h++;
                        }
                    } else if ( indexo.compareTo("not") == 0 ) {
                        if ( h==0 ) {
                            final1 = notir(a,b,c,returno);
                            h++;
                        } else if ( h==1 ) {
                            final2 = notir(a,b,c,returno);
                            h++;
                        } else if ( h>=2 ) {
                            final3 = notir(a,b,c,returno);
                            h++;
                        }
                    }
                }

                //analisar se precisa de um flag1 no else if
                else if ( s.charAt(z) == 'A' ) {
                    if ( h==0 ) {
                        final1 = a;
                    } else if ( h==1 ) {
                        final2 = a;
                    } else {
                        final3 = a;
                    }
                    h++;
                } else if ( s.charAt(z) == 'B' ) {
                    if ( h==0 ) {
                        final1 = b;
                    } else if ( h==1 ) {
                        final2 = b;
                    } else {
                        final3 = b;
                    }
                    h++;
                } else if ( s.charAt(z) == 'C' ) {
                    if ( h==0 ) {
                        final1 = c;
                    } else if ( h==1 ) {
                        final2 = c;
                    } else {
                        final3 = c;
                    }
                    h++;
                } 
            }

        }    

        if( h >= 3 ) {
            result = (final1 && final2) && final3;
        } else {
            result = final1 && final2;
        }
            
        return result;
        
    }

    public static boolean orir ( boolean a, boolean b, boolean c, String s ) {

        boolean result = false;
        String returno = "";
        String indexo = "";
        int max = s.length();
        boolean final1 = false; boolean final2 = false; boolean final3 = false;
        boolean flag1 = false;

        boolean flag2 = false;
        boolean skipped = false;
        int flaggy = 0;

        int o = 0; // numero de operandos que um metodo dentro deste possui
        int h = 0; // numero de operandos que este metodo possui

        for ( int z = 0; z < max; z ++ ) {
            if ( s.charAt(z) >= 'a' && s.charAt(z) <= 'z' ) {

                if ( ! flag1 ) {
                    flag1 = true; // ativa lock de operacao // flag1: ativado quando indexo esta sendo escrito ou terminou de escrever. 
                    indexo = "";
                } 
                indexo += s.charAt(z);

            } else {

                // esse if testa se o caractere atual nao é uma maiuscula e se flag1 esta ativa(estava escrevendo uma string de operador indexo, e tal string ja esta completa)
                if ( flag1 ) {
                    flag2 = false;
                    returno = "";
                    skipped = false;
                    flaggy = 0;

                    for ( int y = z; flag1 && y<max; y++ ) {

                        if ( s.charAt(y) >= 'a' && s.charAt(y) <= 'z' ) {
                            if ( ! flag2 ) {
                                flaggy++; // indica se dentro do operador tem outro operador atuando (se for maior que zero)
                                flag2 = true; //indica se um grupo de caracteres esta sendo escrito como operador
                            }
                            returno += s.charAt(y);
                        } else if ( s.charAt(y) == '(' && ! skipped ) {
                            skipped = true;
                        } else if ( flaggy>0 && s.charAt(y) == ')' ) {  
                            flaggy--;
                            flag2=false;
                            returno += s.charAt(y);
                        } else if ( flaggy == 0 && s.charAt(y) == ',' ) {
                            o++;
                            returno += s.charAt(y);
                            flag2 = false;
                        }
                        else if ( flaggy == 0 && s.charAt(y) == ')' ) {
                            flag1 = false; 
                            z = y;
                        } else {
                            returno += s.charAt(y);
                            flag2 = false;
                        }
                    }
                    
                    if ( indexo.compareTo("or") == 0 ) { // atribuindo valores as variaveis dos operandos
                        if ( h==0 ) {
                            final1 = orir(a,b,c,returno);
                            h++;
                        } else if ( h==1 ) {
                            final2 = orir(a,b,c,returno);
                            h++;
                        } else if ( h >= 2 ) {
                            final3 = orir(a,b,c,returno);
                            h++;
                        }
                    } else if ( indexo.compareTo("and") == 0 ) {
                        if ( h==0 ) {
                            final1 = andir(a,b,c,returno);
                            h++;
                        } else if ( h==1 ) {
                            final2 = andir(a,b,c,returno);
                            h++;
                        } else if ( h >= 2 ) {
                            final3 = andir(a,b,c,returno);
                            h++;
                        }
                    } else if ( indexo.compareTo("not") == 0 ) {
                        if ( h==0 ) {
                            final1 = notir(a,b,c,returno);
                            h++;
                        } else if ( h==1 ) {
                            final2 = notir(a,b,c,returno);
                            h++;
                        } else if ( h>=2 ) {
                            final3 = notir(a,b,c,returno);
                            h++;
                        }
                    }
                }

                //analisar se precisa de um flag1 no else if
                else if ( s.charAt(z) == 'A' ) {
                    if ( h==0 ) {
                        final1 = a;
                    } else if ( h==1 ) {
                        final2 = a;
                    } else {
                        final3 = a;
                    }
                    h++;
                } else if ( s.charAt(z) == 'B' ) {
                    if ( h==0 ) {
                        final1 = b;
                    } else if ( h==1 ) {
                        final2 = b;
                    } else {
                        final3 = b;
                    }
                    h++;
                } else if ( s.charAt(z) == 'C' ) {
                    if ( h==0 ) {
                        final1 = c;
                    } else if ( h==1 ) {
                        final2 = c;
                    } else {
                        final3 = c;
                    }
                    h++;
                } 
            }

        }    

        result = (final1 || final2) || final3;
            
        return result;
        
    }

    public static boolean mathir ( boolean a, boolean b, boolean c, String s ) {
        boolean result = false;
        boolean skipped = false;
        String indexo = "";
        String returno = "";
        int max = s.length();

        boolean flag2 = false;
        int flaggy = 0;
        int o = 0;

        for ( int z = 0; z<max; z++ ) {
            if ( s.charAt(z) >= 'a' && s.charAt(z) <= 'z' && z <= 2) {
                indexo += s.charAt(z);
            }
            else if ( s.charAt(z) == '(' && !skipped ) { skipped = true; }
            else if ( z != max-1 ) { returno += s.charAt(z); }

            if ( s.charAt(z) >= 'a' && s.charAt(z) <= 'z' ) {
                if ( ! flag2 ) {
                    flaggy++; // indica se dentro do operador tem outro operador atuando (se for maior que zero)
                    flag2 = true; //indica se um grupo de caracteres esta sendo escrito como operador
                }
            } else if ( flaggy>0 && s.charAt(z) == ')' ) {  
                flaggy--;
                flag2=false;
            } else if ( flaggy == 1 && s.charAt(z) == ',' ) {
                o++;
                flag2 = false;
            } else {
                flag2 = false;
            }
        }

        if ( indexo.compareTo("or")==0 ) {
            result = orir(a,b,c,returno);
        } else if ( indexo.compareTo("and")==0 ) {
            result = andir(a,b,c,returno);
        } else if ( indexo.compareTo("not")==0 ) {
            result = notir(a,b,c,returno);
        }

        return result;
    }

    public static void main ( String args[] ) {
        try {
            File myFile = new File ("pub.in");
            Scanner obj = new Scanner(myFile);
            String input;
            int n;
            boolean a1; 
            boolean b2;
            boolean c3 = false;
            String inputo;
            boolean temp;
            int y = 1;
            input = obj.nextLine();
            while ( input.compareTo("0") != 0 ) {
                n = Integer.parseInt(input.split(" ")[0]);
                temp = input.charAt(2) == '1';
                a1 = temp;
                temp = input.charAt(4) == '1';
                b2 = temp;
                inputo = "";
                if ( n > 2 ) {
                    temp = input.charAt(6) == '1';
                    c3 = temp;
                    for ( int x = 8; x<input.length(); x++ ) {
                        inputo += input.charAt(x);
                    }
                } else {
                    for ( int x = 6; x<input.length(); x++ ) {
                        inputo += input.charAt(x);
                    }
                }
                //System.out.println( n + "< " + y + " >" + a1 + " " + b2 + " " + c3 + " " + tresOperand + " " + inputo);
                System.out.print(y+ " ");
                if ( mathir(a1,b2,c3,inputo) ) { //mathir(a1,b2,c3,inputo,tresOperand)
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
                input = obj.nextLine();
                y++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("errô");
            e.printStackTrace();
        }
    }
}