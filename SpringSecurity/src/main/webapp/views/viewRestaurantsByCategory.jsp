<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Restaurant.SpringSecurity.Model.RestaurantModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurants by Category</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
        p {
            text-align: center;
            margin-top: 10px;
            margin-bottom: 20px;
            font-size: 18px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 0 auto;
            background-color: #fff;
        }
        th, td {
            border: 1px solid #dddddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        form {
            display: inline;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Restaurants by Category</h1>
    <p>Category: ${restaurant.category}</p>

    <table>
        <tr>
            <th>Restaurant ID</th>
            <th>Restaurant Name</th>
            <th>Category</th>
            <th>Address</th>
            <th>Phone No</th>
            <th>Opening Hours</th>
            <th>Closing Hours</th>
            <th>View Tables</th>
        </tr>
        <%
            List<RestaurantModel> restaurantList = (List<RestaurantModel>) request.getAttribute("restaurantModelList");
            if (restaurantList != null) {
                for (RestaurantModel restaurant : restaurantList) {
        %>
        <tr>
            <td><%= restaurant.getRestaurantId() %></td>
            <td><%= restaurant.getRestaurantName() %></td>
            <td><%= restaurant.getCategory() %></td>
            <td><%= restaurant.getAddress() %></td>
            <td><%= restaurant.getPhoneNo() %></td>
            <td><%= restaurant.getOpeningHours() %></td>
            <td><%= restaurant.getClosingHours() %></td>
            <td>
                <form action="/tablesOfRestaurant" method="post">
                    <input type="hidden" name="restaurantId" value="<%= restaurant.getRestaurantId() %>">
                    <input type="submit" value="View Tables">
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
