/**
 * Created by Soul on 20.04.2017.
 */

// Отнаследованный класс от Media_Item, реализует разновидность контента
public class Book extends Media_Item{
    private String name = "New Book";
    private String status = "WANT READ";

    Book(String name, String status) {
        this.name = name;
        this.status = status;
    }
    Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return getName();
    }
}
