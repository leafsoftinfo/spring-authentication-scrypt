<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
  <title>${title}</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
  <link href="<c:url value='/resources/css/signin.css'/>" rel="stylesheet">
</head>
<body>

<div class="container">
  <h2>Spring security scrypt :: Registration form <a href="<c:url value='/login'/>" class="pull-right btn btn-primary">Login here</a></h2>
  <form:form accept-charset="UTF-8" commandName="personForm" method="post">
    <div class="form-group">
      <form:label path="username">Username:</form:label>
      <form:input type="username" class="form-control" path="username" placeholder="Enter username" />
      <form:errors path="username" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="form-group">
      <form:label path="pwd">Password:</form:label>
      <form:input type="password" class="form-control" path="pwd" placeholder="Enter password" />
      <form:errors path="pwd" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="form-group">
      <form:label path="rePwd">Retype Password:</form:label>
      <form:input type="password" class="form-control" path="rePwd" placeholder="Retype password" />
      <form:errors path="rePwd" cssClass="alert alert-danger" element="div" />
    </div>
    <button type="submit" class="btn btn-lg btn-primary btn-block">Submit</button>
  </form:form>
</div>

</body>
</html>