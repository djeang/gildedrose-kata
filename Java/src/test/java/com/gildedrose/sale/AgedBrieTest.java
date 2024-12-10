package com.gildedrose.sale;

import org.junit.jupiter.api.Test;

public class AgedBrieTest {

    @Test
    void sellIn1DayQualityIs1_qualityIs2() {
        RandomAsserts.assertUpdatedQuality(SaleItem.AGED_BRIE, 1, 1, 2);
    }
}
