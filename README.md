

<h1> Experimental</h1>
<h2>Euler and Rk2 converter-->src/main/java/com/expr/EulerRk2Converter.java</h2>
<p> Takes initial values x<sub>0</sub>, y<sub>0</sub>, h, func(x,y) and no of itr and perform necessary opr</p>
<p>method euler()-> follows formula: y<sub>n+1</sub> = y<sub>n</sub>+h * F[x<sub>n</sub>, y<sub>n</sub>], and x<sub>n+1</sub>= x<sub>n</sub> + h</p>
<p>method rk2()-> follows formula: y<sub>n+1</sub> = y<sub>n</sub>+(h/2) * [F(x<sub>n</sub>, y<sub>n</sub>) + F(x<sub>n+1</sub>,y<sub>n+1</sub> <sup>euler</sup>)]  and x<sub>n+1</sub>=x<sub>n</sub> + h <br> and y<sub>n+1</sub> <sup>euler</sup>
  =y<sub>n</sub> + h * F[x<sub>n</sub>, y<sub>n</sub>]</p>
