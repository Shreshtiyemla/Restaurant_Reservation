<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Registration</title>
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
        input[type="email"],
        input[type="checkbox"] {
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
    </style>
</head>
<body>
    <h1>Customer Registration</h1>
    <form:form action="/customerRegistering" modelAttribute="customerModel">
        <label for="customerId">Enter Customer ID:</label><br>
        <form:input path="customerId" id="customerId"/><br>
        <form:errors path="customerId" cssClass="error"/><br>

        <label for="customerName">Enter Customer Name:</label><br>
        <form:input path="customerName" id="customerName"/><br>
        <form:errors path="customerName" cssClass="error"/><br>

        <label for="username">Enter Customer Username:</label><br>
        <form:input path="username" id="username"/><br>
        <form:errors path="username" cssClass="error"/><br>

        <label for="password">Enter Customer Password:</label><br>
        <form:input path="password" id="password" type="password"/><br>
        <form:errors path="password" cssClass="error"/><br>

        <label for="customerEmail">Enter Customer Email:</label><br>
        <form:input path="customerEmail" id="customerEmail" type="email"/><br>
        <form:errors path="customerEmail" cssClass="error"/><br>

        <label for="address">Enter Customer Address:</label><br>
        <form:input path="address" id="address"/><br>
        <form:errors path="address" cssClass="error"/><br>

        <label for="phoneNumber">Enter Customer Phone Number:</label><br>
        <form:input path="phoneNumber" id="phoneNumber"/><br>
        <form:errors path="phoneNumber" cssClass="error"/><br>

        <label>Select Role(s):</label><br>
        <input type="checkbox" id="customer" name="roles" value="CUSTOMER">
        <label for="customer">Customer</label><br>
        <input type="checkbox" id="owner" name="roles" value="OWNER">
        <label for="owner">Owner</label><br>

        <input type="submit" value="Register">
    </form:form>
    <form action="/customerPage"> <!-- Adjust the action attribute value as needed -->
        <input type="submit" value="Back to Dashboard">
    </form>
</body>
</html>
