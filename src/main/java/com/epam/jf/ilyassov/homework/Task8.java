package com.epam.jf.ilyassov.homework;

public class Task8 {

    public static void main(String[] args) {
        if(args.length==0){
            return;
        }
        String palidrom="";
        for (int i = 0; i < args.length; i++) {
            if(methodPalidrom(args[i]))
            {
                palidrom=args[i];
            }
        }
        System.out.println(palidrom);
    }

    public static boolean methodPalidrom(String arr)
    {
        for(int i=0,j=arr.length()-1;i<arr.length()/2;++i,--j){
            if(arr.charAt(i)!=arr.charAt(j))
            {
                return false;
            }
        }
        return true;

    }
}
