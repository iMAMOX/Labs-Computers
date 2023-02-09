

package labcomputers;
//The Super Class
import java.util.ArrayList;

abstract class Device {
    //Data Members.
    protected String company;
    protected String device_code;

    public Device() {

    }
    //The Constructor Of Device Class.
    public Device(String company, String code) {
        this.company = company;
        this.device_code = code;
    }
//----------------------------------------------------------------------------------------------------------------
    //Setters & getters For The Data Members.
    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }

    public String getDevice_code() {
        return device_code;
    }
//----------------------------------------------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "Company :" + company;
    }

//----------------------------------------------------------------------------------------------------------------
    //The Methods Will Search For A Specific Object (Computer) Based On The Object (Computer) Code.
    public static Computer searchComputer(ArrayList<Device> All_devices, String computerCode) {

        for (Device computer : All_devices) {
            if (computer instanceof Computer && computer.getDevice_code().equalsIgnoreCase(computerCode)) {
                return (Computer) computer;
            }

        }
        return null;

    }

//----------------------------------------------------------------------------------------------------------------
    //The Methods Will Search For A Specific Object (Software) Based On The Object (Software) Code.
    public static Software searchSoftware(ArrayList<Device> All_devices, String softwareCode) {

        for (Device software : All_devices) {
            if (software instanceof Software && software.getDevice_code().equalsIgnoreCase(softwareCode)) {
                return (Software) software;
            }

        }
        return null;

    }
//----------------------------------------------------------------------------------------------------------------
    //The Methods Will Search For A Specific Object (Mouse) Based On The Object (Mouse) Code.
    public static Mouse searchMouse(ArrayList<Device> All_devices, String mouseCode) {

        for (Device mouse : All_devices) {
            if (mouse instanceof Mouse && mouse.getDevice_code().equalsIgnoreCase(mouseCode)) {
                return (Mouse) mouse;
            }

        }
        return null;

    }
//----------------------------------------------------------------------------------------------------------------
    //The Methods Will Search For A Specific Object (Printer) Based On The Object (Printer) Code.
    public static Printer searchPrinter(ArrayList<Device> All_devices, String printerCode) {

        for (Device printer : All_devices) {
            if (printer instanceof Printer && printer.getDevice_code().equalsIgnoreCase(printerCode)) {
                return (Printer) printer;
            }

        }
        return null;

    }
//----------------------------------------------------------------------------------------------------------------
    //The Methods Will Check If A Specific Object (Software) Exists In The Software ArrayList.
    //Return False if Exists, True When Not.
    public static boolean Installed(ArrayList<Software> software, String foftwareCode) {

        for (int i = 0; i < software.size(); i++) {
            if (software.get(i).getDevice_code().equalsIgnoreCase(foftwareCode)) {

                return false;

            }

        }

        return true;
    }
//----------------------------------------------------------------------------------------------------------------
}
