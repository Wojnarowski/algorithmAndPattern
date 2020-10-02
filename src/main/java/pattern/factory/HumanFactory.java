package pattern.factory;

public class HumanFactory extends AbstractHumanFactory{
    public <T extends Human> T createHuman(Class<T> c) {
        //定义一个人种
        Human human=null;
        try{
            //产生一个人种
            human= (Human) Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            System.out.println("人种创建产生错误");
        }
        return  (T) human;

    }
}
