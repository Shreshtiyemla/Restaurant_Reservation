<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Table to Restaurant</title>
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
        input[type="number"],
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
    <h1>Add Table to Restaurant</h1>
    <form action="/addingTables" method="post">
        <label for="tableId">Table ID:</label><br>
        <input type="text" id="tableId" name="tableId"><br>

        <label for="capacity">Capacity:</label><br>
        <input type="number" id="capacity" name="capacity" min="1"><br>

        <label for="isAvailable">Is Available:</label><br>
        <select id="isAvailable" name="isAvailable">
            <option value="">Select</option>
            <option value="true">Yes</option>
            <option value="false">No</option>
        </select><br>
        <label for="price">Price:</label><br>
        <input type="number" id="price" name="price" min="0.01" step="0.01"><br>
        <input type="submit" value="Add Table">
    </form>
</body>
</html>
