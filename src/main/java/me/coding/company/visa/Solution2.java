package me.coding.company.visa;

import java.util.Stack;

class Solution2 {
    class Temperature {
        public Temperature(int temp, int day) {
            this.temp = temp;
            this.day = day;
        }

        public int temp;
        public int day;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        Stack<Temperature> temperatureStack = new Stack<>();
        int[] result = new int[days];
        for (int i = days - 1; i >= 0; i--) {
            while(!temperatureStack.isEmpty()&&temperatures[i]>=temperatureStack.peek().temp){
                temperatureStack.pop();
            }
            if(temperatureStack.isEmpty()){
                result[i] = 0;
                temperatureStack.push(new Temperature(temperatures[i],i));
            }else{
                result[i]=temperatureStack.peek().day - i;
                temperatureStack.push(new Temperature(temperatures[i],i));
            }
        }
        return result;
    }
}