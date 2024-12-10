package com.gildedrose.sale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.sale.RandomAsserts.assertUpdatedQuality;

public class SaleItemTest {

    @Test
    void conjuredItem_twiceFast() {

        // non-conjured item decrease quality by 1
        assertUpdatedQuality("foo", 10, 8, 7);

        // while conjured item decrease quality by 2
        SaleItem saleItem = new SaleItem("foo", true, 10, 8);
        saleItem.updateQuality();
        Assertions.assertEquals(6, saleItem.getQuality());
    }

}
