/*
Name : MESHAL ALI OKAIRY
ID : 2237836
Section : F1
*/
package labcomputers;
public class Mouse extends Device {
    //Data Members.
    private String type;
    
    //The Constructor Of Mouse Class.
    public Mouse(String company, String type, String code) {
        super(company, code);
        this.type = type;
    }
    
//----------------------------------------------------------------------------
    //Setters & getters For The Data Members.

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
//----------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\nMouse Details \n\n"+super.toString()+" Mouse Type: "+ type;
    }

}
