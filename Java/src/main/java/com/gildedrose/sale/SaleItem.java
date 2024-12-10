package com.gildedrose.sale;

public class SaleItem {

    public static final String AGED_BRIE = "Aged Brie";

    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    private final String name;

    private final boolean conjured;

    private int sellIn;

    private int quality;

    public SaleItem(String name, boolean conjured, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.conjured = conjured;
    }

    public final String getName() {
        return name;
    }

    public final int getSellIn() {
        return sellIn;
    }

    public final int getQuality() {
        return quality;
    }

    public final void updateQuality() {
        if (canSale()) {
            sellIn = sellIn -1;
        }

        quality = computeUpdatedQuality(quality);
    }

    // Avoid methods that both compute and change state
    protected int computeUpdatedQuality(int originalQuality) {

        // Regular decrease
        int regularDelta = computeRegularDelta();

        // Rule : Once the sell by date has passed, Quality degrades twice as fast
        if (isSellDateExpired()) {
            regularDelta = regularDelta * 2;
        }

        // Rule : "Conjured" items degrade in Quality twice as fast as normal items
        if (conjured && regularDelta < 0) {
            regularDelta = regularDelta * 2;
        }

        int result = originalQuality + regularDelta;

        // Rule: should be between 0 and 50 inclusive
        result = Integer.max(result, 0);
        result = Integer.min(result, 50);
        return result;
    }

    protected int computeRegularDelta() {
        return -1;
    }

    protected boolean canSale() {
        return true;
    }

    private boolean isSellDateExpired() {
        return sellIn < 0;
    }

}
