package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device;

import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.EntertainmentType;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.Room;

import java.util.Objects;

public class EntertainmentDevice extends Device {
    private EntertainmentType entertainmentType;

    public EntertainmentDevice(int index, String model, int power, Room room, EntertainmentType entertainmentType) {
        super(index, model, power, room);
        this.entertainmentType = entertainmentType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", entertainment: " + entertainmentType +
                '}');
    }

    public EntertainmentType getEntertainmentType() {
        return entertainmentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntertainmentDevice)) return false;
        if (!super.equals(o)) return false;
        EntertainmentDevice that = (EntertainmentDevice) o;
        return entertainmentType == that.entertainmentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), entertainmentType);
    }

}
