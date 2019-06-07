package moc.vonidnikA.neutralesprojekt.Model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String login = "test";
    private List<Long> cookies = new ArrayList<Long>();

    public Order() {
    }

    public Order(String login, List<Long> cookies) {
        this.login = login;
        this.cookies = cookies;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Long> getCookies() {
        return cookies;
    }

    public void setCookies(List<Long> cookies) {
        this.cookies = cookies;
    }
}
