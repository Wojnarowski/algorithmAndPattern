package practise.finalize;

/**
 * finalize() 方法名，Object类的方法，Java 技术允许使用 finalize() 方法
 * 在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。
 * 这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象进行调用。
 * finalize()方法是在垃圾收集器删除对象之前对这个对象调用的子类覆盖
 * finalize() 方法以整理系统资源或者执行其他清理操作。
 */
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString()
    {
        return "姓名："+this.name+"，年龄："+this.age;
    }

    public void finalize() throws Throwable{
        //对象释放空间是默认调用此方法
        System.out.println("对象被释放-->"+this);//直接输出次对象，调用toString()方法
    }
}
