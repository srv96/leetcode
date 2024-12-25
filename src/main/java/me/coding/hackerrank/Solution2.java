package me.coding.hackerrank;
class Node{
    public int frequency;
    public char data;
    public Node left, right;

    public Node(char data,int frequency) {
        this.frequency = frequency;
        this.data = data;
    }
}
public class Solution2 {
    void decode(String s, Node root) {
        char[] chArr = s.toCharArray();
        int size = chArr.length;
        Node curr = root;
        for(int i = 0 ; i < size ; i++){
            curr = (chArr[i]=='0') ? curr.left : curr.right;
            if(curr.left == null && curr.right==null){
                System.out.print(curr.data);
                curr=root;
            }
        }
    }
}
