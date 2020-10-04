package pattern.builder.example2;

import pattern.builder.example01.BMWModel;
import pattern.builder.example01.CarModel;

import java.util.ArrayList;

public class BMWBuilder extends CarBuilder{
    private BMWModel bmw = new BMWModel();
    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }

    public CarModel getCarModel() {
        return this.bmw;
    }
}
