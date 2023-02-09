/*
Name : MESHAL ALI OKAIRY
ID : 2237836
Section : F1
*/
package labcomputers;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Computer extends Device implements Comparable {
    //Data Members.
    private double speed;
    private String modelName;
    ArrayList<Software> software = new ArrayList<>();
    Mouse mouse;
    Printer printer;
    private int totalSoftware;
    
    //The Constructor Of Computer Class.
    public Computer(String company, double speed, String modelName, String code) {
        super(company, code);
        this.speed = speed;
        this.modelName = modelName;
    }
//----------------------------------------------------------------------------    
    //Setters & getters For The Data Members.
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }


    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setSoftware(Software software) {
        this.software.add(software);
        totalSoftware++;
    }

    public ArrayList<Software> getSoftware() {
        return software;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public Printer getPrinter() {
        return printer;
    }

    public int getTotalSoftware() {
        return totalSoftware;
    }

//----------------------------------------------------------------------------
    @Override
    public String toString() {

        return "\nComputer Details \n" + super.toString() + "  Model: " + modelName + "  Speed: " + speed
                + " GHz ";
    }

//----------------------------------------------------------------------------
    //The Method Will Compare The Speed Of Two Computers.
    //Return 1 If the First Computer Is Faster,
    //2 If the Second Computer Is Faster and 0 If Both Have the Same Speed.
    @Override
    public int CompareTo(Computer CurrentComputer) {
        if (this.speed > CurrentComputer.speed) {
            return 1;
        } else if (this.speed < CurrentComputer.speed) {
            return 2;
        } else {
            return 0;
        }
    }
//----------------------------------------------------------------------------
    //The Method Will Check Whether The Computer Has Installed Software.
    //If There Is Any Software Installed In The Computer The Program Will Execute The If Statement, 
    //Otherwise The Program Will Execute The Else Statement.
    public void printSoftware(PrintWriter pw2) {
        if (software == null || software.isEmpty()) {
            pw2.println(" No Software has been installed");
        } else {
            for (int i = 0; i < software.size(); i++) {
                pw2.println(software.get(i).toString() + "\n");
            }
        }

    }
//----------------------------------------------------------------------------
    //The method will check whether the computer has a specific software installed.
    //if the software is installed the program will start printing the details of each computer that contains the software.
    public void printWith(String SW, Computer CurrantComputer, PrintWriter pw2, int i) {

        for (Software Currantsoftware : CurrantComputer.software) {
            if (Currantsoftware.getName().equalsIgnoreCase(SW)) {
                pw2.println("---------Computer No " + (i + 1) + " ---------\n");
                pw2.println("The computer  Company : " + CurrantComputer.company + "  Model: " + CurrantComputer.modelName + "\n");
            }
        }

    }
//----------------------------------------------------------------------------
    //The method will check the speed of each computer.
    //if the computer speed is higher than the given speed,
    //the program will start printing the details of the computer.

    public void printSpeed(int speed, Computer CurrantComputer, PrintWriter pw2, int i) {
        if (CurrantComputer.speed > speed) {
            pw2.println("---------Computer No " + (i + 1) + " ---------\n");
            pw2.println("The computer  Company : " + CurrantComputer.company + "  Model: " + CurrantComputer.modelName + "\n");

        }

    }
//----------------------------------------------------------------------------    
    //The method will check each computer peripheral.
    //if the computer has either a mouse or a printer,
    //the program will start printing the details of the computer's peripherals.
    public void printPeripheral(PrintWriter pw2) {
        if (!(mouse == null)) {
            pw2.println(mouse.toString() + "\n");
        }

        if (!(printer == null)) {
            pw2.println(printer.toString());
        }

        if (printer == null && mouse == null) {
            pw2.print(" No Pripheral has been attached");
        }

    }

}
