package ru.job4j.map;

import java.util.*;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> student.account().equals(account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> student = findByAccount(account);
        if (student.isPresent()) {
            var subject =  students.get(student.get()
                    )
                    .stream()
                    .filter(s -> s.name().equals(name))
                    .findFirst();
            if (subject.isPresent()) {
                return subject;
            }
        }
        return Optional.empty();
    }
}