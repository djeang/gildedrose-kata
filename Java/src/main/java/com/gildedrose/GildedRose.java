package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";

    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    // We cannot touch this
    Item[] items;

    public GildedRose(List<Item> items) {
        this.items = items.toArray(new Item[0]);
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(GildedRose::updateQuality);
    }

    private static void updateQuality(Item item) {
        if (!item.name.equals(AGED_BRIE)
            && !item.name.equals(BACKSTAGE)) {
            if (item.quality > 0) {
                if (!item.name.equals(SULFURAS)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(SULFURAS)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
