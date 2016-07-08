package com.rensq.dao;

import com.rensq.model.Book;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by toothbond on 16/7/7.
 */
public class BookDB {

    private static Map<String,Book> map = new LinkedHashMap<String, Book>();
    static {
        map.put("1", new Book("1","javaweb开发"));
        map.put("2", new Book("2","spring开发"));
        map.put("3", new Book("3","hibernate开发"));
        map.put("4", new Book("4","struts开发"));
        map.put("5", new Book("5","ajax开发"));
    }

    public static Map<String,Book> getAll(){
        return map;
    }
}
