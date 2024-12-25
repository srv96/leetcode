package me.coding.javaconcept;

 enum Operation {
    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public int apply(int a, int b) {
            if (b == 0) throw new ArithmeticException("Cannot divide by zero");
            return a / b;
        }
    };

    // Abstract method to be implemented by each constant
    public abstract int apply(int a, int b);
}

public class EnumBehaviorExample {
    public static void main(String[] args) {
        int x = 10, y = 5;

        for (Operation op : Operation.values()) {
            System.out.println(op + ": " + op.apply(x, y));
        }
    }
}

