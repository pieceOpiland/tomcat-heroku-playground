<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tomcat on Heroku</title>
</head>
<body>
    <div>This should deploy.</div>
    <div><%= getServletContext().getInitParameter("theValue") %></div>
</body>
</html>