#include <stdio.h>
#include <stdbool.h>
#include <string.h>

//metodo que verifica se entrada é "FIM"
bool f ( char s[] ) {
    bool result = true;
    if ( strlen(s) >= 3) {
        result = s[0] == 'F' && s[1] == 'I' && s[2] == 'M';
    } else {
        result = false;
    }
    return result;
}

//funcao que calcula soma de digitos
int sum(char s[], int n, int y) {
    if ( y < strlen(s) ) {
        n += sum(s,n,++y);
        n += (int)s[y-1]-48;
    }
    return n;
}

// metodo que soma digitos de um numero e retorna valor
int main ( ) {
    char s[2000] = "";
    scanf("%[^\r\n]%*c", s);
    while ( ! f(s) ) {
        printf("%i\n", sum(s,0,0));
        scanf("%[^\r\n]%*c", s);
    }
    return 0;
}