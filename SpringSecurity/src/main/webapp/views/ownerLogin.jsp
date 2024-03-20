<%@page language="java" %>
<%@ page import="com.example.Restaurant.SpringSecurity.Model.OwnerModel" %>
<html>
<head>
    <title>Login</title>
    <% OwnerModel ownerModel=(OwnerModel) request.getAttribute("ownerModel"); %>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            margin-top: 50px;
        }
        p {
            color: #333;
            font-size: 18px;
            margin-bottom: 20px;
        }
        form {
            display: inline-block;
            text-align: left;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"] {
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
    </style>
</head>
<body>
    <p>Please enter your credentials</p>
    <form action="/ownerLogin">
        <label for="username">Enter Owner Username:</label><br>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Enter Owner Password:</label><br>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
