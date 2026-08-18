import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Data {
    private int day;
    private int month;
    private int year;
    private boolean is_null;

    public Data ( ) {
        day = 0;
        month = 0;
        year = 0;
        is_null = true;
    }

    public Data ( int d, int m, int y, boolean b ) {
        day = d;
        month = m;
        year = y;
        is_null = b;
    }

    public int get_day() {
        return day;
    }

    public int get_month() {
        return month;
    }

    public int get_year() {
        return year;
    }

    public boolean get_is_null() {
        return is_null;
    }

    public void set_day ( int d ) {
        day = d;
    }

    public void set_month ( int m ) {
        month = m;
    }

    public void set_year ( int y ) {
        year = y;
    }

    public void set_is_null ( boolean b ) {
        is_null = b;
    } 
}

class Cell {
    public Show value;
    public Cell next;
    
    public Cell ( ) {
        value = new Show();
        next = null;
    }

    public Cell ( Show temp ) {
        value = temp;
        next = null;
    }
}

class List {
    private Cell first;
    private Cell last;
    private int n;

    public List ( ) {
        first = new Cell();
        last = first;
    }

    public void insertFirst ( Show show ) {
        Cell tmp = new Cell (show);
        tmp.next = first.next;
		first.next = tmp;
		if (first == last) {                 
			last = tmp;
		}
        tmp = null;
        n++;
    }

    public void insertLast ( Show show ) {
        last.next = new Cell (show);
        last = last.next;
        n++;
    }

    public void insert ( Show show, int pos ) throws Exception {
        if ( pos == 0 ) {
            insertFirst(show);
        } else if ( pos == n ) {
            insertLast(show);
        } else if ( pos > n || pos < 0 ) {
            throw new Exception ("Pos value error in insert List");
        } else {
            Cell i = first.next;
            for(int j = 0; j < pos; j++, i = i.next);
            Cell tmp = new Cell(show);
            tmp.next = i.next;
            i.next = tmp;
            tmp = i = null;
        }
    }

    public Show removeFirst ( ) throws Exception {
        if ( first == last ) {
            throw new Exception ("Tried removing empty List at removeFirst");
        }

        Cell tmp = first;
        first = first.next;
        Show answ = first.value;
        tmp.next = null;
        tmp = null;
        n--;

        return answ;
    }

    public Show removeLast ( ) throws Exception {
        if ( first == last ) {
            throw new Exception ("Tried removing empty List at removeLast");
        }

        Cell i;
        for ( i = first.next; i.next != last; i = i.next );
        last = i;
        last.next = null;
        Show answ = last.value;
        n--;
        
        return answ;
    }

    public Show remove ( int pos ) throws Exception {
        Show answ;
        if ( first == last ) {
            throw new Exception ("Tried removing empty List at remove");
        } else if ( pos < 0 || pos > n ) {
            throw new Exception ("Pos value error in remove");
        } else if ( pos == 0 ) {
            answ = removeFirst();
        } else if ( pos == n ) {
            answ = removeLast();
        } else {
            Cell i = first.next;
            for ( int y = 0; y < pos-1; y++, i = i.next );
            Cell tmp = i.next;
            answ = tmp.value;
            i.next = tmp.next;
            tmp.next = null;
            tmp = i = null;
            n--;
        }

        return answ;
    }

    public void show ( ) {
        System.out.print("[");
        for ( Cell i = first.next; i != null; i = i.next ) {
            if ( i.next != null ) {
                System.out.print(i.value.get_title() + " ### ");
            } else {
                System.out.print(i.value.get_title());
            }
        }
        System.out.println("]");
    }
}

class Show {
    private String id;
    private String type;
    private String title;
    private String[] director;
    private String[] cast;
    private String[] country;
    private Data date_added;
    private int release_year;
    private String rating;
    private String duration;
    private String[] listed_in;
    //private String description;

    public Show ( ) {
        id = "";
        type = "";
        title = "";
        director = new String[30];
        cast = new String[30];
        country = new String[30];
        date_added = new Data();
        release_year = 0;
        rating = "";
        duration = "";
        listed_in = new String[30];
        //description = "";
    }

    public Show ( String idP, String typeP, String titleP, String[] directorP, String[] castP, String[] countryP,
                Data date_addedP, boolean date_is_nanP, int release_yearP, String ratingP, String durationP, String[] listed_inP, 
                String descriptionP ) {
        id = idP;
        type = typeP;
        title = titleP;
        director = directorP;
        for ( int y = 0; castP[y] != null; y++ ) {
            cast[y] = castP[y];
        }
        country = countryP;
        date_added = date_addedP;
        release_year = release_yearP;
        rating = ratingP;
        duration = durationP;
        for ( int y = 0; listed_inP[y] != null; y++ ) {
            listed_in[y] = listed_inP[y];
        }
        //description = descriptionP;
    }

