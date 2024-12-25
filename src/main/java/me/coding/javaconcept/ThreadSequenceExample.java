package me.coding.javaconcept;

public class ThreadSequenceExample {
    public void threadSequence(){
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(" 1 ");
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    th1.join();
                    System.out.print(" 2 ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    th1.join();
                    System.out.print(" 3 ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    th2.join();
                    System.out.print(" 4 ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    th3.join();
                    System.out.print(" 5 ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0  ; i < 100 ; i++){
            new ThreadSequenceExample().threadSequence();
            Thread.sleep(10);
            System.out.println("");
        }
    }
}



