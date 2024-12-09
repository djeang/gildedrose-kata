package com.gildedrose;

public class Item {

    // We cannot touch this
    public String name;

    // We cannot touch this
    public int sellIn;

    // We cannot touch this
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
