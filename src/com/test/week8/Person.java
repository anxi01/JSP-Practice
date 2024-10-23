package com.test.week8;

public class Person {

    private String name;
    private String id;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        int age = Integer.parseInt(this.age);
        if (age >= 20) {
            return "성인입니다.";
        }
        return "성인이 아닙니다.";
    }

    public void setAge(String age) {
        this.age = age;
    }
}
