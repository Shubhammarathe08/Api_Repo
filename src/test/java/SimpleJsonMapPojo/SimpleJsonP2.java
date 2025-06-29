package SimpleJsonMapPojo;

import java.util.ArrayList;
import java.util.List;

public class SimpleJsonP2 {

    private String first_name;
    private boolean is_alive;
    //private SimpleJsonAddr addresses;
    private List<SimpleJsonAddr> addresses = new ArrayList<>();

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public boolean isIs_alive() {
        return is_alive;
    }

    public void setIs_alive(boolean is_alive) {
        this.is_alive = is_alive;
    }

    public List<SimpleJsonAddr> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<SimpleJsonAddr> addresses) {
        this.addresses = addresses;
    }
}
