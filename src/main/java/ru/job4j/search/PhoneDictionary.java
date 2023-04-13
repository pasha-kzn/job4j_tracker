package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person p : persons) {
            if (p.getName().contains(key) || p.getSurname().contains(key)
                    || p.getPhone().contains(key) || p.getAddress().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }
}