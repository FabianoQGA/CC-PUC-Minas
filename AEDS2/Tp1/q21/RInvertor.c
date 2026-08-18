#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

//checa se a string é "FIM"
bool isFim (char s[]) {
    bool result = false;
    if (s[0] == 'F' && s[1] == 'I' && s[2] == 'M') { result = true; } 
    return result;
}

//metodo invertor de entradas
char* m( char s[], char i[], int y ) {
    if ( y < strlen(s) ) {
        i[y] = s[strlen(s)-y-1];
        m(s,i,y+1);
    }
    return i;
}

//main que le entrada ate "FIM" e inverte ela
int main ( ) {
    char s[2000] = "";
    char i[2000] = "";
    char n[2000] = "";
    scanf("%[^\r\n]%*c", s);
    while ( ! isFim(s) ) {
        printf("%s\n", m(s,i,0) );
        for ( int z = 0; z < 2000; z++) {
            i[z] = '\0';
        } 
        scanf("%[^\r\n]%*c", s);
    }
    return 0;
}