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
            background-color: #f7f7f7;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            padding: 8px;
            text-align: center;
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
    <h1>View Restaurants</h1>
    <table>
        <tr>
            <th>Restaurant ID</th>
            <th>Restaurant Name</th>
            <th>Category</th>
            <th>Address</th>
            <th>Phone No</th>
            <th>Opening Hours</th>
            <th>Closing Hours</th>
            <th>Add Table</th>
            <th>View Tables</th>
            <th>Add Slot</th>
        </tr>
        <%
            List<RestaurantModel> restaurantList = (List<RestaurantModel>) request.getAttribute("restaurantModelsList");
            if(restaurantList != null) {
                for(RestaurantModel restaurant : restaurantList) {
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
                    <form action="/addTable" method="post">
                        <input type="hidden" name="restaurantId" value="<%= restaurant.getRestaurantId() %>" >
                        <input type="submit" value="Add Table">
                    </form>
                </td>
                <td>
                    <form action="/viewRestaurantTables" method="post">
                        <input type="hidden" name="restaurantId" value="<%= restaurant.getRestaurantId() %>" >
                        <input type="submit" value="View Table">
                    </form>
                </td>
                <td>
                    <form action="/slot" method="post">
                        <input type="hidden" name="restaurantId" value="<%= restaurant.getRestaurantId() %>" >
                        <input type="submit" value="Add Slots">
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
