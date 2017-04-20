import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Runtime.getRuntime;


/**
 * Created by Soul on 20.04.2017.
 */
public class Media_manager {
    private static String medianame;
    private static List<Media_Item> mainList = new ArrayList<Media_Item>();



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
    private static void clearScreen() {for ( int i = 0; i < 25; ++i )
    {System.out.println();}} // Метод очищает окно консоли

    // Главное меню программы
    private static void screen0() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Soul's Media Manager v 1.0");
        System.out.println("Пожалуйста, сделайте выбор: Введите на клавиатуре 1 - 9 (Для выхода введите 0)");
        System.out.println("                            Подтвердите свой выбор нажатием Enter");
        System.out.println();
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

    // Секция программы реализующая:
    // Внести в список книгу/музыку/фильм
    private static void screen1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Наберите название контента и нажмите Enter");
        System.out.println("*** Для возврата в главное меню наберите 0 ***");
        medianame = reader.readLine();
        if (medianame.equals("0")) {clearScreen(); screen0();}
        System.out.println("Выберите тип контента для * " + medianame + " * Введите на клавиатуре 1 - 9");
        System.out.println("*** Для возврата в главное меню наберите 0 ***");
        System.out.println("Подтвердите свой выбор нажатием Enter");
        System.out.println(" ");
        System.out.println("1. Book");
        System.out.println("2. Film");
        System.out.println("3. Music");
        int w = Integer.parseInt(reader.readLine());
        if (w == 1) { mainList.add(new Book(medianame));
            System.out.println("Книга * " + medianame + " * добавлена в медиа галлерею");
        screen1();}
        else if (w == 2) { mainList.add(new Film(medianame));
            System.out.println("Фильм * " + medianame + " * добавлен в медиа галлерею");
            screen1();}
        else if (w == 3) { mainList.add(new Music(medianame));
            System.out.println("Музыка * "  + medianame + " * добавлена в медиа галлерею");
            screen1();}
        else if (w == 0) {clearScreen(); screen0();}

    }

    // Секция программы реализующая:
    // Изменить статус для книги/музыки/фильма
    private static void screen2() throws IOException {
        Map<Integer, Integer> sameNames = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Наберите название медиаконтента для изменения статуса:");
        System.out.println("*** Для возврата в главное меню наберите 0 ***");
        System.out.println("Подтвердите свой выбор нажатием Enter");
        medianame = reader.readLine();
        if (medianame.equals("0")) {clearScreen(); screen0();}

        System.out.println();
        System.out.println("Выберите в каком именно медиа контенте изменить статус:");
        System.out.println("Введите на клавиатуре 1 - 9");
        System.out.println("*** Для возврата в главное меню наберите 0 ***");
        System.out.println("Подтвердите свой выбор нажатием Enter");
        System.out.println();
        Integer count = 1;
        for (int i = 0; i < mainList.size(); i++) {
            if (medianame.equals(mainList.get(i).toString())) {
                sameNames.put(count, i);
                System.out.println(count + " " + mainList.get(i) + " - " + typeCheck(mainList.get(i)));
                count++;
            }
//            else {
//                clearScreen();
//                System.out.println("Ошибка! В галлерее нет контента с названием * " + medianame + " *");
//                System.out.println();
//                screen2();
//            }
        }
        count = Integer.parseInt(reader.readLine());

        setStatusMedia(mainList.get(sameNames.get(count)));

        if (typeCheck(mainList.get(sameNames.get(count))).equals("Book")) {
            mainList.get(sameNames.get(count)).setStatus(statusBook(Integer.parseInt(reader.readLine())));}

        else if (typeCheck(mainList.get(sameNames.get(count))).equals("Film")) {
            mainList.get(sameNames.get(count)).setStatus(statusFilm(Integer.parseInt(reader.readLine())));}

        else if (typeCheck(mainList.get(sameNames.get(count))).equals("Music")) {
            mainList.get(sameNames.get(count)).setStatus(statusMusic(Integer.parseInt(reader.readLine())));}

        System.out.println("В медиа контенте * " + mainList.get(sameNames.get(count)).getName() + " * новый статус: " + mainList.get(sameNames.get(count)).getStatus());
        System.out.println();
        screen2();

    }

    // Секция программы реализующая:
    // Вывести список книг/музыки/фильма фильтрованный и не фильтрованный по статусу
    private static void screen3() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Media_Item> tempList = new ArrayList<Media_Item>();
        int count = 0;
        System.out.println("Какой тип контента вы хотите вывести на экран?");
        System.out.println("Сделайте выбор (1 - 9) и подтвердите нажатием Enter");
        System.out.println("*** Для возврата в главное меню наберите 0 ***");
        System.out.println();
        System.out.println("1. Список книг");
        System.out.println("2. Список фильмов");
        System.out.println("3. Список музыки");
        System.out.println("4. Список всей медиатеки");
        count = Integer.parseInt(reader.readLine());
        if (count == 1) {
            System.out.println("Список книг: ");
            for (int i = 0; i < mainList.size(); i++) {
                if (mainList.get(i) instanceof Book) {
                    tempList.add(mainList.get(i));
                    System.out.println("* " + mainList.get(i).getName() + " * статус: " + mainList.get(i).getStatus());
                }
            }
        }
        else if (count == 2) {
            System.out.println("Список фильмов: ");
            for (int i = 0; i < mainList.size(); i++) {
                if (mainList.get(i) instanceof Film) {
                    tempList.add(mainList.get(i));
                    System.out.println("* " + mainList.get(i).getName() + " * статус: " + mainList.get(i).getStatus());
                }
            }
        }
        else if (count == 3) {
            System.out.println("Список музыки: ");
            for (int i = 0; i < mainList.size(); i++) {
                if (mainList.get(i) instanceof Music) {
                    tempList.add(mainList.get(i));
                    System.out.println("* " + mainList.get(i).getName() + " * статус: " + mainList.get(i).getStatus());
                }
            }
        }
        else if (count == 4) {
            System.out.println("Список всей медиатеки: ");
            for (int i = 0; i < mainList.size(); i++) {
                    System.out.println(typeCheck(mainList.get(i)) + " * " + mainList.get(i).getName() + " * статус: " + mainList.get(i).getStatus());
                    tempList = mainList;
                }
        }
        else if (count == 0) {clearScreen(); screen0();}
        System.out.println();
        System.out.println("Отсортировать список по статусу?");
        System.out.println();
        System.out.println("1 - Да");
        System.out.println("2 - Нет");

        count = Integer.parseInt(reader.readLine());
        if (count == 1) {
            for (int i = 0; i < sortByStatus(tempList).size(); i++) {
                System.out.println(typeCheck(tempList.get(i)) + " * " + sortByStatus(tempList).get(i).getName()  + " * статус: " + sortByStatus(tempList).get(i).getStatus() );
            }

        }
        else if (count == 2) {screen3();}



    }

    // Секция программы реализующая:
    // Удалить книгу/музыку фильм
    private static void screen4() throws IOException {
        Map<Integer, Integer> sameNames = new HashMap<Integer, Integer>();
        int count = 1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Наберите название контента для удаления из галлереи и нажмите Enter");
        System.out.println("*** Для возврата в главное меню наберите 0 ***");
        medianame = reader.readLine();
        if (medianame.equals("0")) {clearScreen(); screen0();}
        else
          System.out.println("Выберите один из возможных вариантов: (1 - 9)");
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

        System.out.println("Выбранный медиа контент удален!");
        System.out.println();
        screen4();


    }

    private static String typeCheck(Media_Item obj) {
        String res = "";
        if (obj instanceof Book) {res = "Book";}
        else if (obj instanceof Film) {res = "Film";}
        else if (obj instanceof Music) {res = "Music";}
        return res;
    } // Возвращаетс строку с типом медиа контента
    private static void setStatusMedia(Media_Item obj) {
        if (obj instanceof Book) {
            System.out.println("Выберите новый статус для книги:");
            System.out.println();
            System.out.println("1. WANT READ");
            System.out.println("2. READING");
            System.out.println("3. ALREADY READ");
        }
        else if (obj instanceof Film) {
            System.out.println("Выберите новый статус для фильма");
            System.out.println();
            System.out.println("1. WANT WATCH");
            System.out.println("2. WATCHING");
            System.out.println("3. ALREADY WATCH");
        }
        else if (obj instanceof Music) {
            System.out.println("Выберите новый статус для музыки");
            System.out.println();
            System.out.println("1. WANT LISTEN");
            System.out.println("2. LISTENING");
            System.out.println("3. ALREADY LISTEN");
        }
    } // Предоставляет визуализацию для выбора статуса
    private static String statusBook (int choose){
        String res = "";
        if (choose == 1){res = "WANT READ";}
        else if (choose == 2){res = "READING";}
        else if (choose == 3) { res = "ALREADY READ";}
        return res;
    } // Возвращает статус для класса Book
    private static String statusFilm (int choose){
        String res = "";
        if (choose == 1){res = "WANT WATCH";}
        else if (choose == 2){res = "WATCHING";}
        else if (choose == 3) { res = "ALREADY WATCH";}
        return res;
    } // Возвращает статус для класса Film
    private static String statusMusic (int choose){
        String res = "";
        if (choose == 1){res = "WANT LISTEN";}
        else if (choose == 2){res = "LISTENING";}
        else if (choose == 3) { res = "ALREADY LISTEN";}
        return res;
    } // Возвращает статус для класса Music
    private static List<Media_Item> sortByStatus (List<Media_Item> item) {
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
    } // Метод сортирует по статусу

}
