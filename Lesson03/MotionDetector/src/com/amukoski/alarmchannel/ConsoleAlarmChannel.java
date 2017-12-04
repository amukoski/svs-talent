package com.amukoski.alarmchannel;

public class ConsoleAlarmChannel implements AlarmChannel {

    private Long id;

    public ConsoleAlarmChannel(Long id) {
        this.id = id;
    }

    @Override
    public void alarm() {
        System.out.println("Alarm!! : " + this.toString());
    }

    @Override
    public String toString() {
        return "ConsoleAlarmChannel{" +
                "id=" + id +
                '}';
    }
}
