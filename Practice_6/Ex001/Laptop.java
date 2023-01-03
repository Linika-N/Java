package Practice_6.Ex001;

public class Laptop {
    private int ram,ssdCapacity;
    private String model,osVersion,color;

    public Laptop(){
    }
    public Laptop(String model, int ram, int ssdCapacity, String osVersion, String color){
        this.model = model;
        this.ram = ram;
        this.ssdCapacity = ssdCapacity;
        this.osVersion = osVersion;
        this.color = color;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getSsdCapacity() {
        return ssdCapacity;
    }
    public void setSsdCapacity(int ssdCapacity) {
        this.ssdCapacity = ssdCapacity;
    }
    public String getOsVersion() {
        return osVersion;
    }
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return String.format(
            "Модель = %s, Оперативная память = %d, Объём жесткого диска = %d, Версия ОС = %s, Цвет = %s",
            model, ram, ssdCapacity, osVersion, color);
    }    
}
