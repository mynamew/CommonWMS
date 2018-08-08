package com.jzk.httplibrary.rxbus;

import java.util.List;

/**
 * $dsc
 * author: timi
 * create at: 2018-08-07 15:43
 */
public class EventMsg<T> {
    private T event;

    private List<?> list;

    private String tag;

    public EventMsg(T event) {
        this.event = event;
    }

    public EventMsg(String tag, T event) {
        this.tag = tag;
        this.event = event;
    }

    public EventMsg(List<?> list) {
        this.list = list;
    }

    public EventMsg(String tag, List<?> list) {
        this.tag = tag;
        this.list = list;
    }

    public String getTag() {
        return tag;
    }

    public T getData() {
        return event;
    }

    public List<?> getList() {
        return list;
    }
}
