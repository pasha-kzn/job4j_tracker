package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new Exit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "Edited Item name", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ReplaceAction(),
                new Exit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Edited Item name");
    }

    @Test
    public void whenDeleteItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new DeleteAction(),
                new Exit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(1)).isNull();
    }
}