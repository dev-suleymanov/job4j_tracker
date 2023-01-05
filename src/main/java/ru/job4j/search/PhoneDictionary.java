package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person el : persons) {
            if (el.getName().contains(key) || el.getSurname().contains(key)
                    || el.getPhone().contains(key) || el.getAddress().contains(key)) {
                result.add(el);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Oleg");
        for (Person el : persons) {
            System.out.println(el.getName());
        }
    }
}