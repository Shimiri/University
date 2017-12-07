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
        isOn = true;
    }

    public void turnOff() {
        defaultSettings();
    }

    public boolean checkState() {
        if (isOn)
            return true;
        else {
            System.out.println("Radio off ==> No adjustment possible");
            return false;
        }
    }

    public void setChannel(int channel) {
        if (checkState())
            if (channel >= 1 && channel <= 10)
                this.channel = channel;
            else
                System.out.println("New channel not within range.");
    }

    public void channelUp() {
        if (checkState())
            if (channel < 10)
                channel++;
            else
                System.out.println("New channel not within range.");
    }

    public void channelDown() {
        if (checkState())
            if (channel > 1)
                channel--;
            else
                System.out.println("New channel not within range.");
    }

    public void setVolume(int volume) {
        if (checkState())
            if (volume >= 0 && volume <= 5)
                this.volume = volume;
            else
                System.out.println("New volume not within range.");
    }

    public void volumeUp() {
        if (checkState())
            if (volume < 5)
                volume++;
            else
                System.out.println("New volume not within range.");
    }

    public void volumeDown() {
        if (checkState())
            if (volume > 0)
                volume--;
            else
                System.out.println("New volume not within range.");
    }
}
