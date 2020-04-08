package Decorator;

public class MatrioshkaPurple extends Matreshka{
    public MatrioshkaPurple(AMatrioshka aMatrioshka) {
        super();
    }
    public String printName() {
        return printColor() + super.printName();
    }

    private String printColor() {
        return " purple";
    }
}