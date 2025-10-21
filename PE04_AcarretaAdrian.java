package Activitats.PE04;

import java.util.Scanner;

public class PE04_AcarretaAdrian {
    static Boolean H1 = false;
    static Boolean H2 = false;
    static Boolean H3 = false;
    static Boolean bathroom = false;
    static Boolean kitchen = false;
    static Boolean living_room = false;
    static String r;
    static String h;
    static Boolean lightsMenu = true;
    static Boolean validRoom = false;
    static Boolean validOpt = false;
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) { 
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
    public static void controlLights() { // Control·lar llums amb variables globals
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
                                    controlRoom(h,r);
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
    public static void controlRoom(String h, String r) {
        switch (h) {
            case "H1":
                if (r.equals("on")) {
                    if (H1==true) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        H1 = true;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                } else {
                    if (H1==false) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        H1 = false;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                }
                break;
            case "H2":
                if (r.equals("on")) {
                    if (H2==true) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        H2 = true;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                } else {
                    if (H2==false) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        H2 = false;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                }
                break;
            case "H3":
                if (r.equals("on")) {
                    if (H3==true) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        H3 = true;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                } else {
                    if (H3==false) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        H3 = false;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                }
                break;
            case "bathroom":
                if (r.equals("on")) {
                    if (bathroom==true) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        bathroom = true;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                } else {
                    if (bathroom==false) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        bathroom = false;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                }
                break;
            case "kitchen":
                if (r.equals("on")) {
                    if (kitchen==true) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        kitchen = true;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                } else {
                    if (kitchen==false) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        kitchen = false;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                }
                break;
            case "living_room":
                if (r.equals("on")) {
                    if (living_room==true) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        living_room = true;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                } else {
                    if (living_room==false) {
                        System.out.printf("Room - %s was already %s.\n\n",h,r);
                    } else {
                        living_room = false;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                }
                break;
        
            default:

                break;
        }
    }
    public static void controlAllRooms(String r) {
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
    public static void showRooms() {
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
