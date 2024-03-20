<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Restaurant.SpringSecurity.Model.RestaurantModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Restaurants</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
        .restaurant-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .restaurant-container {
            width: 300px;
            margin: 20px;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .restaurant-container p {
            margin: 5px 0;
        }
        .restaurant-container form {
            text-align: center;
        }
        .restaurant-container input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .restaurant-container input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>View Restaurants</h1>
    <!-- Button to view restaurants based on category -->
    <form action="/restaurantsByCategory" method="post">
        <input type="hidden" name="customerId" value="${customerId}">
        <label for="category">Select Category:</label>
        <select id="category" name="category">
            <option value="Veg">Veg</option>
            <option value="Non-Veg">Non-Veg</option>
            <option value="Both">Both</option>
        </select>
        <input type="submit" value="View Restaurants">
    </form>
    <div class="restaurant-list">
        <%
            List<RestaurantModel> restaurantList = (List<RestaurantModel>) request.getAttribute("restaurantModelList");
            if (restaurantList != null) {
                for (RestaurantModel restaurant : restaurantList) {
        %>
                    <div class="restaurant-container">
                        <p><strong>Restaurant ID:</strong> <%= restaurant.getRestaurantId() %></p>
                        <p><strong>Restaurant Name:</strong> <%= restaurant.getRestaurantName() %></p>
                        <p><strong>Category:</strong> <%= restaurant.getCategory() %></p>
                        <p><strong>Address:</strong> <%= restaurant.getAddress() %></p>
                        <p><strong>Phone No:</strong> <%= restaurant.getPhoneNo() %></p>
                        <p><strong>Opening Hours:</strong> <%= restaurant.getOpeningHours() %></p>
                        <p><strong>Closing Hours:</strong> <%= restaurant.getClosingHours() %></p>
                        <form action="/tablesOfRestaurant" method="post">
                            <input type="hidden" name="restaurantId" value="<%= restaurant.getRestaurantId() %>">
                            <input type="submit" value="View Tables">
                        </form>
                    </div>
        <%
                }
            }
        %>
    </div>
</body>
</html>
