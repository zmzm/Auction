<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../../jquery.min.js"></script>
    <script type="text/javascript"
            src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<body>

<h1 align="center">Auction</h1>

<div id="container">
</div>

<script>
    (function() {
        setInterval(function() {
            $.get('http://localhost:8080/Server/game/item', function(html) {
                if(html) {
                    $('#container').html(html);
                }
            });
        }, 1500);
    })();
</script>
</body>
</html>