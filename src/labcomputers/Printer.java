
package labcomputers;
public class Printer extends Device {
    //Data Members.
    private String type;
    private boolean isColor;
    
    //The Constructor Of Printer Class.
    public Printer(String company, String type, boolean isColor, String code) {
        super(company, code);
        this.type = type;
        this.isColor = isColor;
    }
    //----------------------------------------------------------------------------
        //Setters & getters For The Data Members.
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setIsColor(boolean isColor) {
        this.isColor = isColor;
    }

    public String isIsColor() {
        if (isColor)
            return "Colored";
        else
            return "Black&white";
    }
    
//----------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "\nPrinter Details \n \n"+super.toString()+" Color Type: "+ isIsColor()+"  Printer Type :"+type;
    }

}
