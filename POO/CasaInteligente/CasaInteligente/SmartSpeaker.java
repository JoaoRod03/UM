/**
 * Um SmartSpeaker é um SmartDevice que além de ligar e desligar permite também
 * reproduzir som.
 * Consegue ligar-se a um canal (por simplificação uma rádio online) e permite
 * a regulação do seu nível de volume.
 */
public class SmartSpeaker extends SmartDevice {
    public static final int MAX = 20; //volume máximo
    
    private int volume;
    private String channel;


    /**
     * Constructor for objects of class SmartSpeaker
     */
    public SmartSpeaker() {
        super();
        this.volume = 0;
        this.channel = "";
    }

    public SmartSpeaker(String s) {
        super(s);
        this.volume = 0;
        this.channel = "";
    }

    public SmartSpeaker(String cod, String channel, int i) {
        super(cod);
        this.volume = i;
        this.channel = channel;
    }

    public SmartSpeaker clone (){
        SmartSpeaker res = new SmartSpeaker();
        res.volume = this.getVolume();
        res.channel = this.getChannel();
        return res;
    }

    public void volumeUp() {
        if (this.volume<MAX) this.volume++;
    }

    public void volumeDown() {
        if (this.volume>0) this.volume--;
    }

    public int getVolume() {
        if(this.volume < 0) this.volume = 0;
        return this.volume;
    }
    
    public String getChannel() {
        return this.channel;
    }
    
    public void setChannel(String c) {
        this.channel = c;
    }

    public boolean equals(Object obj) {
        if(obj==this) 
           return true;
        if(obj==null || obj.getClass() != this.getClass()) 
           return false;    
        SmartSpeaker temp = (SmartSpeaker) obj;
        return temp.getVolume() == this.volume &&
               temp.getChannel().equals(this.channel);
    }

}
