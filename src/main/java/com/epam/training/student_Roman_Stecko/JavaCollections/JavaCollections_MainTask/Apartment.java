package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask;

import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device.Device;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device.EntertainmentDevice;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device.HoseholdDevice;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device.OtherDevice;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Exceptions.DeviceException;

import java.util.*;

public class Apartment {
    private List<? extends Device> devicesList;
    private List<? super Device> deviceChange;
    private List<Device> deviceOn = new ArrayList<>();

    public List<Device> getDevices() {

        return (List<Device>) devicesList;
    }

    public Apartment(List<Device> devicesList) {
        this.devicesList = devicesList;
        if (devicesList == null) {
            throw new DeviceException("list is null");
        }
    }


    @Override
    public String toString() {
        return String.valueOf(devicesList);
    }

    public List<? extends Device> sortByMaxPower(List<? extends Device> devices ) {
        isNullOrEmpty(devices);
        List<? extends Device> sortedByPower = new ArrayList<>(devices);
        sortedByPower.sort((o1, o2) -> o1.getPower() - o2.getPower());

        return sortedByPower;
    }

    public List<EntertainmentDevice> getEntertainmentDevice() {
        List <EntertainmentDevice> entertainmentDevices = new ArrayList<>();
        for (Device device : devicesList) {
            if (device instanceof EntertainmentDevice) {
                entertainmentDevices.add((EntertainmentDevice) device);
            }
        }
        return entertainmentDevices;
    }

    public List<HoseholdDevice> getHoseholdDevice() {
        List <HoseholdDevice> hoseholdDevices = new ArrayList<>();
        for (Device device : devicesList) {
            if (device instanceof HoseholdDevice) {
                hoseholdDevices.add((HoseholdDevice) device);
            }
        }
        return hoseholdDevices;
    }

    public List<OtherDevice> getOtherDevice() {
        List <OtherDevice> otherDevices = new ArrayList<>();
        for (Device device : devicesList) {
            if (device instanceof OtherDevice) {
                otherDevices.add((OtherDevice) device);
            }
        }
        return otherDevices;
    }

    public List<? extends Device> turnOnDevice(int index) {
        if ((index <= -1) || ((index + 1) > (devicesList.size()))){
            throw new DeviceException("Unexpected device");
        }
        for (int j = 0; j < deviceOn.size(); j++){
            if (deviceOn.get(j).equals(devicesList.get(index))) {
                throw new DeviceException("Sorry but you can`t turn on device twice");
            }
        }

        for (int i = 0; i <= getDevices().size(); i++) {

                if (i == index) {
                    deviceOn.add(getDevices().get(i));
            }
        }
        return deviceOn;
    }

    public void onDevices (){
        System.out.println("\nenabled devices:");
        if (deviceOn.size() == 0) {
            System.out.println("all devices are disabled");
        }
        int onDevicesPower = 0;
        for (int i = 0; i < deviceOn.size(); i++) {
            System.out.print(deviceOn.get(i));
            onDevicesPower += deviceOn.get(i).getPower();
        }
        System.out.println("\nPower of enabled devices = " + onDevicesPower);
    }

    public List<? extends Device> turnOffDevice(int index) {
        for (int j = 0; j < deviceOn.size(); j++){
            if (deviceOn.get(j).equals(devicesList.get(index))) {
                deviceOn.remove(deviceOn.get(j));

            }
        }
        return deviceOn;
    }

    public List<? extends Device> devicesInRangeOfPower(int from, int to){
        if (from > to) {
            throw new DeviceException("at first from, and then to, not differently");
        }
        List <? extends Device> powerDevices = new ArrayList<>(devicesList);
        List<Device> NewPowerList = new ArrayList<>();
        for (Device device : powerDevices) {
            if (device.getPower() >= from && device.getPower() <= to) {
                NewPowerList.add(device);
            }
        }
        return NewPowerList;
    }


    public static void isNullOrEmpty (List<? extends Device> list) {
        if (list == null || list.isEmpty()) {
            throw new DeviceException("list can`t be null or empty");
        }
    }

}
