package Decorator;

public class MatrioshkaRed extends Matreshka{

        public MatrioshkaRed(AMatrioshka aMatrioshka) {
            super();
        }
        public String printName() {
            return printColor() + super.printName();
        }

        private String printColor() {
            return " красная";
        }
    }