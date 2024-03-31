package org.example.calculon.util;

import org.springframework.stereotype.Component;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;

@Component
public class Holiday {

    private List<MonthDay> holidays;

    public Holiday() {
        holidays = new ArrayList<>();
        holidays.add(MonthDay.of(1,1));
        holidays.add(MonthDay.of(1,2));
        holidays.add(MonthDay.of(1,3));
        holidays.add(MonthDay.of(1,4));
        holidays.add(MonthDay.of(1,5));
        holidays.add(MonthDay.of(1,6));
        holidays.add(MonthDay.of(1,7));
        holidays.add(MonthDay.of(1,8));
        holidays.add(MonthDay.of(2,23));
        holidays.add(MonthDay.of(3,8));
        holidays.add(MonthDay.of(5,1));
        holidays.add(MonthDay.of(5,9));
        holidays.add(MonthDay.of(6,12));
        holidays.add(MonthDay.of(11,4));
    }

    public void setHolidays(MonthDay day) {
        this.holidays.add(day);
    }

    public List<MonthDay> getHolidays() {
        return holidays;
    }

    public boolean isHoliday(MonthDay day) {
        for (MonthDay monthDay : holidays) {
            if (monthDay.equals(day)) {
                return true;
            }
        }
        return false;
    }

}