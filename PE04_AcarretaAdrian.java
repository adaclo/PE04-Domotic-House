package Activitats.PE04;

import java.util.Scanner;

public class PE04_AcarretaAdrian {
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
    Boolean machineState=false; // Aquesta variabe la necessito declarar global perquè quan obri el menu de la rentadora faré una comprovació
    // Variables portes
    String mainDoor="closed";
    String kitchenDoor="closed";
    String garageDoor="closed";
    String backyardDoor="closed";
    Scanner s = new Scanner(System.in);

    public static void main(String[] args) { 
    PE04_AcarretaAdrian p = new PE04_AcarretaAdrian();
    p.principal();
    }

    public void principal() {
        do {
            System.out.println("\nDomotic house:\n");
            System.out.println("  a. Control temperature");
            System.out.println("  b. Control doors");
            System.out.println("  c. Control laundry machine");
            System.out.println("  d. Control lights");
            System.out.println("  e. Exit");
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
                    System.out.println("Closing menu...");
                    break;
            
                default:
                    break;
            }
            
        } while (!r.equalsIgnoreCase("e"));
       
    }
    
    // PRIMERA PART DE L'ACTIVITAT SENSE BUCLES
    public void controlLaundryMachine() { // Control·lar rentadora amb variables locals
        String program = null;
        do {
            System.out.println("\nLaundry machine control:\n");
            System.out.println("  a. Start a program");
            System.out.println("  b. Check status");
            if (machineState==true){
                System.out.println("  c. Cancel program");
            }
            System.out.println("  d. Go back");
            r = s.next();
            
            switch (r) {
                case "a":
                    Boolean validProgram=false;
                    if (machineState==true) {
                        System.out.println("Laundry machine is currently in a program.");
                    } else {
                        while (validProgram==false) {
                            System.out.println("Choose the program:");
                            r = s.next();
                            if (r.equalsIgnoreCase("eco") || r.equalsIgnoreCase("turbo") || r.equalsIgnoreCase("regular")) {
                                validProgram = true;
                                machineState=true;
                                program = r;
                                System.out.printf("Laundry program set to: %s", program);
                            } else {
                                System.out.println("\n(!) Invalid program.\n");
                                System.err.println("Valid programs:");
                                System.out.println("eco, turbo, regular\n");
                            }
                        }
                    }
                    
                    break;
                case "b":
                    System.out.printf("\nCurrent program is %s\n",program);
                    break;
                case "c":
                    if (program != null) {
                        program=null;
                        machineState=false;
                        System.out.println("Laundry program correctly canceled");
                    }
                    break;
                case "d":
                    
                    break;
            
                default:
                    break;
            }
        } while (!r.equalsIgnoreCase("d"));
    }

    public void controlLights() { // Control·lar llums amb variables globals
        do {
            System.out.println("\nLights control:\n");
            System.out.println("  a. Control a room");
            System.out.println("  b. Control all the rooms");
            System.out.println("  c. Show the real state of the lights");
            System.out.println("  d. Go back");
            r = s.next();
            switch (r) {
                case "a":
                    controlSpecificLight();
                    break;
                case "b":
                    validOpt=false;
                    while (validOpt==false) {
                        System.out.println("Manual - turn on or off: (on/off)");
                        r = s.next();
                        if (r.equalsIgnoreCase("on") || r.equalsIgnoreCase("off")) {
                            validOpt=true;
                            controlAllRooms(r);
                        } else {
                            System.out.println("\n(!) Invalid option.\n");
                        }
                    }
                    break;
                case "c":
                    showRooms();
                    break;
                case "d":
                    
                    break;
            
                default:
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
        if (r.equalsIgnoreCase("on")) {
            H1=true;
            H2=true;
            H3=true;
            bathroom=true;
            kitchen=true;
            living_room=true;
            System.out.printf("All rooms successfully turned lights %s\n\n",r);
        } else {
            H1=false;
            H2=false;
            H3=false;
            bathroom=false;
            kitchen=false;
            living_room=false;
            System.out.printf("All rooms successfully turned lights %s\n\n",r);
        }
    }
    public void messageLightOnOff(String h, String r) {
        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
    }

    public void messageLightAlreadyOnOff(String h, String r) {
        System.out.printf("Room - %s was already %s.\n\n",h,r);
    }

    public void showRooms() {
        if (H1) {
            System.out.println("\nRoom - H1 - On");
        } else {
            System.out.println("\nRoom - H1 - Off");
        }
        if (H2) {
            System.out.println("Room - H2 - On");
        } else {
            System.out.println("Room - H2 - Off");
        }
        if (H3) {
            System.out.println("Room - H3 - On");
        } else {
            System.out.println("Room - H3 - Off");
        }
        if (bathroom) {
            System.out.println("Room - Bathroom - On");
        } else {
            System.out.println("Room - Bathroom - Off");
        }
        if (kitchen) {
            System.out.println("Room - Kitchen - On");
        } else {
            System.out.println("Room - Kitchen - Off");
        }
        if (living_room) {
            System.out.println("Room - Living Room - On\n");
        } else {
            System.out.println("Room - Living Room - Off\n");
        }
    }
    public void controlDoors() {
        s.nextLine();
        Boolean panicMode=false;
        String passwordDoors=null;
        String resp=null;
        do {
            if (panicMode) {
                System.out.println("\nDoors control:\n");
                System.out.println("----------------");
                System.out.println("---PANIC MODE---");
                System.out.println("--IS ACTIVATED--");
                System.out.println("----------------");
                System.out.print("Introduce the password to unlock it: ");
                r = s.nextLine();
                if (r.equalsIgnoreCase(passwordDoors)) {
                    panicMode=false;
                    System.out.println("\nPanic mode turned off correctly.");
                } else {
                    System.out.println("\n(!) Incorrect password!");
                }
            } else {
                System.out.println("\nDoors control:\n");
                System.out.println("  a. Control a specific door");
                System.out.println("  b. Control all the doors");
                System.out.println("  c. Check all doors status");
                System.out.println("  d. Turn on PANIC MODE");
                System.out.println("  e. Go back");
                resp = s.next();
                switch (resp) {
                    case "a":
                        controlSpecificDoor();
                        break;
                    case "b":
                        controlAllDoors();
                        break;
                    case "c":
                        //checkDoorsStatus();
                        break;
                    case "d":
                        //turnOnPanic();
                        break;
                    default:
                        break;
                }
            }
        } while (!resp.equalsIgnoreCase("e"));
    }
    public void controlSpecificDoor() {
        Boolean validOpt=false;
        Boolean validDoor=false;
        while (validDoor==false) {
            System.out.print("Choose the door: ");
            String door = s.next();
            if (door.equalsIgnoreCase("main") || door.equalsIgnoreCase("kitchen") || door.equalsIgnoreCase("garage") || door.equalsIgnoreCase("backyard")) {
                validDoor = true;
                while (validOpt==false) {
                    System.out.print("Manual - change state of doors: (open/close/lock/unlock) ");
                    r = s.next();
                    if (r.equalsIgnoreCase("open") || r.equalsIgnoreCase("close") || r.equalsIgnoreCase("lock") || r.equalsIgnoreCase("unlock")) {
                        validOpt=true;
                        switch (door) {
                            case "main":
                                mainDoor=controlDoor(door, mainDoor, r);
                                break;
                            case "kitchen":
                                kitchenDoor=controlDoor(door, kitchenDoor, r);
                                break;
                            case "garage":
                                garageDoor=controlDoor(door, garageDoor, r);
                                break;
                            case "backyard":
                                backyardDoor=controlDoor(door, backyardDoor, r);
                                break;
                            default:
                                break;
                        }
                        
                    } else {
                        System.out.println("\n(!) Invalid option.\n");
                    }
                }
            } else {
                System.out.println("\n(!) Invalid door.\n");
                System.err.println("Valid doors:");
                System.out.println("Main, Kitchen, Garage, Backyard\n");
            }
        }
    }
    public String controlDoor(String door, String currentState, String r) {
        if (r.equalsIgnoreCase("open")) {
            if (currentState.equalsIgnoreCase("opened")) {
                messageDoorAlreadyOnOff(door, r);
            } else if (currentState.equalsIgnoreCase("closed")) {
                currentState = "opened";
                messageDoorOpenClose(door, r);
            } else {
                currentState = doorLocked(door,currentState);
            }
        } else if (r.equalsIgnoreCase("close")) {
            if (currentState.equalsIgnoreCase("closed") || currentState.equalsIgnoreCase("locked")) {
                messageDoorAlreadyOnOff(door, r);
            } else {
                currentState = "closed";
                messageDoorOpenClose(door, r);
            }
        } else if (r.equalsIgnoreCase("lock")) {
            if (currentState.equalsIgnoreCase("closed")) {
                currentState = "locked";
                messageDoorOpenClose(door,r);
            } else {
                System.out.printf("Door %s is %s, please close it before locking it.",door,currentState);
            }
        }
        return currentState;
    }

    public void controlAllDoors() {
        System.out.print("Manual - change state of doors: (open/close/lock/unlock) ");
        Boolean validOpt=false;
        do {
            r = s.next();
            if (r.equalsIgnoreCase("open") || r.equalsIgnoreCase("close") || r.equalsIgnoreCase("lock") || r.equalsIgnoreCase("unlock")) {
                validOpt=true;
                if (r.equalsIgnoreCase("open")) {
                    mainDoor="opened";
                    kitchenDoor="opened";
                    backyardDoor="opened";
                    garageDoor="opened";
                    System.out.printf("All doors successfully turned %s\n\n",r);
                } else if (r.equalsIgnoreCase("close") || r.equalsIgnoreCase("unlock")){
                    mainDoor="closed";
                    kitchenDoor="closed";
                    backyardDoor="closed";
                    garageDoor="closed";
                    System.out.printf("All doors successfully turned %s\n\n",r);
                } else if (r.equalsIgnoreCase("lock")){
                    mainDoor="locked";
                    kitchenDoor="locked";
                    backyardDoor="locked";
                    garageDoor="locked";
                    System.out.printf("All doors successfully turned %s\n\n",r);
                } else {
                    System.out.println("(!) Invalid option.");
                }
            }
        } while (!validOpt);
    }
    
    public String doorLocked(String door, String currentState) {
        System.out.printf("The door %s is %s, do you wanna unlock it? (yes/no) ",door,currentState);
        Boolean validOpt=false;
        do {
            String r = s.next();
            if (r.equalsIgnoreCase("yes") || r.equalsIgnoreCase("no")) {
                validOpt=true;
                if (r.equalsIgnoreCase("yes")) {
                    currentState="opened";
                    System.out.printf("(+) The door %s has been unlocked correctly",door);
                }
            }
        } while (!validOpt);
        return currentState;
    }

    public void messageDoorOpenClose(String door, String r) {
        System.out.printf("Door - %s successfully turned %s\n\n",door,r);
    }

    public void messageDoorAlreadyOnOff(String door, String r) {
        System.out.printf("Door - %s was already %s.\n\n",door,r);
    }
    public void controlSpecificLight() {
        validOpt=false;
        validRoom=false;
        while (validRoom==false) {
            System.out.println("Choose the room:");
            h = s.next();
            if (h.equalsIgnoreCase("H1") || h.equalsIgnoreCase("H2") || h.equalsIgnoreCase("H3") || h.equalsIgnoreCase("bathroom") || h.equalsIgnoreCase("kitchen") || h.equalsIgnoreCase("living_room")) {
                validRoom = true;
                while (validOpt==false) {
                    System.out.println("Manual - turn on or off: (on/off)");
                    r = s.next();
                    if (r.equalsIgnoreCase("on") || r.equalsIgnoreCase("off")) {
                        validOpt=true;
                        switch (h) {
                            case "H1":
                                H1=controlRoom(h,H1,r);
                                break;
                            case "H2":
                                H2=controlRoom(h,H2,r);
                                break;
                            case "H3":
                                H3=controlRoom(h,H3,r);
                                break;
                            case "bathroom":
                                bathroom=controlRoom(h,bathroom,r);
                                break;
                            case "kitchen":
                                kitchen=controlRoom(h,kitchen,r);
                                break;
                            case "living_room":
                                living_room=controlRoom(h,living_room,r);
                                break;
                            default:
                                break;
                        }
                        
                    } else {
                        System.out.println("\n(!) Invalid option.\n");
                    }
                }
            } else {
                System.out.println("\n(!) Invalid room.\n");
                System.err.println("Valid rooms:");
                System.out.println("H1, H2, H3, bathroom, kitchen, living_room\n");
            }
        }
    }
    
}
