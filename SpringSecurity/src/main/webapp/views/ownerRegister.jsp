<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Owner Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            margin-top: 50px;
        }
        h1 {
            color: #333;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 20px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
        }
        .checkbox-container label {
            display: inline;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <h1>Owner Registration</h1>
    <form:form action="/ownerRegister" modelAttribute="ownerModel" method="post">
        <label>Owner ID:</label><br>
        <form:input path="ownerId"/><br>
        <form:errors path="ownerId" cssClass="error"/><br>

        <label>Owner Name:</label><br>
        <form:input path="ownerName"/><br>
        <form:errors path="ownerName" cssClass="error"/><br>

        <label>Owner Username:</label><br>
        <form:input path="username"/><br>
        <form:errors path="username" cssClass="error"/><br>

        <label>Password:</label><br>
        <form:password path="password"/><br>
        <form:errors path="password" cssClass="error"/><br>

        <label>Email:</label><br>
        <form:input path="email"/><br>
        <form:errors path="email" cssClass="error"/><br>

        <label>Mobile Number:</label><br>
        <form:input path="mobileNo"/><br>
        <form:errors path="mobileNo" cssClass="error"/><br>

        <label>Select Role(s):</label><br>
        <div class="checkbox-container">
            <input type="checkbox" id="customer" name="roles" value="CUSTOMER">
            <label for="customer">Customer</label>
            <input type="checkbox" id="owner" name="roles" value="OWNER">
            <label for="owner">Owner</label>
        </div>

        <input type="submit" value="Register">
    </form:form>
</body>
</html>
