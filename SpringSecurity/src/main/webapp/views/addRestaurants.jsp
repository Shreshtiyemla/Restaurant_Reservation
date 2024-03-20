<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Adding Restaurants</title>
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
        input[type="time"],
        select {
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
    <h1>Adding Restaurants</h1>
    <form:form action="/addRestaurant" modelAttribute="restaurantModel">
        <label for="restaurantId">Restaurant ID:</label><br>
        <form:input path="restaurantId" id="restaurantId"/><br>
        <form:errors path="restaurantId" cssClass="error"/><br>

        <label for="restaurantName">Restaurant Name:</label><br>
        <form:input path="restaurantName" id="restaurantName"/><br>
        <form:errors path="restaurantName" cssClass="error"/><br>

        <label for="category">Category:</label><br>
        <form:select path="category" id="category">
            <form:option value="Veg">Veg</form:option>
            <form:option value="Non-Veg">Non-Veg</form:option>
            <form:option value="Both">Both</form:option>
        </form:select><br>
        <form:errors path="category" cssClass="error"/><br>

        <label for="address">Address:</label><br>
        <form:input path="address" id="address"/><br>
        <form:errors path="address" cssClass="error"/><br>

        <label for="phoneNo">Phone No:</label><br>
        <form:input path="phoneNo" id="phoneNo"/><br>
        <form:errors path="phoneNo" cssClass="error"/><br>

        <label for="openingHours">Opening Hours:</label><br>
        <form:input path="openingHours" id="openingHours" type="time"/><br>
        <form:errors path="openingHours" cssClass="error"/><br>

        <label for="closingHours">Closing Hours:</label><br>
        <form:input path="closingHours" id="closingHours" type="time"/><br>
        <form:errors path="closingHours" cssClass="error"/><br>

        <input type="submit" value="Add">
    </form:form>
</body>
</html>
