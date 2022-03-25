package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device;

import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.OtherTipe;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.Room;

import java.util.Objects;

public class OtherDevice extends Device {
    private OtherTipe otherTipe;

    public OtherDevice(int index, String model, int power, Room room, OtherTipe otherTipe) {
        super(index, model, power, room);
        this.otherTipe = otherTipe;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", other device: " + otherTipe +
                        '}');
    }

    public OtherTipe getOtherTipe() {
        return otherTipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OtherDevice)) return false;
        if (!super.equals(o)) return false;
        OtherDevice that = (OtherDevice) o;
        return otherTipe == that.otherTipe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), otherTipe);
    }
}
