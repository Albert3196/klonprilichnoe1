package moc.vonidnikA.neutralesprojekt.Model;

import java.util.ArrayList;

public class Data {
    private static Data data = null;

    public static Data getInstance() {
        if(data == null) {
            data = new Data();
        }
        return data;
    }

    private Data() {
        initData();
    }

    ArrayList<Cookie> cookies = new ArrayList<Cookie>();
    ArrayList<Order> orders = new ArrayList<Order>();

    //получить печеньки
    public ArrayList<Cookie> getCookies() {
        return cookies;
    }

    //получить печеньку по ее id
    public Cookie getCookieById(long id) {
        for (Cookie cookie : cookies){
            if (cookie.getId() == id){
                return cookie;
            }
        }
        return null;
    }

    //установить заказ
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    //получить заказ прользователя
    public  Order getOrderByLogin(String login) {
        for (Order or : orders) {
            if (or.getLogin() == login) {
                return or;
            }
        }
        return new Order();
    }

    public void initData() {

        cookies.add(new Cookie(1,"Черепашка","img/1.png",50));
        cookies.add(new Cookie(2,"Шахматы","img/2.png",25));
        cookies.add(new Cookie(3,"Джем","img/3.png",15));
        cookies.add(new Cookie(4,"Чокопай","img/4.png",25));
    }

}
