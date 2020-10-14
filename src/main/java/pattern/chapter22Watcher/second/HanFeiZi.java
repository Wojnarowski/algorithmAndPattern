package pattern.chapter22Watcher.second;

public class HanFeiZi implements IHanFeiZi {

    //声明出lisi
   private LiSi liSi =new LiSi();

    // 韩非子要吃饭了
    public void haveBreakfast() {
        System.out.println("韩非子:开始吃饭了...");
        liSi.update("监听到韩非子吃饭");
    }

    // 韩非子开始娱乐了
    public void haveFun() {
        System.out.println("韩非子:开始娱乐了...");
        liSi.update("监听到韩非子娱乐");
    }
}
