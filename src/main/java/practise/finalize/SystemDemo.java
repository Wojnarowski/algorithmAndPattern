package practise.finalize;

public class SystemDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Person per=new Person("zhangsan",30);
        per=null;//断开引用，释放空间
        //方法1：
        System.gc();//强制性释放空间
        //方法2：
//        Runtime run=Runtime.getRuntime();
//        run.gc();
    }
}
