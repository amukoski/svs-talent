package com.amukoski;

import java.time.LocalTime;

public class TimePeriod {

    private LocalTime start;
    private LocalTime end;

    public TimePeriod(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public Boolean overlapsWith(TimePeriod timePeriod) {
        if (start.isBefore(timePeriod.end) && end.isAfter(timePeriod.start)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
