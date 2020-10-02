package pattern.factory;

/**
 * 抽象定义方法
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> c);
}
