package Decorator;

public class MatrioshkaBlue extends Matreshka {

    public MatrioshkaBlue(AMatrioshka aMatrioshka) {
        super();
    }

    public String printName() {
       return  printColor() + super.printName();
    }

    private String printColor() {
        return " синяя";
    }
}