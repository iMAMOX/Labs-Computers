package labcomputers;

/*
Name : MESHAL ALI OKAIRY
ID : 2237836
Section : F1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class LabComputers {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("fcitInput.txt");
        Scanner in = new Scanner(file);
        PrintWriter pw1 = new PrintWriter("fcitOutPutLab.txt");
        PrintWriter pw2 = new PrintWriter("fcitReportLab.txt");
        File OutPut = new File("fcitOutPutLab.txt");
        File Report = new File("fcitReportLab.txt");
        ArrayList<Device> All_devices = new ArrayList<>();
        SimpleDateFormat time = new SimpleDateFormat("E MMM dd HH:mm:ss z YYYY");
        time.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        
        
        if (!file.exists()) {//check if the input file (fcitInput.txt) exists or not.
            System.out.println("The \"fcit Input\" File Is Missing !!\nCheck The Files And Try Again (:");
            System.exit(0);
        }
        pw1.println("Welcome to the FCIT Lab  System.\nToday Date is " + time.format(new Date()));
        
        String commandName = in.next();// Start reading the commands.

        do { //begin the loop of commands and enter the correct method depending on the command.

            if (commandName.equalsIgnoreCase("Add_Computer")) {
                pw1.println("\n*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                Add_Computer(All_devices, in, pw1);
            }

            if (commandName.equalsIgnoreCase("Add_Printer")) {
                pw1.println("\n*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                Add_Printer(All_devices, in, pw1);
            }

            if (commandName.equalsIgnoreCase("Add_Mouse")) {
                pw1.println("\n*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                Add_Mouse(All_devices, in, pw1);
            }

            if (commandName.equalsIgnoreCase("Add_Software")) {
                pw1.println("\n*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                Add_Software(All_devices, in, pw1);
            }

            if (commandName.equalsIgnoreCase("Install_SW")) {
                pw1.println("\n*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                Install_SW(All_devices, in, pw1);
            }

            if (commandName.equalsIgnoreCase("Install_printer")) {
                pw1.println("\n*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                Install_printer(All_devices, in, pw1);
            }

            if (commandName.equalsIgnoreCase("Install_mouse")) {
                pw1.println("\n*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                Install_mouse(All_devices, in, pw1);
            }

            if (commandName.equalsIgnoreCase("UnInstall_SW")) {
                pw1.println("\n*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                UnInstall_SW(All_devices, in, pw1);

            }

            if (commandName.equalsIgnoreCase("List_All_Computer_Configuration")) {
                pw2.println("*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                All_Computer(All_devices, in, pw2);
            }

            if (commandName.equalsIgnoreCase("List_Computer_With_SW")) {
                pw2.print("*************************************************"
                        + "*************************************************************\nCommand: List_Computer_With_");
                computerWith_SW(All_devices, in, pw2);
            }

            if (commandName.equalsIgnoreCase("List_Computer_Speed_>")) {
                pw2.print("*************************************************"
                        + "*************************************************************\nCommand: List_Computer_With_Speed_above_");
                computerSpeed(All_devices, in, pw2);
            }

            if (commandName.equalsIgnoreCase("Compare_Computer_Speed")) {
                pw2.println("*************************************************"
                        + "*************************************************************\nCommand: " + commandName + "\n");
                CompareSpeed(All_devices, in, pw2);
            }

            commandName = in.next();

        } while (!commandName.equalsIgnoreCase("Quit"));//the end of the loop if the command is "Quit".
        
        
        //close both files that the program did write it.
        pw1.close();
        pw2.close();
        
        //print a message to the user that the program finishes executing.
        System.out.println("Done :)\n\n# Go To \""+OutPut.getAbsolutePath()+"\" For The ("+OutPut.getName()
        +")\n# Go To \""+Report.getAbsolutePath()+"\" For The ("+Report.getName()+")");
    }//main
//----------------------------------------------------------------------------------------------------------------
    //the method will add the computer to the device ArrayList.
    public static void Add_Computer(ArrayList<Device> All_devices, Scanner in, PrintWriter pw1) {
        
        //create computer objects and use polymorphism.
        Device device = new Computer(in.next(), in.nextDouble(), in.next(), in.next());
        //add the object to the array.
        All_devices.add(device);
        //print the details of the object.
        pw1.println(device);
        pw1.println("-- Following Softwares are Installed in the Machine ---");
        //check if the computer has software/s and execute if statements if there are any.
        if (((Computer) device).software.isEmpty()) {
            pw1.println(" No Software has been installed");
        }
        pw1.println("--- Following  Peripheral are  attached in the Machine ---");
        
        //check if the computer has a mouse or printer, and execute if statements if there are any.
        if (((Computer) device).getMouse() == null && ((Computer) device).getPrinter() == null) {
            pw1.println(" No Pripheral has been attached\n");
        }

        pw1.println(" has been added to the FCIT Lab. Database.");

    }
//----------------------------------------------------------------------------------------------------------------
    //the method will add the printer to the device ArrayList.
    public static void Add_Printer(ArrayList<Device> All_devices, Scanner in, PrintWriter pw1) {
        //create computer objects and use polymorphism.
        Device device = new Printer(in.next(), in.next(), in.nextBoolean(), in.next());
        //add the object to the array.
        All_devices.add(device);
        //print the details of the object.
        pw1.println(device);
        
        pw1.println("\n has been added to the FCIT Lab. Database.");
    }
//----------------------------------------------------------------------------------------------------------------
    //the method will add the mouse to the device ArrayList.
    public static void Add_Mouse(ArrayList<Device> All_devices, Scanner in, PrintWriter pw1) {
        //create computer objects and use polymorphism.
        Device device = new Mouse(in.next(), in.next(), in.next());
        //add the object to the array.
        All_devices.add(device);
        //print the details of the object.
        pw1.println(device);
        
        pw1.println("\n has been added to the FCIT Lab. Database.");

    }
//----------------------------------------------------------------------------------------------------------------
    //the method will add the printer to the device ArrayList.
    public static void Add_Software(ArrayList<Device> All_devices, Scanner in, PrintWriter pw1) {
        //create software objects and use polymorphism.
        Device device = new Software(in.next(), in.nextDouble(), in.next());
        //add the object to the array.
        All_devices.add(device);
        //print the details of the object.
        pw1.println(device);
        
        pw1.println("\n has been added to the FCIT Lab. Database.");
    }
//----------------------------------------------------------------------------------------------------------------
    //the method will add specific software to the software ArrayList.
    public static void Install_SW(ArrayList<Device> All_devices, Scanner in, PrintWriter pw1) {
        String computerCode = in.next();//read the computer code.
        String softwareCode = in.next();//read the software code.
        
        //create a Computer object and give it the return object from the searchComputer method.
        Computer CurrentComputer = Device.searchComputer(All_devices, computerCode);
        
        //create a Software object and give it the return object from the searchSoftware method.
        Software CurrentSoftware = Device.searchSoftware(All_devices, softwareCode);
        
        //check if the wanted software is installed or not.
        Boolean installed = Device.Installed(CurrentComputer.getSoftware(), softwareCode);

        //check if the computer doesn't has more the 5 software.
        if (CurrentComputer.getTotalSoftware() < 5) {
            
            //check if the software is not already installed.
            if (installed) {
                CurrentComputer.setSoftware(CurrentSoftware);
                pw1.print("The S/W " + CurrentSoftware.getName() + "  has been installed in the The computer  Company : "
                        + CurrentComputer.getCompany() + "  Model: " + CurrentComputer.getModelName());

            } else {
                pw1.print("The computer  Company : "
                        + CurrentComputer.getCompany() + "  Model: " + CurrentComputer.getModelName() + "\nhas already S/W "
                        + CurrentSoftware.getName() + "  installed..");
            }

        } else {
            pw1.print("The computer  Company : "
                    + CurrentComputer.getCompany() + "  Model: " + CurrentComputer.getModelName() + "\nhas 5 S/W installed.. You can not install any S/W");

        }

    }

//----------------------------------------------------------------------------------------------------------------
    //the method will remove specific software from the software ArrayList.
    private static void UnInstall_SW(ArrayList<Device> All_devices, Scanner in, PrintWriter pw1) {

        String computerCode = in.next();//read the computer code.
        String softwareCode = in.next();//read the software code.

        //create a Computer object and give it the return object from the searchComputer method.
        Computer CurrentComputer = Device.searchComputer(All_devices, computerCode);
        
        //create a Software object and give it the return object from the searchSoftware method.
        Software CurrentSoftware = Device.searchSoftware(All_devices, softwareCode);
        
        //check if the wanted software is installed or not.
        Boolean installed = Device.Installed(CurrentComputer.getSoftware(), softwareCode);
        

        //check if the software is not already installed or if there is no any software,
        //the if will be execute.
        if (installed || CurrentComputer.software.isEmpty()) {
            pw1.print("The Software : " + CurrentSoftware.getCompany() + "  is not installed "
                    + "\nin The computer  Company : " + CurrentComputer.getCompany()
                    + "  Model: " + CurrentComputer.getModelName());
        } else {
            CurrentComputer.software.remove(CurrentSoftware);
            pw1.print("The S/W " + CurrentSoftware.getCompany()
                    + "  has been uninstalled from the The computer  Company : "
                    + CurrentComputer.getCompany() + "  Model: " + CurrentComputer.getModelName());
        }

    }
//----------------------------------------------------------------------------------------------------------------    

    public static void Install_printer(ArrayList<Device> All_devices, Scanner in, PrintWriter pw1) {

        String computerCode = in.next();//read the computer code.
        String printerCode = in.next();//read the printer code.
        
        //create a Computer object and give it the return object from the searchComputer method.
        Computer CurrentComputer = Device.searchComputer(All_devices, computerCode);
        
        //create a Printer object and give it the return object from the searchPrinter method.
        Printer CurrentPrinter = Device.searchPrinter(All_devices, printerCode);
        
        
        //check if the computer does not have a printer,
        //the program will add the print to the computer,
        //otherwise the program will NOT add the print to the computer.
        if (CurrentComputer.getPrinter() == null || !(CurrentComputer.getPrinter().getDevice_code().equals(CurrentPrinter.getDevice_code()))) {
            CurrentComputer.setPrinter(CurrentPrinter);
            pw1.print("The Printer " + CurrentPrinter.getCompany() + "  Printer Type :" + CurrentPrinter.getType()
                    + "  has been attached to the The computer  Company : " + CurrentComputer.getCompany()
                    + "  Model: " + CurrentComputer.getModelName());

        } else {
            pw1.print("The computer  Company : " + CurrentComputer.getCompany()
                    + "  Model: " + CurrentComputer.getModelName()
                    + "\nhas already attached to Printer " + CurrentComputer.getPrinter().getCompany()
                    + "  Printer Type :" + CurrentComputer.getPrinter().getType());

        }

    }

//----------------------------------------------------------------------------------------------------------------
    public static void Install_mouse(ArrayList<Device> All_devices, Scanner in, PrintWriter pw1) {

        String computerCode = in.next();//read the computer code.
        String mouseCode = in.next();//read the mouse code.
        
        //create a Computer object and give it the return object from the searchComputer method.
        Computer CurrentComputer = Device.searchComputer(All_devices, computerCode);
        
        //create a Mouse object and give it the return object from the searchMouse method.
        Mouse CurrentMouse = Device.searchMouse(All_devices, mouseCode);
        
        //check if the computer does not have a mouse,
        //the program will add the mouse to the computer,
        //otherwise the program will NOT add the mouse to the computer.
        if (CurrentComputer.getMouse() == null || !(CurrentComputer.getMouse().getDevice_code().equals(CurrentMouse.getDevice_code()))) {
            CurrentComputer.setMouse(CurrentMouse);
            pw1.print("The Mouse " + CurrentMouse.getCompany() + "  " + CurrentMouse.getType()
                    + "  has been attached to the The computer  Company : " + CurrentComputer.getCompany()
                    + "  Model: " + CurrentComputer.getModelName());

        } else {
            pw1.print("The computer  Company : " + CurrentComputer.getCompany()
                    + "  Model: " + CurrentComputer.getModelName()
                    + "\nhas already attached to Mouse " + CurrentComputer.getMouse().getCompany()
                    + "  " + CurrentComputer.getMouse().getType());

        }

    }

//----------------------------------------------------------------------------------------------------------------
    public static void All_Computer(ArrayList<Device> All_devices, Scanner in, PrintWriter pw2) {
        // the method will print each computer in the device array,
        //and if the computer has software/s the program will print it also,
        //and if the computer has a mouse or printer the program will print it also.
        for (int i = 0; i < All_devices.size(); i++) {
            if (All_devices.get(i) instanceof Computer) {
                Computer CurrentComputer = (Computer) All_devices.get(i);
                pw2.println("---------Computer No " + (i + 1) + " ---------\n");
                pw2.println(CurrentComputer);
                pw2.println("-- Following Softwares are Installed in the Machine ---");
                CurrentComputer.printSoftware(pw2);
                pw2.println("--- Following  Peripheral are  attached in the Machine ---");
                CurrentComputer.printPeripheral(pw2);
                pw2.println("\n\n");

            }

        }

    }

//----------------------------------------------------------------------------------------------------------------
    public static void computerWith_SW(ArrayList<Device> All_devices, Scanner in, PrintWriter pw2) {
        String SW = in.next();//read the software code.
        pw2.println(SW + "\n");
        
        //the method will check if the computer has a specific software,
        //then the computer details will be printed
        for (int i = 0; i < All_devices.size(); i++) {
            if (All_devices.get(i) instanceof Computer) {

                Computer CurrentComputer = (Computer) All_devices.get(i);
                CurrentComputer.printWith(SW, CurrentComputer, pw2, i);

            }

        }
    }
//----------------------------------------------------------------------------------------------------------------
    
    
    public static void computerSpeed(ArrayList<Device> All_devices, Scanner in, PrintWriter pw2) {
        //the method will print every computer that has a speed of more than a given number
        int speed = in.nextInt();
        pw2.println(speed + "\n");
        for (int i = 0; i < All_devices.size(); i++) {
            if (All_devices.get(i) instanceof Computer) {
                Computer CurrentComputer = (Computer) All_devices.get(i);
                CurrentComputer.printSpeed(speed, CurrentComputer, pw2, i);

            }
        }

    }
//----------------------------------------------------------------------------------------------------------------
    
    
    public static void CompareSpeed(ArrayList<Device> All_devices, Scanner in, PrintWriter pw2) {
        //the method will take two computers from the user and will compare the speed using the interface,
        //then the program will print appropriate message
        String firstCode = in.next();
        String secondCode = in.next();

        Computer firstComputer = Device.searchComputer(All_devices, firstCode);
        Computer secondComputer = Device.searchComputer(All_devices, secondCode);

        int value = firstComputer.CompareTo(secondComputer);

        switch (value) {
            case 1:
                pw2.println("(" + firstComputer.getCompany() + " , " + firstComputer.getModelName() + "," + firstComputer.getSpeed() + ")"
                        + " ****** Faster**** than (" + secondComputer.getCompany() + " , " + secondComputer.getModelName() + "," + secondComputer.getSpeed() + ")\n");
                break;
            case 2:
                pw2.println("(" + secondComputer.getCompany() + " , " + secondComputer.getModelName() + "," + secondComputer.getSpeed() + ")"
                        + " ****** Faster**** than (" + firstComputer.getCompany() + " , " + firstComputer.getModelName() + "," + firstComputer.getSpeed() + ")\n");
                break;
            case 0:
                pw2.println("(" + secondComputer.getCompany() + " , " + secondComputer.getModelName() + "," + secondComputer.getSpeed() + ")"
                        + " ****** Equal****  (" + firstComputer.getCompany() + " , " + firstComputer.getModelName() + "," + firstComputer.getSpeed() + ")\n");
                break;
        }

    }
//----------------------------------------------------------------------------------------------------------------

}
