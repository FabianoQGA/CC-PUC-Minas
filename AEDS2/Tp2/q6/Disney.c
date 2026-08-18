#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <wchar.h>   
#include <locale.h>
#include <time.h>

int n = 0;
int comparacoes = 0;
int movimentacoes = 0;

/**
 * Struct para atributo date_added
 */
typedef struct {
    int day;
    int month;
    int year;
} Date;

/**
 * Struct para personagem
 */
typedef struct {
    char *id;
    char *type;
    char *title;
    char **director;
    char **cast;
    char **country;
    Date date_added;
    int release_year;
    char *rating;
    char *duration;
    char **listed_in;
    //char *description;
} Show;

/**
 * Struct de date
 */
Date *createDefaultDate() {
    Date *date = malloc(sizeof(Date));
    date->day = 0;
    date->month = 0;
    date->year = 0;
    return date;
}

/**
 * Struct alternativo de date
 */
Show *createDate(int x, int y, int z, Show *show) {
    Date *date = malloc(sizeof(Date));
    date->day = x;
    date->month = y;
    date->year = z;
    show->date_added = *date;
    return show;
}

/**
 * Construtor de show
 */
Show *createDefaultShow() {
    Show *show = (Show*) malloc(sizeof(Show));
    Date *date = createDefaultDate();
    show->id = strdup("");
    show->type = strdup("");
    show->title = strdup("");
    show->director = calloc(30,sizeof(char*));
    show->cast = calloc(30,sizeof(char*));
    show->country = calloc(30,sizeof(char*));
    show->date_added = *date;
    show->release_year = -1;
    show->rating = strdup("");
    show->duration = strdup("");
    show->listed_in = calloc(30,sizeof(char*));
    //show->description = strdup("");
    return show;
}

/**
 * Construtor alternativo de show
 */
Show *createShow(char *id, char *type, char *title, char **director, char **cast, char **country,
                Date *date_added, int release_year, char *rating, char *duration, char **listed_in ) {
    Show *show = (Show*) malloc(sizeof(Show));
    show->id = strdup(id);
    show->type = strdup(type);
    show->title = strdup(title);
    show->director = malloc(30 * sizeof(char*));
    for (int i = 0; i < 30; i++) {
        show->director[i] = strdup("");
    }
    show->cast = malloc(30 * sizeof(char*));
    for (int i = 0; i < 30; i++) {
        show->cast[i] = strdup("");
    }
    show->country = malloc(30 * sizeof(char*));
    for (int i = 0; i < 30; i++) {
        show->country[i] = strdup("");
    }
    show->date_added = *date_added;
    show->release_year = release_year;
    show->rating = strdup(rating);
    show->duration = strdup(duration);
    show->listed_in = malloc(30 * sizeof(char*));
    for (int i = 0; i < 30; i++) {
        show->listed_in[i] = strdup("");
    }
    //show->description = strdup(description);
    return show;
}

/**
 * Metodo de clonar show
 */
Show *createClone ( Show *clonado ) {
    Show *show = (Show*) malloc(sizeof(Show));
    show->id = strdup(clonado->id);
    show->type = strdup(clonado->type);
    show->title = strdup(clonado->title);
    for ( int y = 0; clonado->director[y]; y++ ) {
        show->director[y] = strdup(clonado->director[y]);
    }
    for ( int y = 0; clonado->cast[y]; y++ ) {
        show->cast[y] = strdup(clonado->cast[y]);
    }
    for ( int y = 0; clonado->country[y]; y++ ) {
        show->country[y] = strdup(clonado->country[y]);
    }
    show->date_added = clonado->date_added;
    show->release_year = clonado->release_year;
    show->rating = strdup(clonado->rating);
    show->duration = strdup(clonado->duration);
    for ( int y = 0; clonado->listed_in[y]; y++ ) {
        show->listed_in[y] = strdup(clonado->listed_in[y]);
    }
    //show->description = strdup(clonado->description);
    return show;
}

/**
 * Setters
 */
