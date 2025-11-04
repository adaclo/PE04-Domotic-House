package Activitats.PE04;

import java.util.Scanner;

public class PE04_AcarretaAdrian {
    // COLORS
    final String RESET = "\u001B[0m";
    final String ROJO = "\u001B[31m";
    final String VERDE = "\u001B[32m";
    final String AMARILLO = "\u001B[33m";
    final String AZUL = "\u001B[34m";

    String passwordDoors = null;
    Boolean panicMode = false;
    Boolean H1 = false;
    Boolean H2 = false;
    Boolean H3 = false;
    Boolean bathroom = false;
    Boolean kitchen = false;
    Boolean living_room = false;
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
        System.out.printf("Room - H1 - %s\n", H1 ? VERDE + "On" + RESET : ROJO + "Off" + RESET);
        System.out.printf("Room - H2 - %s\n", H2 ? VERDE + "On" + RESET : ROJO + "Off" + RESET);
        System.out.printf("Room - H3 - %s\n", H3 ? VERDE + "On" + RESET : ROJO + "Off" + RESET);
        System.out.printf("Room - Bathroom - %s\n", bathroom ? VERDE + "On" + RESET : ROJO + "Off" + RESET);
        System.out.printf("Room - Kitchen - %s\n", kitchen ? VERDE + "On" + RESET : ROJO + "Off" + RESET);
        System.out.printf("Room - Living Room - %s\n\n", living_room ? VERDE + "On" + RESET : ROJO + "Off" + RESET);
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
                            case "H1": H1 = controlRoom(h, H1, r); break;
                            case "H2": H2 = controlRoom(h, H2, r); break;
                            case "H3": H3 = controlRoom(h, H3, r); break;
                            case "bathroom": bathroom = controlRoom(h, bathroom, r); break;
                            case "kitchen": kitchen = controlRoom(h, kitchen, r); break;
                            case "living_room": living_room = controlRoom(h, living_room, r); break;
                            default: break;
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
                System.out.println("  e. Go back");
                System.out.print(AMARILLO + "Choose: " + RESET);
                resp = s.next();

                switch (resp) {
                    case "a":
                        controlSpecificDoor();
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
                    default:
                        break;
                }
            }
        } while (!resp.equalsIgnoreCase("e"));
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

    public void controlSpecificDoor() {
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
                                mainDoor = controlDoor(door, mainDoor, r);
                                break;
                            case "kitchen":
                                kitchenDoor = controlDoor(door, kitchenDoor, r);
                                break;
                            case "garage":
                                garageDoor = controlDoor(door, garageDoor, r);
                                break;
                            case "backyard":
                                backyardDoor = controlDoor(door, backyardDoor, r);
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
        } else if (r.equalsIgnoreCase("lock")) {
            if (currentState.equalsIgnoreCase("closed")) {
                currentState = "locked";
                messageDoorOpenClose(door, r);
            } else if (currentState.equalsIgnoreCase("locked")) {
                messageDoorAlreadyOnOff(door,currentState);
            } else {
                System.out.printf(AMARILLO + "Door %s is %s, please close it before locking it.\n" + RESET, door, currentState);
            }
        } else if (r.equalsIgnoreCase("unlock")) {
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
        System.out.print(AMARILLO + "Manual - change state (open/close/lock/unlock): " + RESET);
        Boolean validOpt = false;
        do {
            r = s.next();
            if (r.equalsIgnoreCase("open") || r.equalsIgnoreCase("close")
                    || r.equalsIgnoreCase("lock") || r.equalsIgnoreCase("unlock")) {
                validOpt = true;
                mainDoor = kitchenDoor = garageDoor = backyardDoor =
                        (r.equalsIgnoreCase("open")) ? "opened" :
                        (r.equalsIgnoreCase("lock")) ? "locked" : "closed";
                System.out.printf(VERDE + "All doors successfully turned %s\n\n" + RESET, r);
            } else {
                System.out.println(ROJO + "(!) Invalid option." + RESET);
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
