package com.example.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author : lwz
 * date : 2022/10/26 17:03
 * desc :
 * version: 1.0
 */
@Entity
public class User {
    @Id
    private Long id;
    @NotNull
    private String name;
    private Integer age;
    private String address;
    private float money;
    @Transient
    private String sex;

    @Generated(hash = 1764598987)
    public User(Long id, @NotNull String name, Integer age, String address,
            float money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.money = money;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", money=" + money +
                ", sex='" + sex + '\'' +
                '}';
    }
}
