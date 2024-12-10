package com.gildedrose.sale;


public class AgedBrie extends SaleItem {

    public AgedBrie(boolean conjured, int sellIn, int quality) {
        super(AGED_BRIE, conjured, sellIn, quality);
    }

    @Override
    protected int computeRegularDelta() {
        return 1;
    }
}
