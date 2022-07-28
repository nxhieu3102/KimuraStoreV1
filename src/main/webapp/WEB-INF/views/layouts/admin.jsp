<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no"/>
    <title>Kimura Store</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"/>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <link rel="stylesheet" href="<c:url value="/assets/user/font/fontawesome-free-5.15.4-web/css/all.min.css" /> "/>
    <link rel="stylesheet" href="<c:url value="/assets/admin/css/product.css" /> "/>
    <link rel="stylesheet" href="<c:url value="/assets/user/font/1.3.0/css/line-awesome.css" /> "/>
    <link rel="stylesheet" href="<c:url value="/assets/user/font/1.3.0/css/line-awesome.min.css" />"/>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&amp;display=swap"
          rel="stylesheet"/>
    <link rel="icon" href="<c:url value = "/assets/user/img/LOGO.png" />" type="image/x-icon"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>
<decorator:body/>

<script type="text/javascript" src="<c:url value = "/assets/user/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value = "/assets/user/js/jquery-migrate-1.2.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value = "/assets/user/js/slick.min.js" />"></script>
<script type="text/javascript" src="<c:url value = "/assets/user/js/index.js" />"></script>
<decorator:getProperty property="page.script"></decorator:getProperty>

</body>

</html>