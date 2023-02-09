/*
Name : MESHAL ALI OKAIRY
ID : 2237836
Section : F1
*/
package labcomputers;
public class Software extends Device {
    //Data Members.
    private String name;
    private double version;
    
    //The Constructor Of Software Class.
    public Software(String name, double version, String code) {
        super(name, code);
        this.name = name;
        this.version = version;
    }
    
//----------------------------------------------------------------------------
    //Setters & getters For The Data Members.

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public double getVersion() {
        return version;
    }
    
//----------------------------------------------------------------------------
    
    @Override
    public String toString() {

        return "\nSoftware Details \n\nS/W name: " + name + " S/W version: " + version;
    }

}
