//package me.coding.leetcode.top150;
//
//class Solution4 {
////    Map<Integer,Boolean> memo = new HashMap<>();
//    boolean memo[] ;
//    public boolean jump(int[] nums,int idx){
//        if(idx==nums.length-1){
//            memo.put(idx,true);
//            memo[idx]=true;
//            return true;
//        }
//        if(nums[idx]==0){
//            memo.put(idx,false);
//            return false;
//        }
//        boolean result = false;
//        for(int i = nums[idx] ; i >=1 ; i--){
//            if(idx+i < nums.length){
//                if(memo.get(idx+i)!=null){
//                    result = result || memo.get(idx+1);
//                }else{
//                    result = result || jump(nums,idx+i);
//                }
//            }
//        }
//        memo.put(idx,result);
//        return result;
//    }
//    public boolean canJump(int[] nums) {
//        memo = new boolean[nums.length];
//        for(int)
//        return jump(nums,0);
//    }
//}
