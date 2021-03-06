/**
 * Created by Soul on 20.04.2017.
 */

// Отнаследованный класс от Media_Item, реализует разновидность контента
public class Music extends Media_Item{
    private String name = "New Music";
    private String status = "WANT LISTEN";

    Music(String name, String status) {
        this.name = name;
        this.status = status;
    }
    Music(String name) {
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
