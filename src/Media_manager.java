import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Runtime.getRuntime;


/**
 * Created by Soul on 20.04.2017.
 */
public class Media_manager {
    static String medianame;
    static List<Media_Item> mainList = new ArrayList<Media_Item>();



    public static void main(String[] args) throws IOException{
//        mainList.add(new Book("Harry Potter 1" , "WANT READ"));
//        mainList.add(new Book("Harry Potter 2" , "READING"));
//        mainList.add(new Book("Harry Potter 2" , "ALREADY READ"));
//        mainList.add(new Film("RoboCop 1", "WANT WATCH"));
//        mainList.add(new Film("RoboCop 2", "WATCHING"));
//        mainList.add(new Film("RoboCop 3", "ALREADY WATCH"));
//        mainList.add(new Music("50 Cent 1", "WANT LISTEN"));
//        mainList.add(new Music("50 Cent 2", "LISTENING"));
//        mainList.add(new Music("50 Cent 3", "ALREADY LISTEN"));
//
//        mainList.add(new Book("Harry Potter 1" , "WANT READ"));
//        mainList.add(new Book("Harry Potter 2" , "READING"));
//        mainList.add(new Book("Harry Potter 2" , "ALREADY READ"));
//        mainList.add(new Film("RoboCop 1", "WANT WATCH"));
//        mainList.add(new Film("RoboCop 2", "WATCHING"));
//        mainList.add(new Film("RoboCop 3", "ALREADY WATCH"));
//        mainList.add(new Music("50 Cent 1", "WANT LISTEN"));
//        mainList.add(new Music("50 Cent 2", "LISTENING"));
//        mainList.add(new Music("50 Cent 3", "ALREADY LISTEN"));

        screen0();


    }
    public static void clearScreen() {for ( int i = 0; i < 25; ++i )
    {System.out.println();}}

    public static void screen0() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Media Manager v 1.0");
        System.out.println("Please, make a choice (input 1 - 4. For EXIT press 0)");
        System.out.println(" ");
        System.out.println("1. Внести в список книгу/музыку/фильм");
        System.out.println("2. Изменить статус для книги/музыки/фильма");
        System.out.println("3. Вывести список книг/музыки/фильма фильтрованный и не фильтрованный по статусу");
        System.out.println("4. Удалить книгу/музыку фильм");
        int i = Integer.parseInt(reader.readLine());

