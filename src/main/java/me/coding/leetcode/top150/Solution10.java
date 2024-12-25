package me.coding.leetcode.top150;

class Solution10 {
    public String convert(String s, int numRows) {
        if(numRows==1)return  s;


        String[] strArr = new String[numRows];
        for(int i = 0 ; i < numRows ; i++)strArr[i]="";
        int strSize = s.length();
        if(strSize==1)return s;
        int i = 0;
        int oscillator = 0;
        boolean flag = false;
        while(i<strSize){
            strArr[oscillator]+=s.charAt(i);
            if(oscillator==0)flag=true;
            if(oscillator==numRows-1)flag=false;
            if(flag)oscillator++;
            else oscillator--;
            i++;
        }
        String result = "";
        for(int j = 0 ; j < numRows ; j++)result+=strArr[j];

        return result;
    }
}