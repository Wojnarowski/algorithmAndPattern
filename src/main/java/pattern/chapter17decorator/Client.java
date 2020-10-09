package pattern.chapter17decorator;

public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecorator1(component);
        component = new ConcreteDecorator2(component);
        //修饰后运行
        component.operate();
    }
}
