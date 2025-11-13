package com.expr;

import java.util.function.BiFunction;
class EulerRk2Converter {
    public static void main(String[] args) {
        //  new EulerRk2Converter().rk2(1,2,0.5,(x,y)->(2*y)/x,2);
        // new EulerRk2Converter().euler(0,1,0.1,(x,y)->2*x*y,3);
        new EulerRk2Converter().rk2(1,2,0.25,(x, y)->y+Math.sin(x),2);
        //x0,y0,h,dy/dx,no.of itr
    }

    public void rk2(double xnow,double ynow,double h,BiFunction<Double,Double,Double>func,int itr){

        for(int i=0;i<itr;i++){
            double ynext=ynow+(h/2)*(func.apply(xnow,ynow)+func.apply(xnow+h,ynow+h*func.apply(xnow,ynow)));
            ynow=ynext;
            xnow=xnow+h;
            System.out.println("x"+(i+1)+"= "+xnow+ ", y"+(i+1)+ "= "+ynow);

        }
    }
    public void euler(double xnow,double ynow,double h,BiFunction<Double,Double,Double>func,int itr){

        for(int i=0;i<itr;i++){
            double ynext=ynow+h*func.apply(xnow,ynow);
            ynow=ynext;
            xnow=xnow+h;
            System.out.println("x"+(i+1)+"= "+xnow+ ", y"+(i+1)+ "= "+ynow);

        }

    }
}