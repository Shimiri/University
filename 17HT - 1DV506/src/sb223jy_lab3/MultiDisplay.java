package sb223jy_lab3;

public class MultiDisplay {
    private int count;
    private String message;

    public MultiDisplay() {
        message = new String("");
        count = 0;
    }

    public MultiDisplay(int count, String message) {
        this.count = count;
        this.message = message;
    }

    private boolean isValidMessage(String message) {
        return message != null;
    }

    private boolean isValidCount(int count) {
        return count > 0;
    }

    public void setDisplayMessage(String message) {
        if (isValidMessage(message))
            this.message = message;
        else
            System.out.println("Message must not be empty.");
    }

    public void setDisplayCount(int count) {
        if (isValidCount(count))
            this.count = count;
        else
            System.out.println("Value must be greater than 0.");
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }
}
