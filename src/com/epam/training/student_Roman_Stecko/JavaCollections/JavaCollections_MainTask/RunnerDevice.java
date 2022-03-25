package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask;

import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device.Device;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device.EntertainmentDevice;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device.HoseholdDevice;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Device.OtherDevice;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.EntertainmentType;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.HoseholdType;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.OtherTipe;
import com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_MainTask.Enums.Room;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RunnerDevice {
    static List<Device> devices = Arrays.asList(
            new HoseholdDevice(1, "L`Ornay", 1200, Room.KITCHEN,  HoseholdType.KETTLE, 2007),
            new HoseholdDevice(2, "GEFEST", 3000, Room.KITCHEN,  HoseholdType.ELECTRIC_STOVE, 2017),
            new HoseholdDevice(3, "Maunfield Slim", 100, Room.KITCHEN,  HoseholdType.KITCHEN_HOOD, 2002),
            new HoseholdDevice(4, "LG Inverter", 700, Room.KITCHEN,  HoseholdType.WASHING_MACHINE, 2010),
            new HoseholdDevice(5, "SNAIGE", 250, Room.KITCHEN,  HoseholdType.FRIDGE, 2009),

            new EntertainmentDevice(6, "HAFF i5", 400, Room.BEDROOM, EntertainmentType.COMPUTER),
            new EntertainmentDevice(7, "HP OMEN", 180, Room.BEDROOM, EntertainmentType.NOTEBOOK),
            new EntertainmentDevice(8, "HP Pavillion g6", 150, Room.LIVING_ROOM, EntertainmentType.NOTEBOOK),
            new EntertainmentDevice(9, "HORIZONT", 120, Room.KITCHEN, EntertainmentType.TV_SET),
            new EntertainmentDevice(10, "SAMSUNG", 160, Room.LIVING_ROOM, EntertainmentType.TV_SET),
            new EntertainmentDevice(11, "Spider 4", 210, Room.BEDROOM, EntertainmentType.ELECTRIC_GUITAR),
            new EntertainmentDevice(12, "XIAOMI Redmi", 30, Room.BEDROOM, EntertainmentType.MOBILE),
            new EntertainmentDevice(13, "Nokia 6300", 20, Room.LIVING_ROOM, EntertainmentType.MOBILE),

            new OtherDevice(14, "FERON", 20, Room.BEDROOM, OtherTipe.TABLE_LAMP),
            new OtherDevice(15, "PROTON", 15, Room.LIVING_ROOM, OtherTipe.TABLE_LAMP),
            new OtherDevice(16, "Электроника", 10, Room.BEDROOM, OtherTipe.CLOCK),
            new OtherDevice(17, "TROYK Quartz", 4, Room.KITCHEN, OtherTipe.CLOCK),
            new OtherDevice(18, "Galaxy", 300, Room.LIVING_ROOM, OtherTipe.IRON),
            new OtherDevice(19, "PHILIPS BHD", 200, Room.OTHER_PLACE, OtherTipe.DRYER),
            new OtherDevice(20, "LG Mp3", 15, Room.KITCHEN, OtherTipe.RECORD_PLAYER)
            );

    public static void main(String[] args) {
        Apartment apartment = new Apartment(devices);  //1 вывести приборы


        boolean notEndProgram = false;
        do {
            System.out.println("\nWhat do you want to do? Please, enter number of action");
            System.out.println("1: show all devices in apartment");
            System.out.println("2: show all devices in apartment sorted by power");
            System.out.println("3: turn on any devices and show their power"); //подсчитывать мощность должен
            System.out.println("4: show devices in range of power");
            System.out.println("5: show running devices");
            System.out.println("6: turn off devices");
            System.out.println("7: show devices by assignment");
            System.out.println("0: end the program\n");
            try {
                Scanner scanner = new Scanner(System.in);
                String enter = scanner.next();

                switch (enter){
                    case "1":
                        System.out.println("all devices: \n" + apartment.getDevices());
                        break;

                    case "2":
                        System.out.println(apartment.sortByMaxPower(devices));
                        break;

                    case "3":
                        System.out.println("what device you want to turn on? (press only by one index of device)");

                        int numberOfDevice;
                        do {
                            numberOfDevice = scanner.nextInt();
                            if (numberOfDevice == 0) {
                                break;
                            }
                            apartment.turnOnDevice(numberOfDevice - 1);
                            apartment.onDevices();
                            System.out.println("\nanything else? For end this task press 0");
                        }
                        while (numberOfDevice != 0);


                        break;

                    case "4":
                        System.out.println("Devices in what range of power you want to see? (from -> to)");
                        int powerFrom = scanner.nextInt();
                        int powerTo = scanner.nextInt();
                        System.out.println(apartment.devicesInRangeOfPower(powerFrom, powerTo));
                        break;

                    case "5":
                        apartment.onDevices();
                        break;

                    case "6":
                        System.out.println("what device you want to turn off? (press only by one index of device)");
                        int numberOfOffDevice;
                        do {
                            numberOfOffDevice = scanner.nextInt();
                            if (numberOfOffDevice == 0) {
                                break;
                            }
                            apartment.turnOffDevice(numberOfOffDevice - 1);
                            apartment.onDevices();
                            System.out.println("\nanything else? For end this task press 0");
                        }
                        while (numberOfOffDevice != 0);

                        break;

                    case "7":
                        boolean notEndGetDevices = false;
                        do {
                            System.out.println("\nwhat kind of assignment you want to get?");
                            System.out.println("1: get all entertainment devices");
                            System.out.println("2: get all household appliances");
                            System.out.println("3: get all other devices");
                            System.out.println("0: get back");
                            String enterType = scanner.next();
                            switch (enterType) {
                                case "1":
                                    System.out.println(apartment.getEntertainmentDevice());
                                    break;

                                case "2":
                                    System.out.println(apartment.getHoseholdDevice());
                                    break;

                                case "3":
                                    System.out.println(apartment.getOtherDevice());
                                    break;

                                case "0":
                                    notEndGetDevices = true;
                                    break;

                                default:
                                    System.out.println("unsupported action.");
                                    break;
                            }
                        } while (!notEndGetDevices);
                        break;

                    case "0":
                        System.exit(0);

                    default:
                        System.out.println("unsupported action, please try again.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (!notEndProgram);

    }
}
