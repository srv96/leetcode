package me.coding.sandbox;

public class TestSolution {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new int[][]{{1,2},{4,5},{7,8}});
        Matrix m2 = new Matrix(new int[][]{{1,2,3},{4,5,6}});
        Matrix m3 = m1.dot(m2);
        System.out.println(m3);
    }
}
//    int[][][] cube = new int[][][]{
//            {
//                    {1, 2, 3,4},
//                    {4, 5, 6,8},
//                    {4, 5, 6,8},
//                    {4, 5, 6,8},
//                    {7, 8, 9,10}
//            },
//            {
//                    {2, 4, 6,5},
//                    {8, 10, 12,7},
//                    {8, 10, 12,7},
//                    {8, 10, 12,7},
//                    {14, 16, 18,-2}
//            },
//            {
//                    {3, 6, 9,0},
//                    {12, 15, 18,4},
//                    {12, 15, 18,4},
//                    {12, 15, 18,4},
//                    {21, 24, 27,67}
//            },
//            {
//                    {3, 6, 9,0},
//                    {12, 15, 18,4},
//                    {12, 15, 18,4},
//                    {12, 15, 18,4},
//                    {21, 24, 27,67}
//            }
//    };
//
//    int[] num = new Solution7().getDiagonal(cube);
//        for (int i = 0; i < num.length; i++) {
//        System.out.print(num[i] + " ");
//    }
//}
//    Integer num1 = 1000, num2 = 1000;
//        System.out.println(num1 == num2);//1
//                Integer num3 = 20, num4 = 20;
//                System.out.println(num3 == num4);//2
//    public static void main(String[] args) {
//        ListNode num1 = new ListNode(9);
//        num1.next = new ListNode(9);
//        num1.next.next = new ListNode(9);
//        num1.next.next.next = new ListNode(9);
//        num1.next.next.next.next = new ListNode(9);
//        num1.next.next.next.next.next = new ListNode(9);
//        num1.next.next.next.next.next.next = new ListNode(9);
//
//        ListNode num2 = new ListNode(9);
//        num2.next = new ListNode(9);
//        num2.next.next = new ListNode(9);
//        num2.next.next.next = new ListNode(9);
//
//
//        ListNode result = new Solution().sum(num1, num2);
//        while (result != null) {
//            System.out.print(result.val + " ");
//            result = result.next;
//        }
//
//    }
//    int[][] grid = new int[][]{
//            {1,1,1,1,1},
//            {1,1,1,1,1},
//            {1,1,1,1,1},
//            {1,1,1,1,1},
//            {1,1,1,1,1},
//            {1,1,1,1,1},
//    };
//        System.out.println(new Solution5().getNumGroup(grid));
