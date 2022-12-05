package ru.job4j.pojo;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Suleymanov Rustam Ikramovich");
        student.setGroup("ISA-1");
        student.setCreated(new Date());
        System.out.println(student.getName());
        System.out.println(student.getGroup());
        System.out.println(student.getCreated());
    }
}
