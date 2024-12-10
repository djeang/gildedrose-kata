package com.gildedrose.sale;

import org.junit.jupiter.api.Test;

public class SulfuraTest {

    @Test
    void qualityIs80() {
        RandomAsserts.assertUpdatedQuality(SaleItem.SULFURAS, 2, 0, 80);
    }
}
