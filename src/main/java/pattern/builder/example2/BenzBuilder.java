package pattern.builder.example2;

import pattern.builder.example01.BenzModel;
import pattern.builder.example01.CarModel;

import java.util.ArrayList;

public class BenzBuilder extends CarBuilder{
    private BenzModel benz = new BenzModel();
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }

    public CarModel getCarModel() {
        return this.benz;
    }
}