    public void clone(Show showP) {
        id = showP.id;
        type = showP.type;
        title = showP.title;
        director = showP.director;
        for ( int y = 0; showP.cast[y] != null; y++ ) {
            cast[y] = showP.cast[y];
        }
        for ( int y = 0; showP.country[y] != null; y++ ) {
            country[y] = showP.country[y];
        }
        date_added = showP.date_added;
        release_year = showP.release_year;
        rating = showP.rating;
        duration = showP.duration;
        for ( int y = 0; showP.listed_in[y] != null; y++ ) {
            listed_in[y] = showP.listed_in[y];
        }
        //description = showP.description;
    }

    public void set_show_id (String s) {
        id = s;
    }

    public void set_type (String s) {
        type = s;
    }

    public void set_title (String s) {
        title = s;
    }

    public void set_director (String[] array) {
        for ( int y = 0; array[y] != null; y++ ) {
            director[y] = array[y];
        }
    }

    public void set_cast (String[] array) {
        for ( int y = 0; array[y] != null; y++ ) {
            cast[y] = array[y];
        }
    }

    public void set_country (String[] array) {
        for ( int y = 0; array[y] != null; y++ ) {
            country[y] = array[y];
        }
    }

    public void set_date_added (Data d) {
        date_added = d;
    }

    public void set_release_year (int i) {
        release_year = i;
    }

    public void set_rating (String s) {
        rating = s;
    }

    public void set_duration (String s) {
        duration = s;
    }

    public void set_listed_in (String[] array) {
        for ( int y = 0; array[y] != null; y++ ) {
            listed_in[y] = array[y];
        }
    }

    /*public void set_description (String s) {
        description = s;
    } */

    public String get_id () {
        return id;
    }

    public String get_type () {
        return type;
    }

    public String get_title () {
        return title;
    }

    public String[] get_director () {
        return director;
    }

    public String[] get_cast () {
        return cast;
    }

    public String[] get_country () {
        return country;
    }

    public Data get_date_added () {
        return date_added;
    }

    public int get_release_year () {
        return release_year;
    }

    public String get_rating () {
        return rating;
    }

    public String get_duration () {
        return duration;
    }

    public String[] get_listed_in() {
        return listed_in;
    }

    /*public String get_description() {
        return description;
    } */

    /**
     * // OUTROS METODOS:
     */

    /**
     *   similar ao split, separa strings em array de strings de acordo com a presenca de virgula
    */
    public String[] stringtok (String s) {
        String[] array = new String[200];
        String temp = "";
        int z = 0;
        for ( int y = 0; y < s.length(); y++ ) {
            if ( s.charAt(y) == ',' || y == s.length()-1 ) {
                array[z++] = temp;
                temp = "";
            } else {
                temp += s.charAt(y);
            }
        }
        return array;
    }

    /**
     * Se a string tem espaco no comeco antes de qualquer simbolo remove todos os espacos. Tambem remove aspas na string toda
     */
    public String trimmers(String s) {
        String temp = "";
        boolean found_symbol = false;
        for ( int y = 0; y < s.length(); y++ ) {
            if (s.charAt(y) != ' ' && s.charAt(y) != '"') {
                found_symbol = true;
                temp += s.charAt(y);
            } else if (s.charAt(y) == ' ' && found_symbol) {
                temp += s.charAt(y);
            }
        }
        return temp;
    }

    /**
     * Faz um parseInt de s quando isMonth e falso e quando true converte para int uma string
     */
    public int find_date ( String s, boolean isMonth ) {
        int date = 0;
        String temp = "";
        if ( ! isMonth ) {
            for ( int y = 0; y < s.length(); y++ ) {
                if ( s.charAt(y) >= '0' && s.charAt(y) <= '9' ) {
                    temp += s.charAt(y);
                }
            }
            date = Integer.parseInt(temp);
        } else {
            switch(s) {
                case "January":
                    date = 1;
                break;
                case "February":
                    date = 2;
                break;
                case "March":
                    date = 3;
                break;
                case "April":
                    date = 4;
                break;
                case "May":
                    date = 5;
                break;
                case "June":
                    date = 6;
                break;
                case "July":
                    date = 7;
                break;
                case "August":
                    date = 8;
                break;
                case "September":
                    date = 9;
                break;
                case "October":
                    date = 10;
                break;
                case "November":
                    date = 11;
                break;
                case "December":
                    date = 12;
                break;              
            }
        }
        
        return date;
    }

