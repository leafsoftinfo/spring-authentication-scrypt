<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>${title}</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
</head>
<body>

    <div class="container">

      <h2>Spring security scrypt :: Login here <a href="<c:url value='/register'/>" class="pull-right btn btn-warning">Register here</a></h2>
      <form method="post" action="<c:url value='/security_check'/>">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" name="username" class="form-control" placeholder="Username" required autofocus>
        </div>
        <div class="form-group">
            <label for="inputPassword">Password:</label>
            <input type="password" name="password" class="form-control" placeholder="Password" required>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>