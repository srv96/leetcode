package me.coding.leetcode.code;

public class Solution8 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mn = new int[m];
        int i = 0, j = 0, k = 0;
        while (i < m-n && j < n) {
            if(nums1[i]<=nums2[j]){
                mn[k]=nums1[i];
                i++;
                k++;
            }else{
                mn[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<m-n){
            mn[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            mn[k]=nums2[j];
            j++;
            k++;
        }
        nums1=mn;
        nums1[6]=54;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,9,0,0,0,0,0};
        int[] nums2 = {2,4,6,8,10};
        Solution8 s = new Solution8();
        s.merge(nums1,10,nums2,5);
        System.out.println(nums1);
    }
}
