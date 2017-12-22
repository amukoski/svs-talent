package com.amukoski;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TimePeriodNotOverlappingTest {

    private LocalTime start;
    private LocalTime end;

    public TimePeriodNotOverlappingTest(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> notOverlappingTimes() {
        return Arrays.asList(new Object[][]{
                {
                        LocalTime.of(9, 0, 0),
                        LocalTime.of(10, 0, 0)
                },
                {
                        LocalTime.of(17, 0, 0),
                        LocalTime.of(20, 0, 0)
                },
                {
                        LocalTime.of(11, 0, 0),
                        LocalTime.of(12, 0, 0)
                },
                {
                        LocalTime.of(14, 0, 0),
                        LocalTime.of(15, 0, 0)
                }
        });
    }

    @Test
    public void testWhenTimesDontOverlap() {
        TimePeriod classUnderTest = new TimePeriod(
                LocalTime.of(12, 0, 0),
                LocalTime.of(14, 0, 0)
        );

        assertEquals(Boolean.FALSE, classUnderTest.overlapsWith(new TimePeriod(start, end)));
    }
}