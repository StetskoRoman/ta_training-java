package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device;

import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.HoseholdType;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.Room;

import java.util.Objects;

public class HoseholdDevice extends Device {

    private HoseholdType hoseholdType;
    private int yearOfManufacture;

    public HoseholdDevice(int index, String model, int power, Room room, HoseholdType hoseholdType, int yearOfManufacture) {
        super(index, model, power, room);
        this.hoseholdType = hoseholdType;
        this.yearOfManufacture = yearOfManufacture;
    }


    @Override
    public String toString() {
        return super.toString().replace("}",
                ", appliances: " + hoseholdType + ", " + yearOfManufacture + " year of manufacture" +
                        '}');
    }

    public HoseholdType getHoseholdType() {
        return hoseholdType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HoseholdDevice)) return false;
        if (!super.equals(o)) return false;
        HoseholdDevice that = (HoseholdDevice) o;
        return hoseholdType == that.hoseholdType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hoseholdType);
    }
}
