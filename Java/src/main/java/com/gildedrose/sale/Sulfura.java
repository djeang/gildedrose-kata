package com.gildedrose.sale;


public class Sulfura extends SaleItem {

    public static final int IMMUTABLE_QUALITY = 80;

    public Sulfura(boolean conjured, int sellIn) {
        super(SULFURAS, conjured, sellIn, IMMUTABLE_QUALITY);
    }

    @Override
    protected int computeUpdatedQuality(int originalQuality) {
        return originalQuality;
    }

    @Override
    protected boolean canSale() {
        return false;
    }
}
