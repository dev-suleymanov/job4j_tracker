package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0.0, size = 0.0;
        for (Pupil el : pupils) {
            result += scoreByIndividualPupil(el);
            size += el.subjects().size();
        }
        return result / size;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil el : pupils) {
            result.add(new Label(el.name(), scoreByIndividualPupil(el) / el.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil el : pupils) {
            for (Subject ell : el.subjects()) {
                map.put(ell.name(), map.getOrDefault(ell.name(), 0) + ell.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil el : pupils) {
            labels.add(new Label(el.name(), scoreByIndividualPupil(el)));
        }
        Collections.sort(labels, Comparator.naturalOrder());
        return labels.size() == 0 ? null : labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil el : pupils) {
            for (Subject ell : el.subjects()) {
                map.put(ell.name(), map.getOrDefault(ell.name(), 0) + ell.score());
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue()));
        }
        Collections.sort(labels, Comparator.naturalOrder());
        return labels.size() == 0 ? null : labels.get(labels.size() - 1);
    }

    public static double scoreByIndividualPupil(Pupil pupil) {
        double result = 0.0;
        for (Subject el : pupil.subjects()) {
            result += el.score();
        }
        return result;
    }
}