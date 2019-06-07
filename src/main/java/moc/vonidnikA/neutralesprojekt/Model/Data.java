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

    public void initData() {

        cookies.add(new Cookie(1,"Черепашка","img/1.png",50));
        cookies.add(new Cookie(2,"Шахматы","img/2.png",25));
        cookies.add(new Cookie(3,"Джем","img/3.png",15));
        cookies.add(new Cookie(4,"Чокопай","img/4.png",25));
    }

}
