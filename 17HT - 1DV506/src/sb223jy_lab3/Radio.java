package sb223jy_lab3;

public class Radio {
    private boolean isOn;
    private int volume;
    private int channel;

    public Radio() {
        defaultSettings();
    }

    private void defaultSettings() {
        isOn = false;
        volume = 1;
        channel = 1;
    }

    public String getSettings() {
        return "Settings: On " + isOn + ", Channel " + channel + ", Volume " + volume;
    }

    public void turnOn() {

    }

    public void turnOff() {
        defaultSettings();
    }

    public void setChannel() {

    }

    public void channelUp() {

    }

    public void channelDown() {

    }

    public void setVolume() {

    }

    public void volumeUp() {

    }

    public void volumeDown() {

    }
}