    /**
     * Faz o contrario do find date para meses, converte ints para meses do ano.
     */
    public String dtos ( int n ) {
        String resp = "";
        switch(n) {
            case 1:
                resp = "January";
            break;
            case 2:
                resp = "February";
            break;
            case 3:
                resp = "March";
            break;
            case 4:
                resp = "April";
            break;
            case 5:
                resp = "May";
            break;
            case 6:
                resp = "June";
            break;
            case 7:
                resp = "July";
            break;
            case 8:
                resp = "August";
            break;
            case 9:
                resp = "September";
            break;
            case 10:
                resp = "October";
            break;
            case 11:
                resp = "November";
            break;
            case 12:
                resp = "December";
            break;
                        
        }
        return resp;
    }

    /**
     * Retorna numero de elementos dee uma array de strings
     */
    public int sizeof ( String[] array ) {
        int value;
        for ( value = 0; array[value] != null; value++ );
        return value;
    }

    public char setminiscule (char a) {
        if (a >= 65 && a <= 90) {
            a = (char)(a + 32);
        }
        return a;
    }

    public boolean comparelessthan(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int bobo = (la < lb) ? la : lb;
        for ( int y = 0; y < bobo; y++ ) {
            if ( setminiscule(a.charAt(y)) != setminiscule(b.charAt(y)) ) {
                return setminiscule(a.charAt(y)) < setminiscule(b.charAt(y));
            }
        }
        return la < lb;
}

    /**
     * Faz ordenacao em array de strings
     */
    public String[] sort_array_string ( String[] array ) {
        int menor = 0;
        int n = sizeof(array);
        for ( int i = 0; i < n-1; i++ ) {
            menor = i;
            for ( int j = i+1; j < n; j++ ) {
                if ( comparelessthan(array[j], array[menor]) ) {
                    menor = j;
                }
            }
            String temp = array[menor];
            array[menor] = array[i];
            array[i] = temp;
        }
        return array;
    }

    // Ler

