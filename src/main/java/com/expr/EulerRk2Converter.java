package com.expr;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;
public class EulerRk2Converter {

//    public static void main(String[] args) {
//        //   EulerRk2Converter.rk2(1,2,0.5,(x,y)->(2*y)/x,2);
//        //  EulerRk2Converter.euler(0,1,0.1,(x,y)->2*x*y,3);
//        //x0,y0,h,dy/dx,no.of itr
//        HashMap<Integer, Values> values = EulerRk2Converter.rk2(1, 2, 0.25, (x, y) -> y + Math.sin(x), 2);
//        for(Map.Entry<Integer, Values> entry:values.entrySet()){
//            int key=entry.getKey();
//            double x=entry.getValue().getXnow();
//            double y=entry.getValue().getYnow();
//            System.out.println("x%d = %.4f , y%d = %.4f".formatted(key,x,key,y));
//
//        }
//
//    }

    public static  HashMap<Integer, Values> rk2(double xnow,double ynow,double h,BiFunction<Double,Double,Double>func,int itr){
     HashMap<Integer,Values> values=new LinkedHashMap<>(itr);
        for(int i=0;i<=itr;i++){
            double ynext=ynow+(h/2)*(func.apply(xnow,ynow)+func.apply(xnow+h,ynow+h*func.apply(xnow,ynow)));
            values.put(i,new Values(xnow,ynow));
            ynow=ynext;
            xnow=xnow+h;
        }
        return values;
    }
    public  static HashMap<Integer, Values> euler(double xnow, double ynow, double h, BiFunction<Double,Double,Double>func, int itr){
        HashMap<Integer,Values> values=new LinkedHashMap<>(itr);
        for(int i=0;i<itr;i++){
            double ynext=ynow+h*func.apply(xnow,ynow);
            values.put(i,new Values(xnow,ynow));
            ynow=ynext;
            xnow=xnow+h;
        }
           return values;
    }
    public static class Values{
        private final double xnow;
       private final double ynow;
        Values(double xnow, double ynow){
            this.xnow=xnow;
            this.ynow=ynow;

        }
        public double getXnow(){
            return xnow;
        }
        public double getYnow(){
            return ynow;
        }
    }

}