package com.example.api.base;

import java.util.HashMap;

public class TestD {
    public static void main(String[] args) {
        int a = 20;
        int b = 7;

        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                int i1 = i % j;
                int i2 = i & (j - 1);
                System.out.println(String.format("i1的值为:%d,i2的值为:%d,是否相等:%s",i1,i2,(i1==i2)?"true":"fales"));
            }
        }
    }
}
