package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"BlaBlaBla", "TraTaTa"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item created1 = tracker.findAll()[0];
        Item created2 = tracker.findAll()[1];
        Item expected1 = new Item("BlaBlaBla");
        Item expected2 = new Item("TraTaTa");
        assertThat(expected1.getName()).isEqualTo(created1.getName());
        assertThat(expected2.getName()).isEqualTo(created2.getName());
    }
}