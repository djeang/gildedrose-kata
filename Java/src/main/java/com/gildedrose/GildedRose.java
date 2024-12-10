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
        Arrays.stream(items).forEach(GildedRose::updateQuality);
    }

    // The main design principle is to isolate the legacy Item class at the system boundary.
    // New code relies solely on the SaleItem hierarchy, avoiding any dependency on Item.
    // This class handles the translation between Item and SaleItem.
    private static void updateQuality(Item item) {
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
