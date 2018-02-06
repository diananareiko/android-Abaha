package com.example.asus.abaha42;

/**
 * Created by ASUS on 17.01.2018.
 */

public class ListItem {
    private String head;
    private String price;
    private String desc;
    private String date;
    private String town;
    private String imageUrl;

    public ListItem(String imageUrl, String head, String price, String desc, String date, String town) {
        this.imageUrl=imageUrl;
        this.head = head;
        this.price=price;
        this.desc=desc;
        this.date=date;
        this.town=town;

    }

    public String getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getTown() {
        return town;
    }
    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
