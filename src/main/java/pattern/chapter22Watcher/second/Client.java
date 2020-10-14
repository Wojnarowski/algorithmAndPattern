package pattern.chapter22Watcher.second;

public class Client {

    public static void main(String[] args) throws InterruptedException {
      IHanFeiZi hanFeiZi = new HanFeiZi();
      hanFeiZi.haveBreakfast();
      hanFeiZi.haveFun();
    }
}
