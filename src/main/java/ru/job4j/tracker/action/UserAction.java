package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.*;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}