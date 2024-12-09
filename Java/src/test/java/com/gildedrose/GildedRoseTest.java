package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    // Corner case for sellin cut day
    @Test
    void regularItem_cutDate_decreaseBy1() {
        Item item = updateQuality("foo", 0, 0);
        Assertions.assertEquals( -1, item.sellIn);
        Assertions.assertEquals( 0, item.quality);
    }

    @Test
    void regularItem_passed_decreaseBy2() {
        Item item = updateQuality("foo", -1, 2);
        Assertions.assertEquals( 0, item.quality);
    }

    private static Item updateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return items[0];
    }

}
