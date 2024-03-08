package com.zaurtregulov.spring.rest.exceptionHandling;
//объект этого класса будет преобразовываться в json и выводиться на экран
public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData() {
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
