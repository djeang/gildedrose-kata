package com.gildedrose.sale;


public class Sulfura extends SaleItem {

    public static final int IMMUTABLE_QUALITY = 50;

    public Sulfura(boolean conjured, int sellIn) {
        super(SULFURAS, conjured, sellIn, IMMUTABLE_QUALITY);
    }

    @Override
    protected int computeUpdatedQuality(int originalQuality) {
        return originalQuality;
    }
}
