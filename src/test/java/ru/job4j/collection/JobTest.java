package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAcsByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Abc task", 2),
                new Job("Def task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Abc task", 2),
                new Job("Def task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorAcsByPriority() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(
                new Job("Abc task", 2),
                new Job("Def task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorDescByPriority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Abc task", 2),
                new Job("Def task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByPriorityAndName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpPriorityName.compare(
                new Job("Hard task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorAscByPriorityAndDescByName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("Hard task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByPriorityAndAscByName() {
        Comparator<Job> cmpPriorityName = new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = cmpPriorityName.compare(
                new Job("Hard task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}