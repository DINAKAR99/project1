<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<%@page isELIgnored ="false"%>
<!doctype html>
<html lang="en" >
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.rtl.min.css" integrity="sha384-nU14brUcp6StFntEOOEBvcJm4huWjB0OcIeQ3fltAfSmuZFrkAif0T+UtNGlKKQv" crossorigin="anonymous">

    <title><c:out value="${page}"></c:out></title>
  </head>
  <body>
<div class="container mt-3">
<h1 class="text-center">Welcome  to TODO Manger</h1>
<c:if test="${not empty msg}">
<div class="alert alert-success">
<b><c:out value="${msg}"></c:out></b>
</div>
</c:if>
<div class="row mt-5">
<div class="col-md-2">

<div class="list-group">
  <button type="button" class="list-group-item list-group-item-action active" aria-current="true">
    The current button
  </button>
  <a href="<c:url value='/add'/>" class="list-group-item list-group-item-action">ADD TODO</a>
  <a href="<c:url value='/home'/>" class="list-group-item list-group-item-action">View TODO</a>
  
</div>
</div>
<div class="col-md-10">
<c:if test ="${page=='HOME'}">
<h1 class="text-center">All TODOs</h1>
<c:forEach items="${todos}" var="t">
<div class="card">
<div class="card-body">
<h3><c:out value ="${t.todoTitle}"></c:out></h3>
<p><c:out value ="${t.todoContent}"></c:out></p>
</div>
</div>
</c:forEach>

</c:if>
<c:if test="${page=='add'}">
<h1 class="text-center">Add TODO</h1>
<form:form action="saveTodo" method="post" modelAttribute="todo">
<div class="form-group">
<form:input path="todoTitle" class="form-control" placeholder="enter your todo"/>
</div>
<div class="form-group">
<form:textarea path="todoContent" class="form-control" placeholder="Enter your TODO content" style="height:300px;"/>
</div>
<div class="cointainer text-center">
<button class="btn btn-outline-success" type="submit">Add Todo </button>
</div>
</form:form>

</c:if>
</div>


    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    -->
  </body>
</html>
