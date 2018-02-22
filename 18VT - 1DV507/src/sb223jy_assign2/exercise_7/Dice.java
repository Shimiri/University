package sb223jy_assign2.exercise_7;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dice {
    private ImageView ivFace;
    private boolean locked;
    private int number;

    public Dice(Image face, int n) {
        number = n;
        ivFace = new ImageView();
        ivFace.fitHeightProperty().set(48);
        ivFace.fitWidthProperty().set(48);
        setFace(face, n);
    }

    public void setFace(Image face, int n) {
        number = n;
        ivFace.setImage(face);
    }

    public ImageView getIvFace() {
        return ivFace;
    }

    public void setLocked(boolean state) {
        locked = state;
    }

    public boolean getStatus() {
        return locked;
    }

    public int getNumber() {
        return number;
    }
}
