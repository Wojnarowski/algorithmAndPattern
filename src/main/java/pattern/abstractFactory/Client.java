package pattern.abstractFactory;

public class Client {

    public static void main(String[] args) {

        HumanFactory femaleHumanFactory=new FemaleFactory();

        Human femaleBlackWomen = femaleHumanFactory.createBlackHuman();

        femaleBlackWomen.getColor();
        femaleBlackWomen.getSex();
        femaleBlackWomen.talk();
    }
}
