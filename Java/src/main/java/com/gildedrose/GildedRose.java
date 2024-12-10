package com.gildedrose;

import com.gildedrose.sale.AgedBrie;
import com.gildedrose.sale.Backstage;
import com.gildedrose.sale.SaleItem;
import com.gildedrose.sale.Sulfura;

import java.util.Arrays;
import java.util.List;

import static com.gildedrose.sale.SaleItem.*;

class GildedRose {


    // We cannot touch this
    Item[] items;

    public GildedRose(List<Item> items) {
        this.items = items.toArray(new Item[0]);
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(GildedRose::updateQuality2);
    }

    private static void updateQuality(Item item) {
        if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE)) {
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

    private static void updateQuality2(Item item) {
        SaleItem saleItem = toSale(item);
        saleItem.updateQuality();
        item.sellIn = saleItem.getSellIn();
        item.quality = saleItem.getQuality();
    }

    private static SaleItem toSale(Item item) {
        if (AGED_BRIE.equals(item.name)) {
            return new AgedBrie(false, item.sellIn, item.quality);
        }
        if (BACKSTAGE.equals(item.name)) {
            return new Backstage(false, item.sellIn, item.quality);
        }
        if (SULFURAS.equals(item.name)) {
            return new Sulfura(false, item.sellIn);
        }
        return new SaleItem(item.name, false, item.sellIn, item.quality);
    }


}
