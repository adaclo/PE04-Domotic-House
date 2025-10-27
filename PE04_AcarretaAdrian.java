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
    Scanner s = new Scanner(System.in);

    public static void main(String[] args) { 
    PE04_AcarretaAdrian p = new PE04_AcarretaAdrian();
    p.principal();
    }

    public void principal() {
        do {
            System.out.println("Domotic house:\n");
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
            
        } while (!r.equals("e"));
        s.close();
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
                            if (r.equals("eco") || r.equals("turbo") || r.equals("regular")) {
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
                    System.err.println("Closing menu...");
                    break;
            
                default:
                    break;
            }
        } while (!r.equals("d"));
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
                    validOpt=false;
                    validRoom=false;
                    while (validRoom==false) {
                        System.out.println("Choose the room:");
                        h = s.next();
                        if (h.equals("H1") || h.equals("H2") || h.equals("H3") || h.equals("bathroom") || h.equals("kitchen") || h.equals("living_room")) {
                            validRoom = true;
                            while (validOpt==false) {
                                System.out.println("Manual - turn on or off: (on/off)");
                                r = s.next();
                                if (r.equals("on") || r.equals("off")) {
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
                    break;
                case "b":
                    validOpt=false;
                    while (validOpt==false) {
                        System.out.println("Manual - turn on or off: (on/off)");
                        r = s.next();
                        if (r.equals("on") || r.equals("off")) {
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
                    System.err.println("Closing menu...");
                    break;
            
                default:
                    break;
            }
        } while (!r.equals("d"));
    }
    public boolean controlRoom(String h, Boolean currentState, String r) {
        if (r.equals("on")) {
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
        if (r.equals("on")) {
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
}
