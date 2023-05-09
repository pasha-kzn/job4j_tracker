package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemSortTest {
    @Test
    public void whenSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item(3, "bItem"),
                new Item(4, "aItem"),
                new Item(1, "dItem"),
                new Item(2, "cItem")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(4, "aItem"),
                new Item(3, "bItem"),
                new Item(2, "cItem"),
                new Item(1, "dItem")
        );
        assertThat(expected).isEqualTo(items);
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item(3, "bItem"),
                new Item(4, "aItem"),
                new Item(1, "dItem"),
                new Item(2, "cItem")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "dItem"),
                new Item(2, "cItem"),
                new Item(3, "bItem"),
                new Item(4, "aItem")
        );
        assertThat(expected).isEqualTo(items);
    }
}