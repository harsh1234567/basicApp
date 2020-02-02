
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!--link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script type="text/javascript">
  function validation(){
      var firstName=document.getElementById("firstName").value;
      var lastName=document.getElementById("lastName").value;
      alert("nhi cha"+firstName); 
      if(firstName!="" && lastName!=""){
    	 
    	  document.getElementById("msg").style.display="none";
          return false;
        }
       else{
    	   alert("dff");
           
     	  document.getElementById("msg").value="please set the value";

     	  document.getElementById("msg").style.display ="block";
         
         return false;
         
    	 }  
      
      return false;
             
               
   } 
   //document.getElementById("msg").style.display="none";
          
 </script>
</head>
<body>
<br/>
<br/>
<br/>
<div style="margin:100px">
    ${message}
    
<div id="msg" class="alert alert-danger" role="danger">
    
 </div>    
<div class="alert alert-primary" role="alert" >
    <form method="post" action="add" >
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputFirstname">First Name</label>
    <input type="text" class="form-control"  name="firstname" id="firstName">
  </div>
  <div class="form-group">
    <label for="exampleInputLastName">Last Name</label>
    <input type="text" class="form-control" name="lastname" id="LastName">
  </div>
  
  <button type="submit" class="btn btn-success"  >Register</button>

</form>
</div>
<div class="table-responsive">
 
<table class="table">
 <thead>
      <tr>
        <th>Email</th>

        <th>Password</th>
      
        <th>Firstname</th>
        <th>Lastname</th>
      </tr>
    </thead>
	    <tbody>
	<c:if test="${not  empty email}">
     
     <c:forEach var="ls" items="${list}">
     
     
      <tr class="warning">
        <td>${ls.email}</td>
        <td>${ls.password}</td>
         <td>${ls.firstName}</td>
         <td>${ls.lastName}</td>
         
         <td><Button class="btn btn-success">delete</Button></td>
      </tr>
      </c:forEach>
     </c:if>
    </tbody>
  </table>

</table>
</div>

</div>
<body>
</html>