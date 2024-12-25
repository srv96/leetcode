//package me.coding.leetcode.ace75;
//
//
//
//class Solution1 {
//    public Utils.Pair<Integer,String> giveCompressByIndex(char[] chars, int idx){
//        int i = 1;
//        int size = chars.length;
//        while(idx+i<size&&chars[idx]==chars[idx+i]){
//            i++;
//        }
//        if(i==1)return new Utils.Pair<>(idx,String.valueOf(chars[idx]));
//        else return new Utils.Pair<>(idx+i-1,String.valueOf(chars[idx])+i);
//    }
//    public int compress(char[] chars) {
//        int size = chars.length;
//        int cVar =0;
//        for(int i = 0 ; i < size ; i++){
//            Utils.Pair<Integer,String> subRes = giveCompressByIndex(chars,i);
//            String cmpres = subRes.getValue();
//            for(int j = cVar ; j < cVar+cmpres.length() ; j++){
//                chars[j] = cmpres.charAt(j-cVar);
//            }
//            cVar+=cmpres.length();
//            i=subRes.getKey();
//        }
//        return cVar;
//    }
//}
