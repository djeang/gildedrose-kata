package com.gildedrose.sale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaleItemTest {

    @Test
    void conjuredItem_twiceFast() {
        SaleItem regularItem = new SaleItem("foo", false, 10, 8);
        regularItem.updateQuality();
        Assertions.assertEquals(7, regularItem.getQuality());

        SaleItem conjuredItem = new SaleItem("foo", true, 10, 8);
        conjuredItem.updateQuality();
        Assertions.assertEquals(6, conjuredItem.getQuality());
    }



}
