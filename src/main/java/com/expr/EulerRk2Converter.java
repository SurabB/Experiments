package com.expr;

import java.util.function.BiFunction;
class EulerRk2Converter {
    public static void main(String[] args) {
        //  new Main().rk2(1,2,0.5,(x,y)->(2*y)/x,2);
        // new Main().euler(0,1,0.1,(x,y)->2*x*y,3);
        new EulerRk2Converter().rk2(1,2,0.25,(x, y)->y+Math.sin(x),2);
        //x0,y0,h,dy/dx,no.of itr
    }

    public void rk2(double xnow,double ynow,double h,BiFunction<Double,Double,Double>func,int itr){

        for(int i=0;i<itr;i++){
            Func funcCurr=new Func(func);
            double ynext=ynow+(h/2)*(funcCurr.rk2Func(xnow,ynow)+new Func(func).rk2Func(xnow+h,funcCurr.yEuler(xnow,ynow,h)));
            ynow=ynext;
            xnow=xnow+h;
            System.out.println("x"+(i+1)+"= "+xnow+ ", y"+(i+1)+ "= "+ynow);

        }
    }
    public void euler(double xnow,double ynow,double h,BiFunction<Double,Double,Double>func,int itr){

        for(int i=0;i<itr;i++){
            Func funcCurr=new Func(func);
            double ynext=ynow+h*funcCurr.eulerFunc(xnow,ynow);
            ynow=ynext;
            xnow=xnow+h;
            System.out.println("x"+(i+1)+"= "+xnow+ ", y"+(i+1)+ "= "+ynow);

        }

    }
    public static class Func{

        BiFunction<Double,Double,Double> func;
        Func(BiFunction<Double,Double,Double> func){
            this.func=func;
        }
        public double rk2Func(double x,double y){
            return func.apply(x,y);
        }
        public double yEuler(double x,double y,double h ){
            return y+h*rk2Func(x,y);
        }
        public double eulerFunc(double x,double y){
            return func.apply(x,y);
        }
    }
}