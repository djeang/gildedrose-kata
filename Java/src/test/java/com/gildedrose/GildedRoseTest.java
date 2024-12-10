package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class GildedRoseTest {

    @Test
    void regularItem_Before_decreaseBy1() {
        assertUpdatedQuality("foo", 1, 2, 1);
    }

    // Corner case for sellin cut day
    @Test
    void regularItem_cutDate_decreaseBy2() {
        assertUpdatedQuality("foo", 0, 2, 0);
    }

    @Test
    void regularItem_passed_decreaseBy2() {
        assertUpdatedQuality("foo", -1, 2, 0);
    }

    private static void assertUpdatedQuality(String name, int sellIn, int quality, int expectedUpdatedQuality) {
        List<Item> items = new LinkedList<>();
        items.add(new Item(name, sellIn, quality));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertEquals( expectedUpdatedQuality, items.get(0).quality);
    }

}
