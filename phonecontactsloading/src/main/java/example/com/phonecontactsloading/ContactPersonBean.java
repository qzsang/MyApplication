package example.com.phonecontactsloading;

import android.graphics.Bitmap;

/**
 * Created by qzsang on 2016/5/11.
 * 联系人类
 */

public class ContactPersonBean {
    String name;    //姓名
    String number; //电话
    Bitmap head;    //头像

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Bitmap getHead() {
        return head;
    }

    public void setHead(Bitmap head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "ContactPersonBean{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", head=" + head +
                '}';
    }
}
