package com.example.api.base;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class DFSTest {
    static List<Integer> hasMarked = Lists.newArrayList();
    static int[][] arr = new int[6][6];
    static   {

        arr[0][0] = 0;
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[0][3] = 1;
        arr[0][4] = 0;
        arr[0][5] = 0;

        arr[1][0] = 1;
        arr[1][1] = 0;
        arr[1][2] = 0;
        arr[1][3] = 0;
        arr[1][4] = 1;
        arr[1][5] = 0;

        arr[2][0] = 1;
        arr[2][1] = 0;
        arr[2][2] = 0;
        arr[2][3] = 0;
        arr[2][4] = 1;
        arr[2][5] = 0;

        arr[3][0] = 1;
        arr[3][1] = 0;
        arr[3][2] = 0;
        arr[3][3] = 0;
        arr[3][4] = 0;
        arr[3][5] = 0;

        arr[4][0] = 0;
        arr[4][1] = 1;
        arr[4][2] = 1;
        arr[4][3] = 0;
        arr[4][4] = 0;
        arr[4][5] = 0;

        arr[5][0] = 0;
        arr[5][1] = 0;
        arr[5][2] = 0;
        arr[5][3] = 1;
        arr[5][4] = 0;
        arr[5][5] = 0;

        for(int i =0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    static Stack<Integer> stack = new Stack();

    public static void main(String[] args) {


//        int[] hasMarked = new int[6];


        int i=0;
//        System.out.println(arr);
        System.out.println(i+1);
        stack.add(i);
        hasMarked.add(i);
            for(int j=0;i<6;j++){
                if(hasMarked.size()==6){
                    System.exit(0);
                }
                if (arr[j][i] == 1 && !hasMarked.contains(j)){
                    //拿这个纵坐标去横坐标里查
                    hasMarked.add(j);
                    stack.add(j);
                    System.out.println(j+1);
                    doReturn(j,arr);
                }
            }

//
    }


    public static void doReturn(int j,int[][] arr){
        if(hasMarked.size()==6){
            System.exit(0);
        }
        {
            int temp = j;
//            for(int t = temp;temp<6;t++){
                for(int x = 0;x<6;x++){
                    if (arr[x][temp] == 1 && !hasMarked.contains(x)){
                        System.out.println(x+1);
                        hasMarked.add(x);
                        stack.add(x);
                        doReturn(x,arr);
                    }

//                }
            }
            //都没有 则出栈继续操作
            doReturn(stack.pop(),arr);
        }
    }
}
