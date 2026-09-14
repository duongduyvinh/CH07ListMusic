<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <header>
        <h1>Download registration</h1>
    </header>
    <section>
        <p>To register for our downloads, enter your name and email address below. Then, click on the Submit button.</p>
        
        <form action="download" method="post">
            <input type="hidden" name="action" value="registerUser">
            <!-- Giữ lại mã sản phẩm để chuyển hướng sau khi đăng ký thành công -->
            <input type="hidden" name="productCode" value="${param.productCode}">
            
            <label>Email:</label>
            <input type="email" name="email" value="" required><br>
            
            <label>First Name:</label>
            <input type="text" name="firstName" value="" required><br>
            
            <label>Last Name:</label>
            <input type="text" name="lastName" value="" required><br>
            
            <label>&nbsp;</label>
            <input type="submit" value="Register">
        </form>
    </section>
</body>
</html>