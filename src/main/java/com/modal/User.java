package com.modal;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BIG-JIAN on 2017/7/15.
 */
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String password;
    private String salt;
    private String headUrl;

    public User() {

    }
    public User(String name) {
        this.name = name;
        this.password = "";
        this.salt = "";
        this.headUrl = "";
    }
}
