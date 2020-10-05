package pattern.proxy;

public class GamePlayer implements IGamePlayer{

    private String name = "";
    //我的代理是谁
     private IGamePlayer proxy = null;
     public GamePlayer(String _name){
     this.name = _name;
     }
    public void login(String user, String password) {
        if(true){ System.out.println("登录名为"+user+"的用户"+this.name+"登录成功！"); }else{ System.out.println("请使用指定的代理访问");; }
    }

    public void killBoss() {
        if(true){ System.out.println(this.name + "在打怪！"); }else{ System.out.println("请使用指定的代理访问"); }
    }

    public void upgrade() {
        if(true){ System.out.println(this.name + " 又升了一级！"); }else{ System.out.println("请使用指定的代理访问"); }
    }

//    public IGamePlayer getProxy() {
//        this.proxy = new GamePlayerProxy(this); return this.proxy;
//    }
//
//    //校验是否是代理访问
//     private boolean isProxy(){
//     if(this.proxy == null){
//     return false;
//     }else{
//     return true;
//     }
//     }
}
