#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main () {
    FILE *arquivoOut;
    int n;
    double d;
    arquivoOut = fopen("temp.out", "w");

    if (!arquivoOut) {
        perror("ERRO");
        return 1;
    }

    scanf("%d", &n);
    for ( int y=0; y<n; y++ ) {
        scanf("%lf", &d);
        fprintf(arquivoOut, "%g\n", d);
    }
    
    fclose(arquivoOut);

    FILE *fileRead;
    fileRead = fopen("temp.out", "r");
    long marked;
    char c;

    fseek(fileRead, 0, SEEK_END);
    long size = ftell(fileRead);
    long lastN = size;

    for ( long i = 1; i < size; i++ ) {
        fseek(fileRead, -1*i, SEEK_END); 
        //long mark = ftell(fileRead); // para saber o length de onde eu estou antes de fazer uma leitura e avancar em um o filePointer
        fscanf(fileRead,"%c", &c);
        if ( c == '\n' ) {
            // pointer esta um depois do \n
            //printf("here ");
            //printf("->%ld\n", i);
            marked = lastN; 
            if ( fseek(fileRead, -1, SEEK_CUR) == 0 ) {
                fseek(fileRead, -1, SEEK_CUR);   
                lastN = ftell(fileRead);
            }
            // pointer esta no \n
            fseek(fileRead, 1, SEEK_CUR);
            // pointer esta um depois do \n
            if ( ! feof(fileRead) ) {
                fscanf(fileRead,"%g", &d);
            }
            printf("%g\n",d);
        } else if ( i == size-1 ) {
            // pointer esta um depois do \n
            //printf("here2 ");
            //printf("->%ld\n", i);
            marked = lastN;
            if ( ! feof(fileRead) ) {
                fscanf(fileRead,"%g", &d);
            }
            printf("%g\n",d);
        }
    }
    
    fclose(fileRead);

    return 0;
}

/*
else if ( i == 0 ) {
    marked = lastN;

    int count = 0;
    bool flag = true;

    for ( long z = i; fseek(fileRead, -1*z, SEEK_END) == 0 && flag; z++ ) {
        if ( ! feof(fileRead) ) {
            fseek(fileRead, -1*z, SEEK_END); 
            fscanf(fileRead,"%c", &c);
        }

        if ( z == i && c == '.' ) {
            printf("0");
        }

        if (c == '.') {count = 1;}
        else if (c == '0' && count == 1) {count = 2;}
        else if (c == '\n' && count == 2) {flag = false;}
        else if (count == 2) {printf(".0%c",c); count = 0;}
        else if (count == 1) {printf(".%c",c); count = 0;}
        else {printf("%c",c); count = 0;}
    }

    printf("\n");
}
*/