        if (i == 0) { /* add EXIT */}
        else if ( i == 1) { clearScreen(); screen1();}
        else if ( i == 2) { clearScreen(); screen2();}
        else if ( i == 3) { clearScreen(); screen3();}
        else if ( i == 4) { clearScreen(); screen4();}


    }
    public static void screen1() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("vvedite nazvanie mediakontenta.");
        medianame = reader.readLine();
        System.out.println("Viberite tip " + "* " + medianame + " *");
        System.out.println("Nazhmi 0 dlya vozvrata v glavnoe menu");
        System.out.println(" ");
        System.out.println("1. Book");
        System.out.println("2. Film");
        System.out.println("3. Music");
        int w = Integer.parseInt(reader.readLine());
        if (w == 1) { mainList.add(new Book(medianame));
            System.out.println("Kniga " + medianame + " dobavlena v media galereu");
        screen1();}
        else if (w == 2) { mainList.add(new Film(medianame));
            System.out.println("Film " + medianame + " dobavlena v media galereu");
            screen1();}
        else if (w == 3) { mainList.add(new Music(medianame));
            System.out.println("Muzika "  + medianame + " dobavlena v media galereu");
            screen1();}
        else if (w == 0) {clearScreen(); screen0();}

    }
    public static void screen2() throws IOException {
        Map<Integer, Integer> sameNames = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("vvedite nazvanie mediakontenta.");
        medianame = reader.readLine();

        System.out.println("Dobavit status k:  (Press 1 - 9)");
        System.out.println();
        Integer count = 1;
        for (int i = 0; i < mainList.size(); i++) {
            if (medianame.equals(mainList.get(i).toString())) {
                sameNames.put(count, i);
                System.out.println(count + " " + mainList.get(i) + " - " + typeCheck(mainList.get(i)));
                count++;
            }
            else {
                clearScreen();
                System.out.println("Error! V galeree net media s takim nazvaniem");
                screen2();
            }
        }
        count = Integer.parseInt(reader.readLine());

        setStatusMedia(mainList.get(sameNames.get(count)));

        if (typeCheck(mainList.get(sameNames.get(count))).equals("Book")) {
            mainList.get(sameNames.get(count)).setStatus(statusBook(Integer.parseInt(reader.readLine())));}

        else if (typeCheck(mainList.get(sameNames.get(count))).equals("Film")) {
            mainList.get(sameNames.get(count)).setStatus(statusFilm(Integer.parseInt(reader.readLine())));}

        else if (typeCheck(mainList.get(sameNames.get(count))).equals("Music")) {
            mainList.get(sameNames.get(count)).setStatus(statusMusic(Integer.parseInt(reader.readLine())));}

        System.out.println("Kontent: " + mainList.get(sameNames.get(count)).getName() + " New status: " + mainList.get(sameNames.get(count)).getStatus());
        screen2();

    }

    public static void screen3() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Media_Item> tempList = new ArrayList<Media_Item>();
        int count = 0;
        System.out.println("Viberite kakoy vi hotite vivesti spisok? (1 - 9)");
        System.out.println();
        System.out.println("1 - Spisok Knig");
        System.out.println("2 - Spisok Filmov");
        System.out.println("3 - Spisok Muziki");
        System.out.println("4 - Vsya mediateka");
        count = Integer.parseInt(reader.readLine());
        if (count == 1) {
            System.out.println("Knigi: ");
            for (int i = 0; i < mainList.size(); i++) {
                if (mainList.get(i) instanceof Book) {
                    tempList.add(mainList.get(i));
                    System.out.println(mainList.get(i).getName() + " Status: " + mainList.get(i).getStatus());
                }
            }
        }
        else if (count == 2) {
            System.out.println("Filmi: ");
            for (int i = 0; i < mainList.size(); i++) {
                if (mainList.get(i) instanceof Film) {
                    tempList.add(mainList.get(i));
                    System.out.println(mainList.get(i).getName() + " Status: " + mainList.get(i).getStatus());
                }
            }
        }
        else if (count == 3) {
            System.out.println("Muzika: ");
            for (int i = 0; i < mainList.size(); i++) {
                if (mainList.get(i) instanceof Music) {
                    tempList.add(mainList.get(i));
                    System.out.println(mainList.get(i).getName() + " Status: " + mainList.get(i).getStatus());
                }
            }
        }
        else if (count == 4) {
            System.out.println("Vsya mediateka: ");
            for (int i = 0; i < mainList.size(); i++) {
                    System.out.println(mainList.get(i).getName() + " Status: " + mainList.get(i).getStatus());
                    tempList = mainList;
                }
        }
        System.out.println("Otsortirovat po statusy ???");
        System.out.println();
        System.out.println("1 - Da");
        System.out.println("2 - Net");

        count = Integer.parseInt(reader.readLine());
        if (count == 1) {
            for (int i = 0; i < sortByStatus(tempList).size(); i++) {
                System.out.println(sortByStatus(tempList).get(i).getName()  + " Status: " + sortByStatus(tempList).get(i).getStatus() );
            }

        }
        else if (count == 2) {screen3();}



    }
    public static void screen4() throws IOException
    {
        Map<Integer, Integer> sameNames = new HashMap<Integer, Integer>();
        int count = 1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Vvedite nazvanie kontenta dlya ydalenia: (0 - glavnoe menu)");
        medianame = reader.readLine();
        if (medianame.equals("0")) {clearScreen(); screen0();}
        else
          System.out.println("Viberite odin iz vozmognih variantov (1 - 9)");
        System.out.println();


        for (int i = 0; i < mainList.size(); i++) {
            if (medianame.equals(mainList.get(i).getName())) {
                sameNames.put(count, i);
                System.out.println(count + " " + mainList.get(i).toString() + " - " + typeCheck(mainList.get(i)));
                count++;
            }
//            else {
//                clearScreen();
//                System.out.println("Error! V galeree net media s takim nazvaniem");
//                screen4();
//            }
        }
        count = Integer.parseInt(reader.readLine());
        int s = sameNames.get(count);
        mainList.remove(s);

        clearScreen();
        System.out.println("Media udaleno");
        screen4();


    }

    public  static String typeCheck(Media_Item obj) {
        String res = "";
        if (obj instanceof Book) {res = "Book";}
        else if (obj instanceof Film) {res = "Film";}
        else if (obj instanceof Music) {res = "Music";}
        return res;
    }
    public static void setStatusMedia(Media_Item obj) {
        if (obj instanceof Book) {
            System.out.println("Viberite status dlya KNIGI");
            System.out.println();
            System.out.println("1 - WANT READ");
            System.out.println("2 - READING");
            System.out.println("3 - ALREADY READ");
        }
        else if (obj instanceof Film) {
            System.out.println("Viberite status dlya FILMA");
            System.out.println();
            System.out.println("1 - WANT WATCH");
            System.out.println("2 - WATCHING");
            System.out.println("3 - ALREADY WATCH");
        }
        else if (obj instanceof Music) {
            System.out.println("Viberite status dlya MUZIKI");
            System.out.println();
            System.out.println("1 - WANT LISTEN");
            System.out.println("2 - LISTENING");
            System.out.println("3 - ALREADY LISTEN");
        }
    }
    public static String statusBook (int choose){
        String res = "";
        if (choose == 1){res = "WANT READ";}
        else if (choose == 2){res = "READING";}
        else if (choose == 3) { res = "ALREADY READ";}
        return res;
    }
    public static String statusFilm (int choose){
        String res = "";
        if (choose == 1){res = "WANT WATCH";}
        else if (choose == 2){res = "WATCHING";}
        else if (choose == 3) { res = "ALREADY WATCH";}
        return res;
    }
    public static String statusMusic (int choose){
        String res = "";
        if (choose == 1){res = "WANT LISTEN";}
        else if (choose == 2){res = "LISTENING";}
        else if (choose == 3) { res = "ALREADY LISTEN";}
        return res;
    }

    public static List<Media_Item> sortByStatus (List<Media_Item> item)
    {
        List<Media_Item> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        Set<String> map = new HashSet<>();
        for (int i = 0; i < item.size(); i++) {
            map.add(item.get(i).getStatus());
        }
        for (int i = 0; i < item.size(); i++) {
            if (map.contains(item.get(i).getStatus())) {
                tmp.add(item.get(i).getStatus());
                map.remove(item.get(i).getStatus());
            }
        }
        for (int j = 0; j < tmp.size(); j++) {
            for (int i = 0; i < item.size(); i++) {
                if (item.get(i).getStatus().equals(tmp.get(j)))
                {res.add(item.get(i));}
            }
        }
        return res;
    }

}
