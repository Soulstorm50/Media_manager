/**
 * Created by Soul on 20.04.2017.
 */
public class Media_Item {
    private String name = "New Item";
    private String status = "WANT USE";

    Media_Item() {}

    Media_Item(String name, String status) {
        this.name = name;
        this.status = status;
    }
    Media_Item(String name) {
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
