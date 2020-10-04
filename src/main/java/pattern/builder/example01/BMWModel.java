package pattern.builder.example01;

public class BMWModel extends CarModel{
    protected void start() {
        System.out.println("宝马车跑起来是这个样子的...");
    }

    protected void stop() {
        System.out.println("宝马车应该这样停车...");
    }

    protected void alarm() {
        System.out.println("宝马车的喇叭声音是这个样子的...");
    }

    protected void engineBoom() {
        System.out.println("宝马车的引擎是这个声音的...");
    }
}
