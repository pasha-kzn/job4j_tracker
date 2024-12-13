package ru.job4j.my;

import ru.job4j.collection.Job;
import ru.job4j.collection.JobAscByName;
import ru.job4j.collection.JobDescByName;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 3)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        Collections.sort(jobs, new JobAscByName());
        System.out.println(jobs);
        jobs.sort(new JobDescByName());
        System.out.println(jobs);
    }
}
