package pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler{
    //被代理者
    Class cls=null;
    //被代理的实例
    Object object = null;
    //我要代理谁
    public GamePlayIH(Object _obj){
        this.object=_obj;
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result = method.invoke(this.object,objects);
        //如果是登录方法，则发送信息
        if(method.getName().equalsIgnoreCase("login")){
            System.out.println("有人在用我的账号登录！");
        }
        return result;
    }
}