void set_id ( Show *show, char *s )             { show->id = s; }
void set_type ( Show *show, char *s )           { show->type = s; }
void set_title ( Show *show, char *s )          { show->title = s; }
void set_director ( Show *show, char **p )      { show->director = p; }
void set_cast ( Show *show, char **p )          { show->cast = p; }
void set_country ( Show *show, char **p )       { show->country = p; }
void set_date_added ( Show *show, Date d )      { show->date_added = d; }
void set_release_year ( Show *show, int i )     { show->release_year = i; }
void set_rating ( Show *show, char *s )         { show->rating = s; }
void set_duration ( Show *show, char *s )       { show->duration = s; }
void set_listed_in ( Show *show, char **p )     { show->listed_in = p; }
//void set_description ( Show *show, char *s )    { show->description = s; }


/**
 * Getters
 */
char *get_id ( Show *show )             { return show->id; }
char *get_type ( Show *show )           { return show->type; }
char *get_title ( Show *show )          { return show->title; }
char **get_director ( Show *show )      { return show->director; }
char **get_cast ( Show *show )          { return show->cast; }
char **get_country ( Show *show )       { return show->country; }
Date get_date_added ( Show *show )      { return show->date_added; }
int get_release_year ( Show *show )     { return show->release_year; }
char *get_rating ( Show *show )         { return show->rating; }
char *get_duration ( Show *show )       { return show->duration; }
char **get_listed_in ( Show *show )     { return show->listed_in; }
//char *get_description ( Show *show )    { return show->description; }

bool exists (Show *show) {
    bool result = false;
    Date *ptr = malloc(sizeof(Date)); 
    *ptr = get_date_added(show);
    if ( show->id != NULL && 
        show->type != NULL && 
        show->title != NULL && 
        show->director != NULL && 
        show->cast != NULL && 
        show->country != NULL && 
        ptr != NULL && 
        show->rating != NULL && 
        show->duration != NULL && 
        show->listed_in != NULL  ) { result = true; }
    return result;
}

/**
 * Metodo para dar free em shows
 */
void freeShow (Show *show) {
    if ( exists(show) ) {
        free(show->id); show->id = NULL;
        free(show->type); show->type = NULL;
        free(show->title); show->title = NULL;
        for ( int y = 0; show->director[y] != NULL; y++ ) {
            free(show->director[y]);
        }
        free(show->director); show->director = NULL;
        for ( int y = 0; show->cast[y] != NULL; y++ ) {
            free(show->cast[y]);
        }
        free(show->cast); show->cast = NULL;
        for ( int y = 0; show->country[y] != NULL; y++ ) {
            free(show->country[y]);
        } 
        free(show->country); show->country = NULL;
        //no free static int release_year
        free(show->rating); show->rating = NULL;
        free(show->duration); show->duration = NULL;
        for ( int y = 0; show->listed_in[y] != NULL; y++ ) {
            free(show->listed_in[y]);
        }
        free(show->listed_in); show->listed_in = NULL;
        //free(show->description);
        show = NULL;
        //free(show); 
    }
}

/**
 * Da trim em strings de dias do mes e converte meses para ints
 */
int find_date ( char *s, bool isMonth ) {
    int date = 0;
    char temp[30];
    if ( ! isMonth ) {
        int ty = 0;
        for ( int y = 0; y < strlen(s); y++ ) {
            if ( s[y] >= '0' && s[y] <= '9' ) {
                temp[ty++] = s[y];
            }
        }
        date = atoi(temp);
    } else {
        if ( strcmp(s,"January") == 0 ) {
            date = 1;
        } else if ( strcmp(s,"February") == 0 ) {
            date = 2;
        } else if ( strcmp(s,"March") == 0 ) {
            date = 3;
        } else if ( strcmp(s,"April") == 0 ) {
            date = 4;
        } else if ( strcmp(s,"May") == 0 ) {
            date = 5;
        } else if ( strcmp(s,"June") == 0 ) {
            date = 6;
        } else if ( strcmp(s,"July") == 0 ) {
            date = 7;
        } else if ( strcmp(s,"August") == 0 ) {
            date = 8;
        } else if ( strcmp(s,"September") == 0 ) {
            date = 9;
        } else if ( strcmp(s,"October") == 0 ) {
            date = 10;
        } else if ( strcmp(s,"November") == 0 ) {
            date = 11;
        } else if ( strcmp(s,"December") == 0 ) {
            date = 12;
        }
    }
    
    return date;
}