    public void ler ( String id_target, List disneyplus ) {
        try {
            File ptr = new File("../../tmp/disneyplus.csv"); 
            Scanner o = new Scanner(ptr);
            String s = "";
            String id_busca = "";
            boolean encontrou = false;
            s = o.nextLine();
            while( s.compareTo("FIM") != 0 && !encontrou) {
                id_busca = s.split(",")[0];
                if (id_busca.compareTo(id_target) == 0) {
                    encontrou = true;
                } else {
                    s = o.nextLine();
                }
            }

            String[] full_string;
            full_string = stringtok(s);
            int index = 0;

            id = full_string[index++];

            if ( full_string[index] == "" ) {
                set_type("NaN");
                index++;
            } else {
                set_type(full_string[index++]);
            }

            boolean has_virgula = false;
            boolean has_quotation = false;
            if ( full_string[index].charAt(0) == '"' ) {
                for ( int y = 1; y < full_string[index].length() && ( !has_virgula || !has_quotation); y++ ) {
                    if ( y != full_string[index].length()-1 && full_string[index].charAt(y) == '"' ) {
                        has_quotation = true;
                    } 
                    if ( !has_virgula && full_string[index].charAt(full_string[index].length()-1) != '"' ) {
                        has_virgula = true;
                    }
                }
            }
            if ( full_string[index] == "" ) {
                set_title("NaN");
                index++;
            } else if ( has_virgula && ! has_quotation ) {
                String title_analysis = s.split("\"")[1];
                String title_put = trimmers(title_analysis);
                set_title(title_put);
                int virgula_count = 0;
                for ( int y = 0; y < title_analysis.length(); y++ ) {
                    if ( title_analysis.charAt(y) == ',' ) {
                        virgula_count++;
                    }
                }
                index += virgula_count+1;
            } else {
                set_title(trimmers(full_string[index++]));
            }

            String[] array_director = new String[80];
            if ( full_string[index] != "" && full_string[index].charAt(0) == '"' ) {
                int count = 0;
                while ( full_string[index].charAt(full_string[index].length()-1) != '"' ) {
                    array_director[count++] = trimmers(full_string[index++]);
                }
                array_director[count++] = trimmers(full_string[index++]);
            } else if ( full_string[index] == "" ) {
                array_director[0] = "NaN";
                index++;
            } else {
                array_director[0] = trimmers(full_string[index++]); 
            }
            set_director(array_director);
            
            String[] array_cast = new String[80];
            if ( full_string[index] != "" && full_string[index].charAt(0) == '"' ) {
                int count = 0;
                while ( full_string[index].charAt(full_string[index].length()-1) != '"' ) {
                    array_cast[count++] = trimmers(full_string[index++]);
                }
                array_cast[count++] = trimmers(full_string[index++]);
            } else if ( full_string[index] == "" ) {
                array_cast[0] = "NaN";
                index++;
            } else {
                array_cast[0] = trimmers(full_string[index++]);
            }
            array_cast = sort_array_string(array_cast);
            set_cast(array_cast);
            

            String[] array_country = new String[80];
            if ( full_string[index] != "" && full_string[index].charAt(0) == '"' ) {
                int count = 0;
                while ( full_string[index].charAt(full_string[index].length()-1) != '"' ) {
                    array_country[count++] = trimmers(full_string[index++]);
                }
                array_country[count++] = trimmers(full_string[index++]);
            } else if ( full_string[index] == "" ) {
                array_country[0] = "NaN";
                index++;
            } else {
                array_country[0] = trimmers(full_string[index++]);
            }
            set_country(array_country);

            String date_string = "";
            String[] date_itself = new String[3];
            int day = 0;
            int month = 0;
            int year = 0;
            Data date_template = new Data();
            if ( full_string[index] == "" ) {
                set_date_added(date_template);
                index++;
            } else {
                date_string = full_string[index].concat(full_string[index+1]);
                date_itself = date_string.split(" ");
                date_itself[0] = trimmers(date_itself[0]);
                date_itself[2] = trimmers(date_itself[2]);

                year = Integer.parseInt(date_itself[2]);
                month = find_date(date_itself[0], true);
                day = find_date(date_itself[1], false);
                date_template = new Data(day, month, year, false);
                set_date_added(date_template);
                index += 2;
            }

            if ( full_string[index] == "" ) {
                set_release_year(-1);
                index++;
            } else {
                set_release_year(Integer.parseInt(full_string[index++]));
            }

            if ( full_string[index] == "" ) {
                set_rating("NaN");
                index++;
            } else {
                set_rating(full_string[index++]);
            }

            if ( full_string[index] == "" ) {
                set_duration("NaN");
                index++;
            } else {
                set_duration(full_string[index++]);
            }

            String[] array_listed_in = new String[80];
            if ( full_string[index] != "" && full_string[index].charAt(0) == '"' ) {
                int count = 0;
                while ( full_string[index].charAt(full_string[index].length()-1) != '"' ) {
                    array_listed_in[count++] = trimmers(full_string[index++]);
                }
                array_listed_in[count++] = trimmers(full_string[index++]);
            } else if ( full_string[index] == "" ) {
                array_listed_in[0] = "NaN";
                index++;
            } else {
                array_listed_in[0] = trimmers(full_string[index++]);
            }
            listed_in = sort_array_string(array_listed_in);
            set_listed_in(array_listed_in);

            /*if ( full_string[index] == "" ) {
                set_description("NaN");
            } else {
                set_description(full_string[index]);
            } */

            disneyplus.insertLast(this);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void print () {
        System.out.print("=> "+get_id()+" ## "+get_title()+" ## "+get_type()+" ## ");
        for ( int y = 0; y < get_director().length && get_director()[y] != null; y++ ) {
            if ( y+1 != get_director().length && get_director()[y+1] != null ) { System.out.print(get_director()[y]+", "); }
            else { System.out.print(get_director()[y]+" ## ["); }
        }
        for ( int y = 0; y < get_cast().length && get_cast()[y] != null; y++ ) {
            if ( y+1 != get_cast().length && get_cast()[y+1] != null ) { System.out.print(get_cast()[y]+", "); }
            else { System.out.print(get_cast()[y]+"] ## "); }
        }
        for ( int y = 0; y < get_country().length && get_country()[y] != null; y++ ) {
            if ( y+1 != get_country().length && get_country()[y+1] != null ) { System.out.print(get_country()[y]+", "); }
            else { System.out.print(get_country()[y]+" ## "); }
        }
        if ( date_added.get_is_null() ) { System.out.print("NaN"); } else { System.out.print(dtos(get_date_added().get_month())+" "+get_date_added().get_day()+", "+get_date_added().get_year()); }
        if ( release_year == -1 ) { System.out.print(" ## NaN ## "); } else { System.out.print(" ## "+get_release_year()+" ## "); }
        System.out.print(get_rating()+" ## "+get_duration()+" ## [");
        for ( int y = 0; y < get_listed_in().length && get_listed_in()[y] != null; y++ ) {
            if ( y+1 != get_listed_in().length && get_listed_in()[y+1] != null ) { System.out.print(get_listed_in()[y]+", "); }
            else { System.out.print(get_listed_in()[y]+"] ##"); }
        }
        //System.out.print(get_description());
        System.out.println();
        
    }

    public static void main ( String args[] ) {
        try {
            File ptr = new File("pub.in");
            Scanner o = new Scanner(ptr);
            String s = "";
            s = o.nextLine();
            List disneyplus = new List();
            while( s.compareTo("FIM") != 0 ) {
                Show objeto = new Show();
                objeto.ler(s,disneyplus);
                objeto.print();
                s = o.nextLine();
            }


        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}