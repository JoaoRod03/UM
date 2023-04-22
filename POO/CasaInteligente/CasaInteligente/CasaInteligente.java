
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos 
 * espaços (as salas) que existem na casa.
 */
public class CasaInteligente {
   
    private String morada;
    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices

    /**
     * Constructor for objects of class CasaInteligente
     */
    public CasaInteligente() {
        this.morada = "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public CasaInteligente(String morada) {
        this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    
    public void setDeviceOn(String devCode) {
        this.devices.get(devCode).turnOn();
    }
    
    public boolean existsDevice(String id) {
        return this.devices.containsKey(id);
    }
    
    public void addDevice(SmartDevice s) {
        this.devices.put(s.getID(), s.clone());
    }
    
    public SmartDevice getDevice(String s) {
        return this.devices.get(s);
    }
     
    public void setOn(String s, boolean b) {
        this.devices.get(s).setOn(b);
    }
    
    public void setAllOn(boolean b) {
        for (String temp : this.devices.keySet()){
            this.devices.get(temp).setOn(b);
        }
    }
    
    public void addRoom(String s) {
        this.locations.put(s,new ArrayList<String>());
    }
    
    public boolean hasRoom(String s) {
        return this.locations.containsKey(s);
    }
    
    public void addToRoom (String s1, String s2) {
        this.locations.get(s1).add(s2);
    }
    
    public boolean roomHasDevice (String s1, String s2) {
        return this.locations.get(s1).contains(s2);
    }
    
}
