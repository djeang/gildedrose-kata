package com.gildedrose.sale;

public class Backstage extends SaleItem {

    public Backstage(boolean conjured, int sellIn, int quality) {
        super(BACKSTAGE, conjured, sellIn, quality);
    }

    @Override
    protected int computeRegularDelta() {
        if (getSellIn() < 5) {
            return 3;
        }
        if (getSellIn() < 10) {
            return 2;
        }
        return 1;
    }

    @Override
    protected int computeUpdatedQuality(int originalQuality) {
        if (getSellIn() < 0) {
            return 0;
        }
        return super.computeUpdatedQuality(originalQuality);
    }
}
