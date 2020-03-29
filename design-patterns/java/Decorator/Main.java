package Decorator;

public class Main {
    public static void main(String[] args) {
        Matreshka matr1 = new BigBlueMatr(new MatrioshkaBlue(new Matreshka()));
        System.out.println(matr1.printName());
    }
}
