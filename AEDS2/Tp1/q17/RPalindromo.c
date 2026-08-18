#include <stdio.h>
#include <stdbool.h>
#include <string.h>

//checa se a string é palindromo
bool isPalindromo ( char s[], int y ) {
        bool result = true;
        int l;
        l = strlen(s);
        if ( y < l/2 ) {
            if ( s[y] != s[l-y-1] ) {
                result = false;
            } else {
                result = isPalindromo(s,++y);
            }
        }
        return result;
    }

//checa se a string é "FIM"
bool isFim (char s[]) {
    bool result = false;
    if (s[0] == 'F' && s[1] == 'I' && s[2] == 'M') { result = 1; } 
    return result;
}

//main que le entrada e retorna se é palindromo
int main () {
    char s[1000];
    scanf( "%[^\n]", s );
    while ( ! isFim(s) ) {
        if (isPalindromo(s,0)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
        scanf( " %[^\n]", s );
    }

    return 0;
}