/**
 * Converte date para string (mes)
 */
char *dtos ( int n ) {
    switch(n) {
        case 1:
            return "January";
        break;
        case 2:
            return "February";
        break;
        case 3:
            return "March";
        break;
        case 4:
            return "April";
        break;
        case 5:
            return "May";
        break;
        case 6:
            return "June";
        break;
        case 7:
            return "July";
        break;
        case 8:
            return "August";
        break;
        case 9:
            return "September";
        break;
        case 10:
            return "October";
        break;
        case 11:
            return "November";
        break;
        case 12:
            return "December";
        break;
                    
    }
}

/**
 * Metodo para tirar aspas e espacos (espacos que estao antes dos primeiros simbolos)
 */
char *trimmers(char *s) {
    char *temp = malloc(strlen(s) + 1);  //+1 for null terminator
    if (!temp) return NULL;
    int ty = 0;
    bool found_symbol = false;
    for ( int y = 0; y < strlen(s); y++ ) {
        if (s[y] != ' ' && s[y] != '"') {
            found_symbol = true;
            temp[ty++] = s[y];
        } else if (s[y] == ' ' && found_symbol) {
            temp[ty++] = s[y];
        }
    }
    temp[ty] = '\0';
    return temp;
}

/**
 * Metodo que divide string de acordo com um delimitador e retorna a divisao em um array de strings
 */
char **split( const char splitter, char *s ) {
    int length = 0, sY = 0, i = 0, j = 0;
    while(*(s++)) {
        if (*s == splitter) { sY++; }
        length++;
    }
    s -= (length + 1);
    char **returno = (char **)malloc(sizeof(char *) * (length + 1));
    char **first_of_returno = returno;
    for(i = 0; i < (sY + 1); i++) {
        j = 0;
        while( s[j] && s[j] != splitter ) { j++; }              
        //if ( s[j] == '\0' ) { printf("ERROR - %s\n", s ); return NULL; }
        j++;
        *returno = (char *)malloc(sizeof(char) * j);
        memcpy(*returno, s, (j-1));                         
        (*returno)[j-1] = '\0';
        s += j;
        returno++;
    }
    *returno = '\0';
    return first_of_returno;  
}

/**
 * Retorna tamanho de array de strings
 */
int starlen(char **array) {
    int sum;
    for ( sum = 0; array[sum] != NULL; sum++ );
    return sum;
}

/**
 * Converte maiusculas para minusculas
 */
char setminiscule (char a) {
    if (a >= 65 && a <= 90) {
        a = (char)(a + 32);
    }
    return a;
}

/**
 * Compara alfabeticamente duas strings
 */ 
bool comparelessthan(char* a, char* b) {
    int la = strlen(a);
    int lb = strlen(b);
    int bobo = (la < lb) ? la : lb;
    for ( int y = 0; y < bobo; y++ ) {
        if ( setminiscule(a[y]) != setminiscule(b[y]) ) {
            return setminiscule(a[y]) < setminiscule(b[y]);
        }
    }
    return la < lb;
}

/**
 * Ordena array de strings alfabeticamente
 */
void nameselection (char** s, int size) {
    char* temp;
    for ( int i = 0; i < size-1; i++ ) {
        int menor = i; 
        for ( int j = i+1; j < size; j++ ) {
            if ( comparelessthan(s[j],s[menor])) {
                menor = j;
            }
        }
        temp = s[i];
        s[i] = s[menor];
        s[menor] = temp;
    }
}

/**
 * Ordena array de strings alfabeticamente
 */
void disneyplusselection (Show *disneyplus, int size, int i, int j, int menor ) {
    if ( i < size-1 ) {
        if ( j < size ) {
            if ( comparelessthan(disneyplus[j].title, disneyplus[menor].title) ) {
                menor = j;
            }
            comparacoes++;
            disneyplusselection(disneyplus,size,i,++j,menor);
        } else {
            Show temp = disneyplus[i];
            disneyplus[i] = disneyplus[menor];
            disneyplus[menor] = temp;
            movimentacoes += 3;
            i++;
            disneyplusselection(disneyplus,size,i,i+1,i);
        }
    }
}

