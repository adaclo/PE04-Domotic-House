package Activitats.PE04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PE04_AcarretaAdrian {
    // COLORS
    final String RESET = "\u001B[0m";
    final String ROJO = "\u001B[31m";
    final String VERDE = "\u001B[32m";
    final String AMARILLO = "\u001B[33m";
    final String AZUL = "\u001B[34m";

    Boolean scheduleDoors = false;
    String passwordDoors = null;
    Boolean panicMode = false;
    Boolean H1 = false;
    Boolean H2 = false;
    Boolean H3 = false;
    Boolean bathroom = false;
    Boolean kitchen = false;
    Boolean living_room = false;
    int tempH1 = 18;
    int tempH2 = 18;
    int tempH3 = 18;
    int tempBathroom = 18;
    int tempKitchen = 18;
    int tempLivingRoom = 18;
    String r;
    String h;
    Boolean lightsMenu = true;
    Boolean validRoom = false;
    Boolean validOpt = false;
    Boolean machineState = false; // Aquesta variabe la necessito declarar global perquè quan obri el menu de la rentadora faré una comprovació

    // Variables portes
    String mainDoor = "closed";
    String kitchenDoor = "closed";
    String garageDoor = "closed";
    String backyardDoor = "closed";
    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        PE04_AcarretaAdrian p = new PE04_AcarretaAdrian();
        p.principal();
    }

    public void principal() {
        do {
            System.out.println(AZUL + "\nDomotic house:\n" + RESET);
            System.out.println("  a. Control temperature");
            System.out.println("  b. Control doors");
            System.out.println("  c. Control laundry machine");
            System.out.println("  d. Control lights");
            System.out.println("  e. Exit");
            System.out.print(AMARILLO + "Choose: " + RESET);
            r = s.next();

            switch (r) {
                case "a":
                    controlTemperature();
                    break;
                case "b":
                    controlDoors();
                    break;
                case "c":
                    controlLaundryMachine();
                    break;
                case "d":
                    controlLights();
                    break;
                case "e":
                    System.out.println(VERDE + "Closing menu..." + RESET);
                    break;
                default:
                    System.out.println(ROJO + "(!) Invalid option." + RESET);
                    break;
            }

        } while (!r.equalsIgnoreCase("e"));
    }

    public void controlTemperature() {
        do {
            System.out.println(AZUL + "\nTemperature control:\n" + RESET);
            System.out.println("  a. Control a room");
            System.out.println("  b. Control all the rooms");
            System.out.println("  c. Show current temperature");
            System.out.println("  d. Go back");
            System.out.print(AMARILLO + "Choose: " + RESET);
            r = s.next();
            switch (r) {
                case "a":
                    validRoom = false;
                    while (!validRoom) {
                        System.out.print(AMARILLO + "Choose the room (H1/H2/H3/bathroom/kitchen/living_room): " + RESET);
                        String room = s.next();
                        if (room.equalsIgnoreCase("H1") || room.equalsIgnoreCase("H2") || room.equalsIgnoreCase("H3")
                                || room.equalsIgnoreCase("bathroom") || room.equalsIgnoreCase("kitchen")
                                || room.equalsIgnoreCase("living_room")) {
                            validRoom = true;
                            changeTemperatureRoom(room);
                        } else {
                            System.out.println(ROJO + "(!) Invalid room." + RESET);
                        }
                    }
                    break;
                case "b":
                    changeTemperatureAllRooms();
                    break;
                case "c":
                    showTemperatureRooms();
                    break;
                default:
                    System.out.println(ROJO + "(!) Invalid option." + RESET);
                    break;
            }
        } while (r.equals("d"));
    }

    public void changeTemperatureRoom(String room) {
        do {
            System.out.println(AZUL + "\nChange temperature specific room:\n" + RESET);
            System.out.println("  a. Choose manual temp");
            System.out.println("  b. Increase temp (+1)");
            System.out.println("  c. Decrease temp (-1)");
            System.out.println("  d. Go back");
            System.out.print(AMARILLO + "Choose: " + RESET);
            r = s.next();
            switch (r) {
                case "a":
                    try {
                        Boolean validTemp=false;
                        while (!validTemp) {
                            System.out.print(AMARILLO + "Choose temperature: " + RESET);
                            r = s.next();
                            if (Integer.parseInt(r)<0 || Integer.parseInt(r)>35) {
                                System.out.println(ROJO+"Please enter a number between 0 and 35.");
                            } else {
                                validTemp=true;
                                int temperature = Integer.parseInt(r);
                                setTemperature(room,temperature);
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(ROJO + "(!) Invalid format, please enter an integer");
                    }
                    break;
                case "b":
                    increaseTempSpecificRoom(room);
                    break;
                case "c":
                    decreaseTempSpecificRoom(room);
                    break;
                default:
                    break;
            }
        } while (r.equals("d"));
        
    }
    public void changeTemperatureAllRooms() {
        do {
            System.out.println(AZUL + "\nChange temperature all rooms:\n" + RESET);
            System.out.println("  a. Choose manual temp");
            System.out.println("  b. Increase temp (+1)");
            System.out.println("  c. Decrease temp (-1)");
            System.out.println("  d. Go back");
            System.out.print(AMARILLO + "Choose: " + RESET);
            r = s.next();
            switch (r) {
                case "a":
                    try {
                        Boolean validTemp=false;
                        while (!validTemp) {
                            System.out.print(AMARILLO + "Choose temperature: " + RESET);
                            r = s.next();
                            if (Integer.parseInt(r)<0 || Integer.parseInt(r)>35) {
                                System.out.println(ROJO+"Please enter a number between 0 and 35.");
                            } else {
                                validTemp=true;
                                int temperature = Integer.parseInt(r);
                                setTemperatureAllRooms(temperature);
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(ROJO + "(!) Invalid format, please enter an integer");
                    }
                    break;
                case "b":
                    tempH1 = increaseTemp(tempH1);
                    tempH2 = increaseTemp(tempH2);
                    tempH3 = increaseTemp(tempH3);
                    tempBathroom = increaseTemp(tempBathroom);
                    tempKitchen = increaseTemp(tempKitchen);
                    tempLivingRoom = increaseTemp(tempLivingRoom);
                    break;
                case "c":
                    tempH1 = decreaseTemp(tempH1);
                    tempH2 = decreaseTemp(tempH2);
                    tempH3 = decreaseTemp(tempH3);
                    tempBathroom = decreaseTemp(tempBathroom);
                    tempKitchen = decreaseTemp(tempKitchen);
                    tempLivingRoom = decreaseTemp(tempLivingRoom);
                    break;
                default:
                    break;
            }
        } while (r.equals("d"));
        
    }

    public void setTemperatureAllRooms(int temp) {
        temperatureLoop(temp, tempH1);
        temperatureLoop(temp, tempH2);
        temperatureLoop(temp, tempH3);
        temperatureLoop(temp, tempBathroom);
        temperatureLoop(temp, tempKitchen);
        temperatureLoop(temp, tempLivingRoom);
    }



    public void showTemperatureRooms() {
        System.out.println("Temperature of " + AMARILLO + "H1" + RESET + " is: " + AMARILLO + tempH1 + RESET);
        System.out.println("Temperature of " + AMARILLO + "H2" + RESET + " is: " + AMARILLO + tempH2 + RESET);
        System.out.println("Temperature of " + AMARILLO + "H3" + RESET + " is: " + AMARILLO + tempH3 + RESET);
        System.out.println("Temperature of " + AMARILLO + "Bathroom" + RESET + " is: " + AMARILLO + tempBathroom + RESET);
        System.out.println("Temperature of " + AMARILLO + "Kitchen" + RESET + " is: " + AMARILLO + tempKitchen + RESET);
        System.out.println("Temperature of " + AMARILLO + "Living Room" + RESET + " is: " + AMARILLO + tempLivingRoom + RESET);
    }

    public void increaseTempSpecificRoom(String room) {
       if (room.equalsIgnoreCase("h1")) {
            tempH1 = increaseTemp(tempH1);
        } else if (room.equalsIgnoreCase("h2")) {
            tempH2 = increaseTemp(tempH2);
        } else if (room.equalsIgnoreCase("h3")) {
            tempH3 = increaseTemp(tempH3);
        } else if (room.equalsIgnoreCase("bathroom")) {
            tempBathroom = increaseTemp(tempBathroom);
        } else if (room.equalsIgnoreCase("kitchen")) {
            tempKitchen = increaseTemp(tempKitchen);
        } else if (room.equalsIgnoreCase("living_room")) {
            tempLivingRoom = increaseTemp(tempLivingRoom);
        } 
    }

    public int increaseTemp(int temp) {
        int oldTemp = temp;
        temp++;
        System.out.println("Temperature increased from " + AMARILLO + oldTemp + RESET + " to " + VERDE + temp + RESET);
        return temp;
    }

    public int decreaseTemp(int temp) {
        int oldTemp = temp;
        temp--;
        System.out.println("Temperature decreased from " + AMARILLO + oldTemp + RESET + " to " + VERDE + temp + RESET);
        
        return temp;
    }

    public void decreaseTempSpecificRoom(String room) {
       if (room.equalsIgnoreCase("h1")) {
            tempH1 = decreaseTemp(tempH1);
        } else if (room.equalsIgnoreCase("h2")) {
            tempH2 = decreaseTemp(tempH2);
        } else if (room.equalsIgnoreCase("h3")) {
            tempH3 = decreaseTemp(tempH3);
        } else if (room.equalsIgnoreCase("bathroom")) {
            tempBathroom = decreaseTemp(tempBathroom);
        } else if (room.equalsIgnoreCase("kitchen")) {
            tempKitchen = decreaseTemp(tempKitchen);
        } else if (room.equalsIgnoreCase("living_room")) {
            tempLivingRoom = decreaseTemp(tempLivingRoom);
        } 
    }

    public void setTemperature(String room, int temperatureLimit) {
        if (room.equalsIgnoreCase("h1")) {
            tempH1 = temperatureLoop(temperatureLimit,tempH1);
        } else if (room.equalsIgnoreCase("h2")) {
            tempH2 = temperatureLoop(temperatureLimit,tempH2);
        } else if (room.equalsIgnoreCase("h3")) {
            tempH3 = temperatureLoop(temperatureLimit,tempH3);
        } else if (room.equalsIgnoreCase("bathroom")) {
            tempBathroom = temperatureLoop(temperatureLimit,tempBathroom);
        } else if (room.equalsIgnoreCase("kitchen")) {
            tempKitchen = temperatureLoop(temperatureLimit,tempKitchen);
        } else if (room.equalsIgnoreCase("living_room")) {
            tempLivingRoom = temperatureLoop(temperatureLimit,tempLivingRoom);
        }
    }

    public int temperatureLoop(int temperatureLimit, int currentTemp) {
        int finalTemp=0;
        if (temperatureLimit>currentTemp) {
            for (int temp=currentTemp;temp<=temperatureLimit;temp++) {
                System.out.println("Temperature is " + AMARILLO + temp + RESET);
                if (temp==temperatureLimit) {
                    finalTemp = temp;
                    System.out.println(VERDE + "Temperature has been set to " + RESET + finalTemp);
                }
            }
        } else if (temperatureLimit<currentTemp) {
            for (int temp=currentTemp;temp>=temperatureLimit;temp--) {
                System.out.println("Temperature is " + AMARILLO + temp + RESET);
                if (temp==temperatureLimit) {
                    finalTemp = temp;
                    System.out.println(VERDE + "Temperature has been set to " + RESET + finalTemp);
                }
            }
        }
        return finalTemp;
    }

    public void controlLaundryMachine() {
        String program = null;
        do {
            System.out.println(AZUL + "\nLaundry machine control:\n" + RESET);
            System.out.println("  a. Start a program");
            System.out.println("  b. Check status");
            if (machineState == true) {
                System.out.println("  c. Cancel program");
            }
            System.out.println("  d. Go back");
            System.out.print(AMARILLO + "Choose: " + RESET);
            r = s.next();

            switch (r) {
                case "a":
                    Boolean validProgram = false;
                    if (machineState == true) {
                        System.out.println(AMARILLO + "Laundry machine is currently in a program." + RESET);
                    } else {
                        while (!validProgram) {
                            System.out.print(AMARILLO + "Choose the program (eco/turbo/regular): " + RESET);
                            r = s.next();
                            if (r.equalsIgnoreCase("eco") || r.equalsIgnoreCase("turbo") || r.equalsIgnoreCase("regular")) {
                                validProgram = true;
                                machineState = true;
                                program = r;
                                System.out.printf(VERDE + "Laundry program set to: %s\n" + RESET, program);
                            } else {
                                System.out.println(ROJO + "(!) Invalid program." + RESET);
                            }
                        }
                    }
                    break;
                case "b":
                    System.out.printf(AZUL + "\nCurrent program is %s\n" + RESET, program);
                    break;
                case "c":
                    if (program != null) {
                        program = null;
                        machineState = false;
                        System.out.println(VERDE + "Laundry program correctly canceled" + RESET);
                    }
                    break;
                case "d":
                    break;
                default:
                    System.out.println(ROJO + "(!) Invalid option." + RESET);
                    break;
            }
        } while (!r.equalsIgnoreCase("d"));
    }

    public void controlLights() {
        do {
            System.out.println(AZUL + "\nLights control:\n" + RESET);
            System.out.println("  a. Control a room");
            System.out.println("  b. Control all the rooms");
            System.out.println("  c. Show the real state of the lights");
            System.out.println("  d. Go back");
            System.out.print(AMARILLO + "Choose: " + RESET);
            r = s.next();

            switch (r) {
                case "a":
                    controlSpecificLight();
                    break;
                case "b":
                    validOpt = false;
                    while (!validOpt) {
                        System.out.print(AMARILLO + "Manual - turn on or off (on/off): " + RESET);
                        r = s.next();
                        if (r.equalsIgnoreCase("on") || r.equalsIgnoreCase("off")) {
                            validOpt = true;
                            controlAllRooms(r);
                        } else {
                            System.out.println(ROJO + "(!) Invalid option." + RESET);
                        }
                    }
                    break;
                case "c":
                    showRooms();
                    break;
                case "d":
                    break;
                default:
                    System.out.println(ROJO + "(!) Invalid option." + RESET);
                    break;
            }
        } while (!r.equalsIgnoreCase("d"));
    }

    public boolean controlRoom(String h, Boolean currentState, String r) {
        if (r.equalsIgnoreCase("on")) {
            if (currentState) {
                messageLightAlreadyOnOff(h, r);
            } else {
                currentState = true;
                messageLightOnOff(h, r);
            }
        } else {
            if (!currentState) {
                messageLightAlreadyOnOff(h, r);
            } else {
                currentState = false;
                messageLightOnOff(h, r);
            }
        }
        return currentState;
    }

    public void controlAllRooms(String r) {
        boolean turnOn = r.equalsIgnoreCase("on");
        H1 = H2 = H3 = bathroom = kitchen = living_room = turnOn;
        System.out.printf(VERDE + "All rooms successfully turned lights %s\n\n" + RESET, r);
    }

    public void messageLightOnOff(String h, String r) {
        System.out.printf(VERDE + "Room - %s successfully turned %s\n\n" + RESET, h, r);
    }

    public void messageLightAlreadyOnOff(String h, String r) {
        System.out.printf(AMARILLO + "Room - %s was already %s.\n\n" + RESET, h, r);
    }

    public void showRooms() {
        System.out.println(AZUL + "\nLights state:\n" + RESET);
        if (H1) {
            System.out.println("Room - H1 - " + VERDE + "On" + RESET);
        } else {
            System.out.println("Room - H1 - " + ROJO + "Off" + RESET);
        }
        if (H2) {
            System.out.println("Room - H2 - " + VERDE + "On" + RESET);
        } else {
            System.out.println("Room - H2 - " + ROJO + "Off" + RESET);
        }
        if (H3) {
            System.out.println("Room - H3 - " + VERDE + "On" + RESET);
        } else {
            System.out.println("Room - H3 - " + ROJO + "Off" + RESET);
        }
        if (bathroom) {
            System.out.println("Room - Bathroom - " + VERDE + "On" + RESET);
        } else {
            System.out.println("Room - Bathroom - " + ROJO + "Off" + RESET);
        }
        if (kitchen) {
            System.out.println("Room - Kitchen - " + VERDE + "On" + RESET);
        } else {
            System.out.println("Room - Kitchen - " + ROJO + "Off" + RESET);
        }
        if (living_room) {
            System.out.println("Room - Living Room - " + VERDE + "On\n" + RESET);
        } else {
            System.out.println("Room - Living Room - " + ROJO + "Off\n" + RESET);
        }
    }

    public void controlSpecificLight() {
        validOpt = false;
        validRoom = false;
        while (!validRoom) {
            System.out.print(AMARILLO + "Choose the room (H1/H2/H3/bathroom/kitchen/living_room): " + RESET);
            h = s.next();
            if (h.equalsIgnoreCase("H1") || h.equalsIgnoreCase("H2") || h.equalsIgnoreCase("H3")
                    || h.equalsIgnoreCase("bathroom") || h.equalsIgnoreCase("kitchen")
                    || h.equalsIgnoreCase("living_room")) {
                validRoom = true;
                while (!validOpt) {
                    System.out.print(AMARILLO + "Manual - turn on or off (on/off): " + RESET);
                    r = s.next();
                    if (r.equalsIgnoreCase("on") || r.equalsIgnoreCase("off")) {
                        validOpt = true;
                        switch (h) {
                            case "H1":
                                H1 = controlRoom(h, H1, r);
                                break;
                            case "H2":
                                H2 = controlRoom(h, H2, r);
                                break;
                            case "H3":  
                                H3 = controlRoom(h, H3, r);
                                break;
                            case "bathroom":
                                bathroom = controlRoom(h, bathroom, r);
                                break;
                            case "kitchen":
                                kitchen = controlRoom(h, kitchen, r);
                                break;
                            case "living_room":
                                living_room = controlRoom(h, living_room, r);
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println(ROJO + "(!) Invalid option." + RESET);
                    }
                }
            } else {
                System.out.println(ROJO + "(!) Invalid room." + RESET);
            }
        }
    }

    public void controlDoors() {
        s.nextLine();
        
        String resp = null;

        do {
            if (panicMode) {
                System.out.println(ROJO + "\n--- PANIC MODE ACTIVATED ---" + RESET);
                System.out.print(AMARILLO + "Introduce the password to unlock it: " + RESET);
                r = s.nextLine();
                if (r.equalsIgnoreCase(passwordDoors) && !r.equals(null)) {
                    panicMode = false;
                    System.out.println(VERDE + "\nPanic mode turned off correctly." + RESET);
                } else {
                    System.out.println(ROJO + "\n(!) Incorrect password!" + RESET);
                }
            } else {
                
                System.out.println(AZUL + "\nDoors control:\n" + RESET);
                System.out.println("  a. Control a specific door");
                System.out.println("  b. Control all the doors");
                System.out.println("  c. Check all doors status");
                System.out.println("  d. Turn on PANIC MODE");
                System.out.println("  e. Schedule specific door");
                System.out.println("  f. Go back");
                System.out.print(AMARILLO + "Choose: " + RESET);
                resp = s.next();
                scheduleDoors = false;
                switch (resp) {
                    case "a":
                        controlSpecificDoor(scheduleDoors);
                        break;
                    case "b":
                        controlAllDoors();
                        break;
                    case "c":
                        showDoors();
                        break;
                    case "d":
                        passwordDoors = turnPanicMode();
                        break;
                    case "e":
                        scheduleDoors = true;
                        controlSpecificDoor(scheduleDoors);
                        break;
                    default:
                        break;
                }
            }
        } while (!resp.equalsIgnoreCase("f"));
    }

    public void showDoors() {
        System.out.println(AZUL + "\nDoors state:\n" + RESET);
        System.out.printf("Door - main - %s\n", mainDoor + RESET);
        System.out.printf("Door - kitchen - %s\n", kitchenDoor + RESET);
        System.out.printf("Door - garage - %s\n", garageDoor + RESET);
        System.out.printf("Room - backyard - %s\n", backyardDoor + RESET);
    }

    public String turnPanicMode() {
        System.out.print(AMARILLO + "You're enabling panic mode, choose a password: ");
        passwordDoors = s.next();
        if (!passwordDoors.equals(null)) {
            panicMode = true;
            System.out.println(VERDE + "Panic Mode ENABLED");
        }
        return passwordDoors;
    }

    public String scheduleSpecificDoor(String door, String currentState, String r) {
        if ((currentState.equals("closed") && (r.equalsIgnoreCase("close")) || r.equalsIgnoreCase("unlock")) || (currentState.equals("opened") && r.equalsIgnoreCase("open")) || (currentState.equals("locked") && r.equalsIgnoreCase("lock"))) {
            messageDoorAlreadyOnOff(door, r);
        } else {
            int startHour,startMinute,startSecond,endHour,endMinute,endSecond;
            String oldState=currentState;
            try {
                System.out.printf(AZUL + "Start time of %s to turn %s\n",door,r);
                do {
                    System.out.print(AMARILLO + "Choose an hour: " + RESET);
                    startHour=s.nextInt();
                    if (startHour>=0 && startHour <24)
                        validOpt=true;
                } while (!validOpt);
                validOpt=false;
                do {
                    System.out.print(AMARILLO + "Choose a minute: " + RESET);
                    startMinute=s.nextInt();
                    if (startMinute>=0 && startMinute <60)
                        validOpt=true;
                } while (!validOpt);
                validOpt=false;
                do {
                    System.out.print(AMARILLO + "Choose a second: " + RESET);
                    startSecond=s.nextInt();
                    if (startSecond>=0 && startSecond <60)
                        validOpt=true;
                } while (!validOpt);
                validOpt=false;

                System.out.printf(AZUL + "End time of %s being %s\n",door,r);
                do {
                    System.out.print(AMARILLO + "Choose an hour: " + RESET);
                    endHour=s.nextInt();
                    if (endHour>=0 && endHour <24)
                        validOpt=true;
                } while (!validOpt);
                validOpt=false;
                do {
                    System.out.print(AMARILLO + "Choose a minute: " + RESET);
                    endMinute=s.nextInt();
                    if (endMinute>=0 && endMinute <60)
                        validOpt=true;
                } while (!validOpt);
                validOpt=false;
                do {
                    System.out.print(AMARILLO + "Choose a second: " + RESET);
                    endSecond=s.nextInt();
                    if (endSecond>=0 && endSecond <60)
                        validOpt=true;
                } while (!validOpt);
                validOpt=false;

                for (int day=0;day<=1;day++) {
                    for (int hourCount=0;hourCount<24;hourCount++) {
                        for (int minuteCount=0;minuteCount<60;minuteCount++) {
                            for (int secondCount=0;secondCount<60;secondCount++) {
                                if (startHour>endHour) {
                                    if (day==0) {
                                        if (hourCount==startHour && minuteCount==startMinute && secondCount==startSecond) {
                                            System.out.printf(VERDE + "\nCurrent time is %d:%d:%d\n",hourCount,minuteCount,secondCount);
                                            currentState = controlDoor(door, currentState, r);
                                        }
                                    }
                                } else { 
                                    if (hourCount==startHour && minuteCount==startMinute && secondCount==startSecond) {
                                        System.out.printf(VERDE + "\nCurrent time is %d:%d:%d\n",hourCount,minuteCount,secondCount);
                                        currentState = controlDoor(door, currentState, r);
                                    }
                                }
                                if (startHour>endHour) {
                                    if (day==1) {
                                        if (hourCount==endHour && minuteCount==endMinute && secondCount==endSecond) {
                                            System.out.printf(ROJO + "\nCurrent time is %d:%d:%d\n",hourCount,minuteCount,secondCount);
                                            currentState = controlDoor(door, currentState, oldState);
                                        }
                                    }
                                } else {
                                    if (hourCount==endHour && minuteCount==endMinute && secondCount==endSecond) {
                                        System.out.printf(ROJO + "\nCurrent time is %d:%d:%d\n",hourCount,minuteCount,secondCount);
                                        currentState = controlDoor(door, currentState, oldState);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (InputMismatchException e){
                System.out.println(ROJO + "(!) Invalid format, please enter an integer");

            }
        }
        return currentState;
    }
    public void controlSpecificDoor(boolean scheduleDoors) {
        Boolean validOpt = false;
        Boolean validDoor = false;
        while (!validDoor) {
            System.out.print(AMARILLO + "Choose the door (main/kitchen/garage/backyard): " + RESET);
            String door = s.next();
            if (door.equalsIgnoreCase("main") || door.equalsIgnoreCase("kitchen")
                    || door.equalsIgnoreCase("garage") || door.equalsIgnoreCase("backyard")) {
                validDoor = true;
                while (!validOpt) {
                    System.out.print(AMARILLO + "Manual - change state (open/close/lock/unlock): " + RESET);
                    r = s.next();
                    if (r.equalsIgnoreCase("open") || r.equalsIgnoreCase("close")
                            || r.equalsIgnoreCase("lock") || r.equalsIgnoreCase("unlock")) {
                        validOpt = true;
                        switch (door) {
                            case "main":
                                if (!scheduleDoors) {
                                    mainDoor = controlDoor(door, mainDoor, r);
                                } else {
                                    mainDoor = scheduleSpecificDoor(door,mainDoor,r);
                                }
                                break;
                            case "kitchen":
                                if (!scheduleDoors) {
                                    kitchenDoor = controlDoor(door, kitchenDoor, r);
                                } else {
                                    kitchenDoor = scheduleSpecificDoor(door,kitchenDoor,r);
                                }
                                break;
                            case "garage":
                                if (!scheduleDoors) {
                                    garageDoor = controlDoor(door, garageDoor, r);
                                } else {
                                    garageDoor = scheduleSpecificDoor(door,garageDoor,r);
                                }
                                break;
                            case "backyard":
                                if (!scheduleDoors) {
                                    backyardDoor = controlDoor(door, backyardDoor, r);
                                } else {
                                    backyardDoor = scheduleSpecificDoor(door,backyardDoor,r);
                                }
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println(ROJO + "(!) Invalid option." + RESET);
                    }
                }
            } else {
                System.out.println(ROJO + "(!) Invalid door." + RESET);
            }
        }
    }

    public String controlDoor(String door, String currentState, String r) {
        if (r.equalsIgnoreCase("open")) {
            if (currentState.equalsIgnoreCase("opened")) {
                messageDoorAlreadyOnOff(door,currentState);
            } else if (currentState.equalsIgnoreCase("closed")) {
                currentState = "opened";
                messageDoorOpenClose(door, r);
            } else {
                currentState = doorLocked(door, currentState);
            }
        } else if (r.equalsIgnoreCase("close")) {
            if (currentState.equalsIgnoreCase("closed") || currentState.equalsIgnoreCase("locked")) {
                messageDoorAlreadyOnOff(door,currentState);
            } else {
                currentState = "closed";
                messageDoorOpenClose(door, r);
            }
        } else if (r.equalsIgnoreCase("lock") || r.equalsIgnoreCase("locked")) {
            if (currentState.equalsIgnoreCase("closed")) {
                currentState = "locked";
                messageDoorOpenClose(door, r);
            } else if (currentState.equalsIgnoreCase("locked")) {
                messageDoorAlreadyOnOff(door,currentState);
            } else {
                System.out.printf(AMARILLO + "Door %s is %s, please close it before locking it.\n" + RESET, door, currentState);
            }
        } else if (r.equalsIgnoreCase("unlock") || r.equalsIgnoreCase("closed")) {
            if (currentState.equalsIgnoreCase("locked")) {
                currentState = "closed";
                messageDoorOpenClose(door, r);
            } else {
                System.out.printf(AMARILLO + "Door %s isn't locked.\n" + RESET,door);
            }
        }
        return currentState;
    }

    public void controlAllDoors() {
        System.out.print("Manual - change state of doors: (open/close/lock/unlock) ");
        Boolean validOpt = false;
        do {
            r = s.next();
            if (r.equalsIgnoreCase("open") || r.equalsIgnoreCase("close")
                    || r.equalsIgnoreCase("lock") || r.equalsIgnoreCase("unlock")) {
                validOpt = true;

                if (r.equalsIgnoreCase("open")) {
                    mainDoor = "opened";
                    kitchenDoor = "opened";
                    backyardDoor = "opened";
                    garageDoor = "opened";
                    System.out.printf("All doors successfully turned %s\n\n", r);

                } else if (r.equalsIgnoreCase("close") || r.equalsIgnoreCase("unlock")) {
                    mainDoor = "closed";
                    kitchenDoor = "closed";
                    backyardDoor = "closed";
                    garageDoor = "closed";
                    System.out.printf("All doors successfully turned %s\n\n", r);

                } else if (r.equalsIgnoreCase("lock")) {
                    mainDoor = "locked";
                    kitchenDoor = "locked";
                    backyardDoor = "locked";
                    garageDoor = "locked";
                    System.out.printf("All doors successfully turned %s\n\n", r);

                } else {
                    System.out.println("(!) Invalid option.");
                }

            }
        } while (!validOpt);
    }

    public String doorLocked(String door, String currentState) {
        System.out.printf(AMARILLO + "The door %s is %s, do you wanna unlock it? (yes/no): " + RESET, door, currentState);
        Boolean validOpt = false;
        do {
            String r = s.next();
            if (r.equalsIgnoreCase("yes") || r.equalsIgnoreCase("no")) {
                validOpt = true;
                if (r.equalsIgnoreCase("yes")) {
                    currentState = "opened";
                    System.out.printf(VERDE + "(+) The door %s has been unlocked correctly\n" + RESET, door);
                }
            }
        } while (!validOpt);
        return currentState;
    }

    public void messageDoorOpenClose(String door, String r) {
        System.out.printf(VERDE + "Door - %s successfully turned %s\n\n" + RESET, door, r);
    }

    public void messageDoorAlreadyOnOff(String door, String r) {
        System.out.printf(AMARILLO + "Door - %s was already %s.\n\n" + RESET, door, r);
    }

    
}
