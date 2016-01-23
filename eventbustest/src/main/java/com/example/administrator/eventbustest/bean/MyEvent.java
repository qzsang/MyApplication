package com.example.administrator.eventbustest.bean;

/**
 * Created by Administrator on 2016/1/23.
 */
public class MyEvent {
    public Integer id;
    public String code;
    public String msg;

    @Override
    public String toString() {
        return "MyEvent{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
