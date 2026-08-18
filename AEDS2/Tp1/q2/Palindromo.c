#include <stdio.h>
#include <stdbool.h>
#include <string.h>

//checa se a string é palindromo
bool isPalindromo ( char s[] ) {
        bool result = true;
        int l;
        l = strlen(s);
        for (int y = 0; y < l/2 && result; y++) {
            if ( s[y] != s[l-y-1] ) {
                result = false;
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
        if (isPalindromo(s)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
        scanf( "%[^\n]", s );
    }

    return 0;
}