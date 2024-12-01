package ru.job4j.search;

import java.util.*;
import java.util.function.*;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> compareName = s -> s.getName().contains(key);
        Predicate<Person> compareSurname = s -> s.getSurname().contains(key);
        Predicate<Person> comparePhone = s -> s.getPhone().contains(key);
        Predicate<Person> compareAddress = s -> s.getAddress().contains(key);
        var combine = compareName.or(compareSurname).or(comparePhone).or(compareAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}