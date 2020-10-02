package pattern.factory;

public class BlackHuman implements Human{
    public void getColor() {
        System.out.println("黑色人种的皮肤一般都是黑色的");
    }

    public void talk() {
        System.out.println("黑人说的话一般人都听不懂");

    }
}
