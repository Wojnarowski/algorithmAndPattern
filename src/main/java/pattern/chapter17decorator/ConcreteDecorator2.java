package pattern.chapter17decorator;

public class ConcreteDecorator2 extends Decorator{

    public ConcreteDecorator2(Component component) {
        super(component);
    }
    //定义自己的修饰方法
    private void method2(){
        System.out.println("method2 修饰");
    }

    //重写父类的Operation方法
    public void operate(){
        this.method2();
        super.operate();
    }
}
