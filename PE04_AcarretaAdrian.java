package Activitats.PE04;

import java.util.Scanner;

public class PE04_AcarretaAdrian {
    static Boolean H1 = false;
    static Boolean H2;
    static Boolean H3;
    static Boolean bathroom;
    static Boolean kitchen;
    static Boolean livingRoom;
    static String r;
    static String h;
    static Boolean menu = true;
    static Boolean validRoom = false;
    static Boolean validOpt = false;
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (menu) {
            System.out.println("Lights control:\n");
            System.out.println("  a. Control a room");
            System.out.println("  b. Control all the rooms");
            System.out.println("  c. Show the real state of the lights");
            System.out.println("  d. Exit");
            r = s.next();
            switch (r) {
                case "a":
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
                    //controlAllRooms();
                    break;
                case "c":
                    //showRooms();
                    break;
                case "d":
                    menu = false;
                    break;
            
                default:
                    break;
            }
        }
    }
    public static void controlRoom(String h, String r) {
        switch (h) {
            case "H1":
                if (r.equals("on")) {
                    if (H1==true) {
                        System.out.printf("Room - %s was already on.\n\n",h);
                    } else {
                        H1 = true;
                        System.out.printf("Room - %s successfully turned %s\n\n",h,r);
                    }
                }
                break;
            case "H2":
                
                break;
            case "H3":
                
                break;
            case "bathroom":
                
                break;
            case "kitchen":
                
                break;
            case "living_room":
                
                break;
        
            default:

                break;
        }
        validOpt = false;
        validRoom = false;
    }
}
