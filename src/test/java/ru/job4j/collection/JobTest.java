package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenSortingNameByAscending() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Psychologist"));
        jobs.add(new Job("Builder"));
        jobs.add(new Job("Programmer"));
        List<Job> expected = List.of(
                new Job("Builder"),
                new Job("Programmer"),
                new Job("Psychologist")
        );
        jobs.sort(new JobAskByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenSortingNameByDecreasing() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Psychologist"));
        jobs.add(new Job("Builder"));
        jobs.add(new Job("Programmer"));
        List<Job> expected = List.of(
                new Job("Psychologist"),
                new Job("Programmer"),
                new Job("Builder")
        );
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenSortingPriorityByAscending() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Psychologist", 6));
        jobs.add(new Job("Builder", 2));
        jobs.add(new Job("Programmer", 4));
        List<Job> expected = List.of(
                new Job("Builder", 2),
                new Job("Programmer", 4),
                new Job("Psychologist", 6)
        );
        jobs.sort(new JobAskByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenSortingPriorityByDecreasing() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Psychologist", 6));
        jobs.add(new Job("Builder", 2));
        jobs.add(new Job("Programmer", 4));
        List<Job> expected = List.of(
                new Job("Psychologist", 6),
                new Job("Programmer", 4),
                new Job("Builder", 2)
        );
        jobs.sort(new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenSortingNameAndPriorityByAscending() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isLessThan(0);
    }
}