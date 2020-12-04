package zuo.guide.chapter71changeTwoParamValueWithoutOthrer;

public class Client {

    /**
     * 不适用额外变量交换两个数值
     * @param args
     */
    public static void main(String[] args) {

        changeTwointValueWithoutOther(3,5);
    }

    public static void changeTwointValueWithoutOther(int a,int b){
        System.out.println("a="+a);
        System.out.println("b="+b);

        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("a="+a);
        System.out.println("b="+b);
    }


}
