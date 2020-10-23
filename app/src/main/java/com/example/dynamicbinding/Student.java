package com.example.dynamicbinding;

public class Student {
    public String ID;
    public String Name;
    public String grade;
    public String mark;
    public int Avatar;

    public Student(String id, String name, String grade, String mark, int avatar) {
        ID=id;
        Name=name;
        this.mark=mark;
        this.grade=grade;
        this.Avatar=avatar;
    }

    public void setAvatar(int avatar) {
        Avatar = avatar;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName() {
        return Name;
    }

    public String getGrade() {
        return grade;
    }

    public String getMark() {
        return mark;
    }

    public String getID() {
        return ID;
    }

    public int getAvatar() {
        return Avatar;
    }
}
