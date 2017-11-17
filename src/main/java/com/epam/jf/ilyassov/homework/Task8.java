package com.epam.jf.ilyassov.homework;

public class Task8 {

    public static void main(String[] args) {
        if(args.length==0){
            return;
        }
        int count=0;
        String palidrom="";
        for (String arg : args) {
            if(Number(arg)&&Palidrom(arg)&&count<2){
                palidrom=arg;
                count++;
            }

        }
        System.out.println("Число-палиндром "+palidrom);
    }

    public static boolean Number(String arr)
    {
        for(int i=0;i<arr.length();++i){
            if(arr.charAt(i)!='0'&&arr.charAt(i)!='1'&&arr.charAt(i)!='2'&&arr.charAt(i)!='3'&&arr.charAt(i)!='4' &&
                    arr.charAt(i)!='5'&&arr.charAt(i)!='6'&&arr.charAt(i)!='7'&&arr.charAt(i)!='8'&&arr.charAt(i)!='9')
            {
                return false;
            }
        }
        return true;

    }

    public static boolean Palidrom(String arg){
        for(int i=0,j=arg.length()-1;i<arg.length()/2;++i,--j){
            if(arg.charAt(i)!=arg.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
