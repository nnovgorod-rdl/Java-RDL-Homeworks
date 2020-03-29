package Decorator;

public class BigBlueMatr extends MatrioshkaBlue{

        public BigBlueMatr(MatrioshkaBlue matrioshkaBlue) {
            super(matrioshkaBlue);
        }

        public String printName() {
            return printSize() + super.printName();
        }

        private String printSize() {
            return "Большая ";
        }
    }
