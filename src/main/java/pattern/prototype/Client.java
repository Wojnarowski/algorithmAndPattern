package pattern.prototype;

import java.util.Random;

/**
 * 这种不 通过new关键字来产生一个对象，
 * 而是通过对象复制来实现的模式就叫做原型模式。
 *
 *
 * 这既是它的优点也是缺点，直接在内存中拷贝，
 * 构造函数是不会执行的（参见13.4 节）。
 * 优点就是减少了约束，缺点也是减少了约束，需要大家在实际应用时考虑。
 *
 *
 *
 * 内部的数组和引用对象才不拷贝， 其他的原始类型比如int、long、char等都会被拷贝，
 * 但是对于String类型，Java就希望你把它 认为是基本类型，它是没有clone方法的，处理机制也比较特殊，通过字符串池（stringpool）
 * 在需要的时候才在内存中创建新的字符串，读者在使用的时候就把String当做基本类使用即可。
 *
 *
 * 注意 使用原型模式时，引用的成员变量必须满足两个条件才不会被拷贝：
 * 一是类的成 员变量，而不是方法内变量；
 * 二是必须是一个可变的引用对象，而不是一个原始类型或不可变对象
 */
public class Client {

    //发送账单的数量，这个值是从数据库中获得
    private static int MAX_COUNT = 6;

    public static void main(String[] args) {
        //模拟发送邮件
        int i=0;
        //把模板定义出来，这个是从数据库中获得
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("XX银行版权所有");
        while(i<MAX_COUNT){
            //以下是每封邮件不同的地方
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation(getRandString(5)+" 先生（女士）");
            cloneMail.setReceiver(getRandString(5)+"@"+getRandString(8) +"");
            //然后发送邮件
            sendMail(cloneMail);
            i++;

        }

    }

    //发送邮件
    public static void sendMail(Mail mail){
        System.out.println("标题："+mail.getSubject() + "\t收件人： "+mail.getReceiver()+"\t...发送成功！");
    }

    //获得指定长度的随机字符串
    public static String getRandString(int maxLength){
        String source ="abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for(int i=0;i<maxLength;i++){
            sb.append(source.charAt(rand.nextInt(source.length())));
        }
        return sb.toString();
    }
}
