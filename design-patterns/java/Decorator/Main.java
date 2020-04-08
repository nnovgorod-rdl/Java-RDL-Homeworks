package Decorator;

public class Main {
    public static void main(String[] args) {
        Matreshka matr1 = new Matreshka();
        Matreshka matr2 = new MatrioshkaBlue(new Matreshka());
        Matreshka matr3 = new MatrioshkaRed(new Matreshka());
        Matreshka matr4 = new MatrioshkaPurple(new Matreshka());
        Matreshka matr5 = new BigBlueMatr(new MatrioshkaBlue(new Matreshka()));
        Matreshka matr6 = new BigRedMatr(new MatrioshkaRed(new Matreshka()));
        System.out.println(matr1.printName());
        System.out.println(matr2.printName());
        System.out.println(matr3.printName());
        System.out.println(matr4.printName());
        System.out.println(matr5.printName());
        System.out.println(matr6.printName());
    }
}
