package zuo.guide.chapter72FindTheBiggerUserNothing;

/**
 * 不用任何比较器找出两个数中较大的数
 * 给定两个32位整数a和b,返回a和b中较大的
 */
public class Client {

    public static void main(String[] args) {
        System.out.println(1&1);
        System.out.println(2&1);
    }


    /**
     * 返回函数 n 的符号  正数和0返回1
     * 负数返回0
     * @param n
     * @return
     */
    public int sign(int n){
        return flip((n >> 31 & 1));
    }

    /**
     * 如果 n 为 0 返回 1
     * 如果 n 为 1 返回 0
     * @param n
     * @return
     */
    public int flip(int n){
        return n ^ 1;
    }


    /**
     * 此方法有益出问题
     * @param a
     * @param b
     * @return
     */
    public int getMax1(int a,int b){
        int c =a - b;
        int scA=sign(c);
        int scB=flip(scA);
        return a * scA + b * scB;
    }

    public int getMax2(int a , int b){
        int c =a -b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab= sa ^ sb;
        int sameSab=flip(difSab);
        int returnA=difSab * sa + sameSab * sc;
        int returnB=flip(returnA);
        return  a * returnA + b * returnB;
    }
}
