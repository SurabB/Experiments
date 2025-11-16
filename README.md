

<h1> Experimental</h1>
<h2>Euler and Rk2 converter-->src/main/java/com/expr/EulerRk2Converter.java</h2>
<p> Takes initial values x<sub>0</sub>, y<sub>0</sub>, h, func(x,y) and no of itr and perform necessary opr</p>
<p>method firstOrderDiffUsingEuler()-> follows formula: y<sub>n+1</sub> = y<sub>n</sub>+h * F[x<sub>n</sub>, y<sub>n</sub>], and x<sub>n+1</sub>= x<sub>n</sub> + h</p>
<p>method secondOrderDiffUsingEuler()-> follows formula: y<sub>n+1</sub> = y<sub>n</sub>+h * F[x<sub>n</sub>, y<sub>n</sub>,z<sub>n</sub>], where[x,y,z] is assumed to be dy/dx=z and x<sub>n+1</sub>= x<sub>n</sub> + h</p>
<p>z<sub>n+1</sub>=z<sub>n</sub>+h*g[x<sub>n</sub>,y<sub>n</sub>,z<sub>n</sub>] ,where g[x,y,z] is assumed to be dz/dx
<br>
and x<sub>n+1</sub>= x<sub>n</sub> + h</p>

<p>method rk2()-> follows formula: y<sub>n+1</sub> = y<sub>n</sub>+(h/2) * [F(x<sub>n</sub>, y<sub>n</sub>) + F(x<sub>n+1</sub>,y<sub>n+1</sub> <sup>euler</sup>)]  and x<sub>n+1</sub>=x<sub>n</sub> + h <br> and y<sub>n+1</sub> <sup>euler</sup>
  =y<sub>n</sub> + h * F[x<sub>n</sub>, y<sub>n</sub>]</p>

<h2>LibraryManagementSystem->src/main/java/com/expr/LibraryManagementSys.java </h2>
<p> This is console based library Management System application which has basic modules:</p>
<p><b>Customer reg</b>: enters name,id,password(hashed while storage)</p>
<p><b>customer login</b>: enters name,id, password</p>
<p><b>Business module</b>: add book, remove book,display available and rented books</p>
<p><b>Customer module</b>: rent book, return book</p>

<b>Limitations</b>
<p>1 Console based app. </p>
<p>2 Verification mechnaism not included for business</p>
<p>3 No payment mechanism</p>
<p>4 No history maintained</p>
