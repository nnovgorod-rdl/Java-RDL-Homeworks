package Decorator;

public class BigRedMatr extends MatrioshkaRed{

    public BigRedMatr(MatrioshkaRed matrioshkaRed) {
        super(matrioshkaRed);
    }

    public String printName() {
        return  printSize() + super.printName();
    }

    private String printSize() {
        return "Большая ";
    }
}
