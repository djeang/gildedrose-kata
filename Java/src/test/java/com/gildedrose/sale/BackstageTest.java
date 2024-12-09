package com.gildedrose.sale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BackstageTest {

    @Test
    void testComputeRegularDecrease() {
        Backstage backstage = new Backstage(false, 5, 0);
        Assertions.assertEquals(3, backstage.computeRegularDecrease());

        backstage = new Backstage(false, 10, 0);
        Assertions.assertEquals(2, backstage.computeRegularDecrease());
    }

}