/**
 * Metodo que le disneyplus.csv e procura se um id estao presente. Se tiver, inicializa todos os atributos e 
 * faz disneyplus apontar para o novo objeto de show
 */
void read (char *s, Show *disneyplus) {
    FILE *dptr;
    dptr = fopen("../../tmp/disneyplus.csv", "r");
    if (dptr == NULL) {
        perror("FILE ERROR IN READ");
    }
    bool encontrado = 0;
    char *entire_line = malloc(500 * sizeof(char));
    char *id_index = malloc(50 * sizeof(char));
    fgets(entire_line,500,dptr); //skip first line of csv
    fgets(entire_line,500,dptr);
    entire_line[strcspn(entire_line, "\n")] = '\0';
    
    char **full_string = malloc(250*sizeof(char*));       
    
    for ( int y = 0; strcmp(entire_line,"FIM") != 0 && !encontrado; y++ ) {
        full_string = split(',', entire_line);
        id_index = strdup(full_string[0]);
        if ( strcmp(id_index,s) == 0 ) {
            encontrado = true;
        } else {
            fgets(entire_line,500,dptr);
            entire_line[strcspn(entire_line, "\n")] = '\0';
        }
    }

    if ( encontrado )
    {
        // Quando o é encontrado: entire_line contem a linha inteira de sN e full_string contem essa mesma string dividida
        //for ( int y = 0; full_string[y]; y++ ) { printf("%d => %s\n",y ,full_string[y]); }
        
        Show *show = createDefaultShow();
        int index = 0;
        show->id = strdup(full_string[index++]);

        if ( strcmp(full_string[index],"") == 0 ) {
            show->type = "NaN";
            index++;
        } else {
            show->type = strdup(full_string[index++]);
        }

        bool has_virgula = false;
        bool has_quotation = false;
        if ( full_string[index][0] == '"' ) {
            for ( int y = 1; y < strlen(full_string[index]) && ( !has_virgula || !has_quotation ); y++) {
                if ( y != strlen(full_string[index])-1 && full_string[index][y] == '"' ) {
                    has_quotation = true;
                }
                if ( !has_virgula && full_string[index][strlen(full_string[index])-1] != '"' ) {
                    has_virgula = true;
                }
            }
        }
        if ( strcmp(full_string[index],"") == 0 ) {
            show->title = strdup("NaN");
            index++;
        } else if ( has_virgula && ! has_quotation ) {
            char *title_analysis = split('\"', entire_line)[1];
            show->title = trimmers(title_analysis);
            int virgula_count = 0;
            for ( int y = 0; y < strlen(title_analysis); y++ ) {
                if ( title_analysis[y] == ',' ) {
                    virgula_count++;
                }
            }
            index += virgula_count+1;
            free(title_analysis);
        } else {
            show->title = trimmers(full_string[index++]);
        }

        int i = 0;

        char **array_director = malloc(80*sizeof(char*));
        if ( strcmp(full_string[index],"") != 0 && full_string[index][0] == '"' ) {
            int count = 0;
            while ( full_string[index][strlen(full_string[index])-1] != '"' ) {
                array_director[count++] = strdup(trimmers(full_string[index++]));
            }
            array_director[count++] = strdup(trimmers(full_string[index++]));
            array_director[count] = '\0';
        } else if ( strcmp(full_string[index],"") == 0 ) {
            array_director[0] = "NaN";
            array_director[1] = '\0';
            index++;
        } else {
            array_director[0] = strdup(trimmers(full_string[index++]));
            array_director[1] = '\0';
        }
        for ( i = 0; array_director[i]; i++ ){
            show->director[i] = strdup(array_director[i]);
        }
        show->director[i] = '\0';
        for ( int y = 0; array_director[y] && strcmp(array_director[y],"NaN") != 0 ; y++ ) {
            free(array_director[y]);
        }
        free(array_director);

        char **array_cast = malloc(80*sizeof(char*));
        if ( strcmp(full_string[index],"") != 0 && full_string[index][0] == '"' ) {
            int count = 0;
            while ( full_string[index][strlen(full_string[index])-1] != '"' ) {
                array_cast[count++] = strdup(trimmers(full_string[index++]));
            }
            array_cast[count++] = strdup(trimmers(full_string[index++]));
            array_cast[count] = '\0';
        } else if ( strcmp(full_string[index],"") == 0 ) {
            array_cast[0] = "NaN";
            array_cast[1] = '\0';
            index++;
        } else {
            array_cast[0] = strdup(trimmers(full_string[index++]));
            array_cast[1] = '\0';
        }
        nameselection(array_cast,starlen(array_cast));
        for ( i = 0; array_cast[i]; i++ ){
            show->cast[i] = strdup(array_cast[i]);
        }
        show->cast[i] = '\0';
        for ( int y = 0; array_cast[y] && strcmp(array_cast[y],"NaN") != 0; y++ ) {
            free(array_cast[y]);
        }
        free(array_cast);
        
        char **array_country = malloc(80*sizeof(char*));
        if ( strcmp(full_string[index],"") != 0 && full_string[index][0] == '"' ) {
            int count = 0;
            while ( full_string[index][strlen(full_string[index])-1] != '"' ) {
                array_country[count++] = strdup(trimmers(full_string[index++]));
            }
            array_country[count++] = strdup(trimmers(full_string[index++]));
            array_country[count] = '\0';
        } else if ( strcmp(full_string[index],"") == 0 ) {
            array_country[0] = "NaN";
            array_country[1] = '\0';
            index++;
        } else {
            array_country[0] = strdup(trimmers(full_string[index++]));
            array_country[1] = '\0';
        }
        for ( i = 0; array_country[i]; i++ ){
            show->country[i] = strdup(array_country[i]);
        }
        show->country[i] = '\0';
        for ( int y = 0; array_country[y] && strcmp(array_country[y],"NaN") != 0; y++ ) {
            free(array_country[y]);
        }
        free(array_country);

        char **date_itself = malloc(30*sizeof(char*));
        char *date_string = malloc(50*sizeof(char));
        Date *date_template = createDefaultDate();
        if ( strcmp(full_string[index],"") == 0 ) {
            show->date_added = *date_template;
            index++;
        } else {
            date_string = strdup(full_string[index]);
            strcat(date_string,full_string[index+1]);
            date_itself = split(' ',date_string);
            date_itself[0] = trimmers(date_itself[0]);
            date_itself[2] = trimmers(date_itself[2]);

            date_template->month = find_date(date_itself[0], true);
            date_template->day = find_date(date_itself[1], false);
            date_template->year = atoi(date_itself[2]);
            show = createDate(date_template->day, date_template->month, date_template->year, show);
            index += 2;
        }

        free(date_string);
        for ( int y = 0; y < 3; y++ ) {
            free(date_itself[y]);
        }
        free(date_itself);

        if ( strcmp(full_string[index],"") == 0 ) {
            show->release_year = -1;
            index++;
        } else {
            show->release_year = atoi(full_string[index++]);
        }

        if ( strcmp(full_string[index],"") == 0 ) {
            show->rating = "NaN";
            index++;
        } else {
            show->rating = strdup(full_string[index++]);
        }

        if ( strcmp(full_string[index],"") == 0 ) {
            show->duration ="NaN";
            index++;
        } else {
            show->duration = strdup(full_string[index++]);
        }

        char **array_listed_in = malloc(80*sizeof(char*));
        if ( strcmp(full_string[index],"") != 0 && full_string[index][0] == '"' ) {
            int count = 0;
            while ( full_string[index][strlen(full_string[index])-1] != '"' ) {
                array_listed_in[count++] = strdup(trimmers(full_string[index++]));
            }
            array_listed_in[count++] = strdup(trimmers(full_string[index++]));
            array_listed_in[count] = '\0';
        } else if ( strcmp(full_string[index],"") == 0 ) {
            array_listed_in[0] = "NaN";
            array_listed_in[1] = '\0';
            index++;
        } else {
            array_listed_in[0] = strdup(trimmers(full_string[index++]));
            array_listed_in[1] = '\0';
        }
        nameselection(array_listed_in,starlen(array_listed_in));
        for ( i = 0; array_listed_in[i]; i++ ){
            show->listed_in[i] = strdup(array_listed_in[i]);
        }
        show->listed_in[i] = '\0';
        for ( int y = 0; array_listed_in[y] && strcmp(array_listed_in[y],"NaN") != 0; y++ ) {
            free(array_listed_in[y]);
        }
        free(array_listed_in);
        
        /* if ( strcmp(full_string[index],"") == 0 ) {
            show->description ="NaN";
            index++;
        } else {
            show->description = strdup(full_string[index++]);
        }*/

        full_string[index] = '\0';

        disneyplus[n++] = *show;
    }

    for ( int y = 0; full_string[y]; y++ ) {
        free(full_string[y]);
    }
    free(full_string);
    free(entire_line);
    //free(id_index);
    fclose(dptr);
}

