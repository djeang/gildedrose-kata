package com.gildedrose.sale;

import org.junit.jupiter.api.Assertions;

import static com.gildedrose.sale.SaleItem.*;

public class RandomAsserts {

    static void assertUpdatedQuality(String name, int sellIn, int quality, int expectedQuality) {
        SaleItem saleItem = toSale(name, sellIn, quality);
        saleItem.updateQuality();
        Assertions.assertEquals(expectedQuality, saleItem.getQuality());
    }

    private static SaleItem toSale(String name, int sellIn, int quality) {
        if (AGED_BRIE.equals(name)) {
            return new AgedBrie(false, sellIn, quality);
        }
        if (BACKSTAGE.equals(name)) {
            return new Backstage(false, sellIn, quality);
        }
        if (SULFURAS.equals(name)) {
            return new Sulfura(false, sellIn);
        }
        return new SaleItem(name, false, sellIn, quality);
    }

}
