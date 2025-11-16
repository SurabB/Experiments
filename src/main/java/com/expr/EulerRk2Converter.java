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

    public static void main(String[] args) {
        //   EulerRk2Converter.rk2(1,2,0.5,(x,y)->(2*y)/x,2);

        //HashMap<Integer, Values> values = EulerRk2Converter.firstOrderDiffUsingEuler(0, 1, 0.1, (x, y) -> 2 * x * y, 3);
        //x0,y0,h,dy/dx,no.of itr

        //HashMap<Integer, Values> values = EulerRk2Converter.rk2(1, 2, 0.25, (x, y) -> y + Math.sin(x), 2);

        HashMap<Integer, Values> values = EulerRk2Converter.secondOrderDiffUsingEuler(0, 0, 1, 0.2, (x, y, z) -> 6 + 3 * y - 2 * z, 2);
        //x0,y0,z0,h,dz/dx,no.of itr
        values.forEach((key,value)->{
            System.out.println("itr: %d , values = %s".formatted(key,value.getValues()));
        });

    }

    public static  HashMap<Integer, Values> rk2(double xnow,double ynow,double h,BiFunction<Double,Double,Double>func,int itr){
        //stores values  x and y for each iteration including initial ones
     HashMap<Integer,Values> values=new LinkedHashMap<>(itr);
        for(int i=0;i<=itr;i++){
            double ynext=ynow+(h/2)*(func.apply(xnow,ynow)+func.apply(xnow+h,ynow+h*func.apply(xnow,ynow)));
            values.put(i,new Values(List.of(xnow,ynow)));
            ynow=ynext;
            xnow=xnow+h;
        }
        //returns values x and y of each iteration including the initial values.
        return values;
    }
    public  static HashMap<Integer, Values> firstOrderDiffUsingEuler(double xnow, double ynow, double h, BiFunction<Double,Double,Double>func, int itr){
        //stores values  x and y for each iteration including initial ones
        HashMap<Integer,Values> values=new LinkedHashMap<>(itr);
        for(int i=0;i<=itr;i++){
            double ynext=ynow+h*func.apply(xnow,ynow);
            values.put(i,new Values(List.of(xnow,ynow)));
            ynow=ynext;
            xnow=xnow+h;
        }
        //returns values x and y of each iteration including the initial values.
        return values;
    }
    public static  HashMap<Integer, Values> secondOrderDiffUsingEuler(double xnow,double ynow,double znow,double h,TriFunction<Double> func,int itr){
        //stores values  x and y for each iteration including initial ones
        HashMap<Integer,Values> values=new LinkedHashMap<>(itr);
        for(int i=0;i<=itr;i++){
           double znext=znow+h*func.apply(xnow,ynow,znow);
            double ynext=ynow+h*znow;
            values.put(i,new Values(List.of(xnow,ynow,znow)));
            ynow=ynext;
            xnow=xnow+h;
            znow=znext;
        }
        //returns values x and y of each iteration including the initial values.
        return values;
    }
    public static class Values{
      private final List<Double> values;
        Values(List<Double> values){
        this.values=values;

        }
  public List<Double> getValues(){
            return values;
  }
    }

}