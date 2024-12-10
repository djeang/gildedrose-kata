package com.gildedrose.sale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BackstageTest {

    @Test
    void testComputeRegularDelta() {

        Backstage backstage = new Backstage(false, 4, 0);
        Assertions.assertEquals(3, backstage.computeRegularDelta());

        backstage = new Backstage(false, 5, 0);
        Assertions.assertEquals(2, backstage.computeRegularDelta());

        backstage = new Backstage(false, 9, 0);
        Assertions.assertEquals(2, backstage.computeRegularDelta());
    }

}
