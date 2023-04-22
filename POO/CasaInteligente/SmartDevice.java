/**
 * A classe SmartDevice é um contactor simples.
 * Permite ligar ou desligar circuitos. 
 */
public class SmartDevice {

    private String id;
    private boolean on;

    /**
     * Constructor for objects of class SmartDevice
     */
    public SmartDevice() {
        this.id = "";
        this.on = false;
    }

    public SmartDevice(String s) {
        this.id = s;
        this.on = false;
    }

    public SmartDevice(String s, boolean b) {
        this.id = s;
        this.on = b;
    }

    public SmartDevice(SmartDevice s){
        this.id = s.getID();
        this.on = s.on;
    }

    public SmartDevice clone (){
        SmartDevice res = new SmartDevice();
        res.id = this.getID();
        res.on = this.getOn();
        return res;

    }

    public void turnOn() {
        this.on = true;
    }
    
    public void turnOff() {
        this.on = false;
    }
    
    public boolean getOn() {
        return this.on;
    }
    
    public void setOn(boolean b) {
        this.on = b;
    }
    
    public String getID() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if(obj==this) 
           return true;
        if(obj==null || obj.getClass() != this.getClass()) 
           return false;    
        SmartDevice temp = (SmartDevice) obj;
        return (temp.getID().equals(this.id)) &&
                temp.getOn() == this.on;
    }

}
