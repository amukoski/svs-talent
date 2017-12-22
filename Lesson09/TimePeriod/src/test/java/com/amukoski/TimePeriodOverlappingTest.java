package com.amukoski;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TimePeriodOverlappingTest {

    private LocalTime start;
    private LocalTime end;

    public TimePeriodOverlappingTest(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> overlappingTimes() {
        return Arrays.asList(new Object[][]{
                {
                        LocalTime.of(12, 0, 0),
                        LocalTime.of(14, 0, 0)
                },
                {
                        LocalTime.of(11, 30, 0),
                        LocalTime.of(13, 30, 0)
                },
                {
                        LocalTime.of(11, 30, 0),
                        LocalTime.of(14, 30, 0)
                },
                {
                        LocalTime.of(13, 0, 0),
                        LocalTime.of(14, 0, 0)
                },
                {
                        LocalTime.of(13, 0, 0),
                        LocalTime.of(15, 0, 0)
                }
        });
    }


    @Test
    public void testWhenTimesOverlap() {
        TimePeriod classUnderTest = new TimePeriod(
                LocalTime.of(12, 0, 0),
                LocalTime.of(14, 0, 0)
        );

        assertEquals(Boolean.TRUE, classUnderTest.overlapsWith(new TimePeriod(start, end)));
    }

}