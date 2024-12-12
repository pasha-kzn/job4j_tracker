package ru.job4j.stream;

import java.util.*;
import java.util.stream.*;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects()
                        .stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0D)))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        Map<String, Double> subjectsScores = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.averagingDouble(Subject::score)));
        return subjectsScores.entrySet().stream()
                .map(ss -> new Tuple(ss.getKey(), ss.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> subjectsScores = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.summingDouble(Subject::score)));
        return subjectsScores.entrySet().stream()
                .map(ss -> new Tuple(ss.getKey(), ss.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }
}