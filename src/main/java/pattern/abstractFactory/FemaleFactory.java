package pattern.abstractFactory;

public class FemaleFactory implements HumanFactory{
    public Human createYellowHuman() {
        return new FemaleYellowWomen();
    }

    public Human createWhiteHuman() {
        return new FemaleWhiteWomen();
    }

    public Human createBlackHuman() {
        return new FemaleBlackWomen();
    }
}
