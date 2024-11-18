package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        int score = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                count++;
                score += s.score();
            }
        }
        return (float) score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> scoreByPupils = new ArrayList<>();
        for (Pupil p : pupils) {
            int count = 0;
            int score = 0;
            for (Subject s : p.subjects()) {
                count++;
                score += s.score();
            }
            scoreByPupils.add(new Label(p.name(), (float) score / count));
        }
        return scoreByPupils;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> scoreBySubject = new ArrayList<>();
        Map<String, Integer> subjectScore = new LinkedHashMap<>();
        pupils.forEach(p -> {
            p.subjects().forEach(s -> subjectScore.merge(s.name(), s.score(), Integer::sum));
        });
        for (Map.Entry<String, Integer> m : subjectScore.entrySet()) {
            scoreBySubject.add(new Label(m.getKey(), (float) m.getValue() / pupils.size()));
        }
        return scoreBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> scoreByPupils = new ArrayList<>();
        for (Pupil p : pupils) {
            int score = 0;
            for (Subject s : p.subjects()) {
                score += s.score();
            }
            scoreByPupils.add(new Label(p.name(), score));
        }
        var bestStudent = scoreByPupils.get(0);
        for (int i = 1; i < scoreByPupils.size(); i++) {
            if (scoreByPupils.get(i).compareTo(bestStudent) > 0) {
                bestStudent = scoreByPupils.get(i);
            }
        }
        return bestStudent;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> scoreBySubject = new ArrayList<>();
        Map<String, Integer> subjectScore = new LinkedHashMap<>();
        pupils.forEach(p -> {
            p.subjects().forEach(s -> subjectScore.merge(s.name(), s.score(), Integer::sum));
        });
        for (Map.Entry<String, Integer> m : subjectScore.entrySet()) {
            scoreBySubject.add(new Label(m.getKey(), m.getValue()));
        }
        Collections.sort(scoreBySubject, Label::compareTo);
        return scoreBySubject.get(scoreBySubject.size() - 1);
    }
}