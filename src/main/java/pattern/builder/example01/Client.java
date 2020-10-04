package pattern.builder.example01;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        BenzModel benzModel = new BenzModel();
        ArrayList<String> sequence = new ArrayList<String>();
        sequence.add("engine boom"); //客户要求，run的时候先发动引擎
        sequence.add("start"); //启动起来
        sequence.add("stop"); //开了一段就停下来 //我们把这个顺序赋予奔驰车
        benzModel.setSequence(sequence);
        benzModel.run();
    }
}
