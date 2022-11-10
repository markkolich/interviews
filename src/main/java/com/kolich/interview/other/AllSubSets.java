package com.kolich.interview.other;

class AllSubSets{
    public static void main(String args[]){

        String[] arr = {"f1","f2","f3"};
        print(arr);
    }
    public static void print(String[] arr){
        String[] temp = new String[arr.length];
        int i =0;
        helper(arr,temp,i);
    }
    public static void helper(String[] arr, String[] temp,int i ){
        if(i == arr.length)
        printArr(temp);
        else
        {
            temp[i] = null;
            helper(arr,temp,i+1);
            temp[i] = arr[i];
            helper(arr,temp,i+1);
        }
    }
    public static void printArr(String[] temp){
        StringBuffer sb = new StringBuffer();
        for(String i : temp){
            if(i!=null){
                sb.append(i+":");
            }
        }
        if(sb.length()>1)
        {
            //System.out.println(sb);
            sb.replace(sb.length()-1, sb.length(), "");
            //System.out.println(sb);
        }   

        System.out.println(sb.toString());
    }
}