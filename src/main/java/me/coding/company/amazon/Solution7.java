package me.coding.company.amazon;

class Solution7 {
    public int countSubstrings(String s) {
        char[] chArr = s.toCharArray();
        int count = 0 ;
        int size = chArr.length;
        for(int i = 0 ; i < size ; i++){
            int l=i,r=i;
            while(l>=0&&r<size){
                if(chArr[l]==chArr[r]){
                    count++;
                    l--;r++;
                }else break;
            }
            if(i!=size-1){
                l=i;r=i+1;
                while(l>=0&&r<size){
                    if(chArr[l]==chArr[r]){
                        count++;
                        l--;r++;
                    }else break;
                }
            }
        }
        return count;
    }
}
