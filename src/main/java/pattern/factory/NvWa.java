package pattern.factory;

public class NvWa {

    public static void main(String[] args) {
        //生命阴阳八卦炉
        AbstractHumanFactory abstractHumanFactory  = new HumanFactory();
        System.out.println("第一次火候不足产生了白种人");
        Human whiteHuman=abstractHumanFactory.createHuman(WhiteHunam.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("第二次火候太足产生了黑种人");
        Human blackHuman=abstractHumanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();


        System.out.println("第三次火候正好产生了黄种人");
        Human yellowHuman=abstractHumanFactory.createHuman(YellowHunam.class);
        yellowHuman.getColor();
        yellowHuman.talk();

    }
}
