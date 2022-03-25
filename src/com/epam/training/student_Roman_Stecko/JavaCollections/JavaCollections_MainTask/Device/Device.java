package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device;


import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.Room;

import java.util.Objects;

public class Device {
    private int index;
    String model;
    private int power;
    private Room room;

    public Device(int index, String model, int power, Room room) {
        this.index = index;
        this.model = model;
        this.power = power;
        this.room = room;
    }

    public int getIndex() {
        return index;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "\nDevice " + index +
                ", {model '" + model + '\'' +
                ", power = " + power +
                ", room: " + room + "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return index == device.index && power == device.power && Objects.equals(model, device.model) && room == device.room;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, model, power, room);
    }
}


