package com.expr;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

interface TriFunction<T>{
    T apply(T a, T b, T c);
}

public class EulerRk2Converter {

//    public static void main(String[] args) {
//           EulerRk2Converter.firstOrderDiffUsingRk2(1,2,0.5,(x,y)->(2*y)/x,2);
//
//       // HashMap<Integer, List<Double>> values = EulerRk2Converter.firstOrderDiffUsingEuler(0, 1, 0.1, (x, y) -> 2 * x * y, 3);
//        //x0,y0,h,dy/dx,no.of itr
//
//      //  HashMap<Integer, List<Double>> values = EulerRk2Converter.firstOrderDiffUsingRk2(1, 2, 0.25, (x, y) -> y + Math.sin(x), 2);
//         //x0,y0,h,dy/dx,no.of itr

//       // HashMap<Integer, List<Double>> values = EulerRk2Converter.secondOrderDiffUsingEuler(0, 0, 1, 0.2, (x, y, z) -> 6 + 3 * y - 2 * z, 2);
//        //x0,y0,z0,h,dz/dx,no.of itr
//
//        HashMap<Integer, List<Double>> values = EulerRk2Converter.secondOrderDiffUsingRk2(0, 0, 0, 0.25, (x, y, z) -> 5 - 2 * z + 4 * y, 2);
//          //x0,y0,z0,h,dz/dx,no.of itr
//        values.forEach((key,value)->{
//            System.out.println("itr: %d , values = %s".formatted(key,value));
//        });
//
//    }

    public static  HashMap<Integer, List<Double>> firstOrderDiffUsingRk2(double xnow,double ynow,double h,BiFunction<Double,Double,Double>func,int itr){
        //stores values  x and y for each iteration including initial ones
     HashMap<Integer,List<Double>> values=new LinkedHashMap<>(itr+1);
        for(int i=0;i<=itr;i++){
            //follows Heun's y n+1 formula
            double ynext=ynow+(h/2)*(func.apply(xnow,ynow)+func.apply(xnow+h,ynow+h*func.apply(xnow,ynow)));

            //stores current values x,y
            values.put(i,List.of(xnow,ynow));

            //update the values
            ynow=ynext;
            xnow=xnow+h;
        }
        //returns values x and y of each iteration including the initial values.
        return values;
    }
    public static  HashMap<Integer,List<Double>> secondOrderDiffUsingRk2(double xnow,double ynow,double znow,double h,TriFunction<Double>func,int itr){
        //stores values  x,y,z for each iteration including initial ones
        HashMap<Integer,List<Double>> values=new LinkedHashMap<>(itr+1);
        for(int i=0;i<=itr;i++){
            //follows Heun's z n+1 euler formula
            double znowEuler=znow+h*func.apply(xnow,ynow,znow);

            //follows Heun's y n+1 euler formula
            double ynowEuler=ynow+h*znow;

            //follows Heun's y n+1 formula
            double ynext=ynow+(h/2)*(znow+znowEuler);

            //follows Heun's  z n+1 formula
            double znext=znow+(h/2)*(func.apply(xnow,ynow,znow)+func.apply(xnow,ynowEuler,znowEuler));

            //stores current x,y,z
            values.put(i,List.of(xnow,ynow,znow));

            //update the values
            ynow=ynext;
            xnow=xnow+h;
            znow=znext;

        }
        return values;
    }
    public  static HashMap<Integer, List<Double>> firstOrderDiffUsingEuler(double xnow, double ynow, double h, BiFunction<Double,Double,Double>func, int itr){
        //stores values  x and y for each iteration including initial ones
        HashMap<Integer,List<Double>> values=new LinkedHashMap<>(itr+1);
        for(int i=0;i<=itr;i++){
            //follows euler y n+1 formula
            double ynext=ynow+h*func.apply(xnow,ynow);

            //stores current value of x and y
            values.put(i,List.of(xnow,ynow));

            //update the values
            ynow=ynext;
            xnow=xnow+h;
        }
        return values;
    }
    public static  HashMap<Integer, List<Double>> secondOrderDiffUsingEuler(double xnow,double ynow,double znow,double h,TriFunction<Double> func,int itr){
        //stores values  x,y,z  for each iteration including initial ones
        HashMap<Integer,List<Double>> values=new LinkedHashMap<>(itr+1);
        for(int i=0;i<=itr;i++){
            //follows euler z n+1 formula
           double znext=znow+h*func.apply(xnow,ynow,znow);

           //follows euler y n+1 formula
            double ynext=ynow+h*znow;

            //stores current value of x,y,z
            values.put(i,List.of(xnow,ynow,znow));

            //update the values
            ynow=ynext;
            xnow=xnow+h;
            znow=znext;
        }
        return values;
    }


}