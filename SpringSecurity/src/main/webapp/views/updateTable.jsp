<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Table</title>
</head>
<body>
    <h1>Update Table</h1>
    <form action="/updateTable" method="post">
        <input type="hidden" id="tableId" name="tableId" value="${tableId}"><br>

        <label for="capacity">Capacity:</label>
        <input type="number" id="capacity" name="capacity"><br>

        <label for="isAvailable">Availability:</label>
        <select id="isAvailable" name="isAvailable">
            <option value="true">Available</option>
            <option value="false">Not Available</option>
        </select><br>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price"><br>
        <input type="hidden" id="restaurantId" name="restaurantId" value="${restaurantId}" required>

        <input type="submit" value="Update Table">
    </form>
</body>
</html>
