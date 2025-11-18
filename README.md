

<h1> Experimental</h1>
<h2>RangeKuttaSolver-->src/main/java/com/expr/RangeKuttaSolver.java</h2>
<p> Takes initial values x<sub>0</sub>, y<sub>0</sub>, h, F(x,y) and no of itr for first order differential equation and perform necessary opr</p>
<p> Takes initial values x<sub>0</sub>, y<sub>0</sub>,z<sub>0</sub>, h, g(x,y) and no of itr for second order differential equation and perform necessary opr</p>

<p>method firstOrderDiffUsingEuler()-> follows Euler formula: y<sub>n+1</sub> = y<sub>n</sub>+h * F[x<sub>n</sub>, y<sub>n</sub>], and x<sub>n+1</sub>= x<sub>n</sub> + h</p>
<p>method secondOrderDiffUsingEuler()-> follows Euler formula: y<sub>n+1</sub> = y<sub>n</sub>+h * F[x<sub>n</sub>, y<sub>n</sub>,z<sub>n</sub>], where[x,y,z] is assumed to be dy/dx=z and x<sub>n+1</sub>= x<sub>n</sub> + h</p>
<p>z<sub>n+1</sub>=z<sub>n</sub>+h*g[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>] ,where g[x,y,z] is assumed to be dz/dx
<br>
and x<sub>n+1</sub>= x<sub>n</sub> + h</p>

<p>method firstOrderDiffUsingRk2()-> follows Heun's formula: y<sub>n+1</sub> = y<sub>n</sub>+(h/2) * [F(x<sub>n</sub>, y<sub>n</sub>) + F(x<sub>n+1</sub>,y<sub>n+1</sub> <sup>euler</sup>)]  and x<sub>n+1</sub>=x<sub>n</sub> + h <br> and y<sub>n+1</sub> <sup>euler</sup>
  =y<sub>n</sub> + h * F[x<sub>n</sub>, y<sub>n</sub>]</p>

<p>method secondOrderDiffUsingRk2()-> follows Heun's formula: y<sub>n+1</sub> = y<sub>n</sub>+(h/2) * [F(x<sub>n</sub>, y<sub>n</sub> , z<sub>n</sub>) + F(x<sub>n+1</sub>,y<sub>n+1</sub> <sup>euler</sup>, z<sub>n+1</sub> <sup>euler</sup>)]  and x<sub>n+1</sub>=x<sub>n</sub> + h <br> and
y<sub>n+1</sub> <sup>euler</sup> =y<sub>n</sub> + h * F[x<sub>n</sub>, y<sub>n</sub> ,z<sub>n</sub>] where F[x<sub>n</sub>, y<sub>n</sub> ,z<sub>n</sub>]=z<sub>n</sub>
<br>
also,
z<sub>n+1</sub> <sup>euler</sup> =z<sub>n</sub> + h * g[x<sub>n</sub>, y<sub>n</sub> ,z<sub>n</sub>] where g[x<sub>n</sub>, y<sub>n</sub> ,z<sub>n</sub>]=dz/dx

</p>

<p>method secondOrderDiffUsingRk4()-><br>
follows formulas:<br>
k<sub>1</sub> =h*F[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>] where F[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>] is assumed to be z<sub>n</sub> =dy/dx, <br>
l<sub>1</sub> = h*g[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>] where g[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>]=dz/dx<br>
k<sub>2</sub> =h*F[x<sub>n</sub>+h/2,y<sub>n</sub>+k<sub>1</sub>/2,z<sub>n</sub>+l<sub>1</sub>/2] where F[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>] is assumed to be z<sub>n</sub> , <br>
l<sub>2</sub> =h*g[x<sub>n</sub>+h/2,y<sub>n</sub>+k<sub>1</sub>/2,z<sub>n</sub>+l<sub>1</sub>/2] where g[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>]=dz/dx<br>
k<sub>3</sub> =h*F[x<sub>n</sub>+h/2,y<sub>n</sub>+k<sub>2</sub>/2,z<sub>n</sub>+l<sub>2</sub>/2] where F[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>] is assumed to be z<sub>n</sub> , <br>
l<sub>3</sub> =h*g[x<sub>n</sub>+h/2,y<sub>n</sub>+k<sub>2</sub>/2,z<sub>n</sub>+l<sub>2</sub>/2] where g[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>]=dz/dx<br>
k<sub>4</sub> =h*F[x<sub>n</sub>+h,y<sub>n</sub>+k<sub>3</sub>,z<sub>n</sub>+l<sub>3</sub>] where F[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>] is assumed to be z<sub>n</sub> , <br>
l<sub>4</sub> =h*g[x<sub>n</sub>+h,y<sub>n</sub>+k<sub>3</sub>,z<sub>n</sub>+l<sub>3</sub>] where g[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>]=dz/dx<br>
y<sub>n+1</sub>=y<sub>n</sub>+(1/6)*(k<sub>1</sub>+ 2*k<sub>2</sub> +2*k<sub>3</sub> +k<sub>4</sub>)<br>
z<sub>n+1</sub>=z<sub>n</sub>+(1/6)*(l<sub>1</sub>+ 2*l<sub>2</sub> +2*l<sub>3</sub> +l<sub>4</sub>)<br>


</p>

<h2>LibraryManagementSystem->src/main/java/com/expr/LibraryManagementSys.java </h2>
<p> This is console based library Management System application which has basic modules:</p>
<p><b>Customer reg</b>: enters name,id,password(hashed while storage)</p>
<p><b>customer login</b>: enters name,id, password</p>
<p><b>Business module</b>: add book, remove book,display available and rented books</p>
<p><b>Customer module</b>: rent book, return book</p>

<b>Limitations</b>
<p>1 Console based app. </p>
<p>2 Verification mechanism not included for business</p>
<p>3 No payment mechanism</p>
<p>4 No history maintained</p>