/**
 * Metodo que printa atributos de um Show
 */
void print( Show *show ) {
    printf("=> %s ## %s ## %s ## ", show->id, show->title, show->type);
    for ( int y = 0; show->director[y]; y++) {
        if (show->director[y+1] ) 
        { 
            printf("%s, ", show->director[y]); 
        }
        else 
        { 
            printf("%s ## [",show->director[y]); 
        }
    }
    for ( int y = 0; show->cast[y]; y++) {
        if (show->cast[y+1]) 
        { 
            printf("%s, ", show->cast[y]); 
        }
        else 
        { 
            printf("%s] ## ",show->cast[y]); 
        }
    }
    for ( int y = 0; show->country[y]; y++) {
        if (show->country[y+1]) 
        { 
            printf("%s, ", show->country[y]); 
        }
        else 
        { 
            printf("%s ## ",show->country[y]); 
        }
    }
    if ( get_date_added(show).month == 0 && get_date_added(show).day == 0 ) {
        printf("NaN ## ");
    } else {
        printf("%s %d, %d ## ",dtos(get_date_added(show).month), get_date_added(show).day, get_date_added(show).year );
    }
    if ( show->release_year == -1 ) {
        printf("NaN ## ");
    } else {
        printf("%d ## ", show->release_year);
    }
    printf("%s ## %s ## [", show->rating, show->duration );
    for ( int y = 0; show->listed_in[y]; y++) {
        if (show->listed_in[y+1]) 
        { 
            printf("%s, ", show->listed_in[y]); 
        }
        else 
        { 
            printf("%s] ##\n",show->listed_in[y]); 
        }
    }
    //printf("%s\n",show->description );
}

