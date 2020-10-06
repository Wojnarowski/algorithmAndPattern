package pattern.command;

/**
 * 将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，
 * 对请 求排队或者记录请求日志，可以提供命令的撤销和恢复功能。
 */
public class Client {

    public static void main(String[] args) {
        //首先声明调用者Invoker
        Invoker invoker = new Invoker();
        //定义接收者
        Receiver receiver = new ConcreteReciver1();
        //定义一个发送给接收者的命令
        Command command = new ConcreteCommand1(receiver);
        //把命令交给调用者去执行
        invoker.setCommand(command);
        invoker.action();
    }
}