/**
 * Metodo main que le uma string de um id e ve se ele esta presente no csv, depois printa todos atributos do id procurado se existir
 */
int main ( ) {
    setlocale(LC_CTYPE, "UTF-8");
    float time = 0.0;
    clock_t then = clock();

    FILE *ptr = fopen("matricula_selecaoRecursiva.txt", "w");
    if ( ptr == NULL) {
        perror("PTR ERROR CREATE");
        fclose(ptr);
        return 1;
    }

    char s[500];
    if (s == NULL) {
        perror("S MEMORY ALLOCATION ERROR");
        free(s);
        return 1;
    }

    Show *disneyplus = malloc(1400*sizeof(Show));
    if (disneyplus == NULL) {
        perror("disneyplus MEMORY ALLOCATION ERROR");
        free(disneyplus);
        return 1;
    }

    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = '\0';
    while ( strcmp(s,"FIM") != 0 ) {
        read(s,disneyplus);
        fgets(s, sizeof(s), stdin);
        s[strcspn(s, "\n")] = '\0';
    }

    disneyplusselection(disneyplus,n,0,1,0);
    for ( int y = 0; y < n; y++ ) {
        print(disneyplus+y);
    }

    clock_t now = clock();
    time = now - then;
    fprintf(ptr,"782195\t%f\t%d\t%d", time, movimentacoes, comparacoes);

    for ( int z = 0; z < n; z++ ) {
        freeShow(disneyplus+z);
    }
    free(disneyplus);
    fclose(ptr);

    return 0;
}