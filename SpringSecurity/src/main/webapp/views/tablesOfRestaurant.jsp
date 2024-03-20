<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Restaurant.SpringSecurity.Model.AvailableTablesModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Tables</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
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
    <h1>View Tables</h1>
    <table>
        <tr>
            <th>Table ID</th>
            <th>Capacity</th>
            <th>Availability</th>
            <th>Price</th>
            <th>Slot</th>
        </tr>
        <%
            List<AvailableTablesModel> tableList = (List<AvailableTablesModel>) request.getAttribute("availableTablesModelList");
            if (tableList != null) {
                for (AvailableTablesModel table : tableList) {
        %>
                    <tr>
                        <td><%= table.getTableId() %></td>
                        <td><%= table.getCapacity() %></td>
                        <td><%= table.isAvailable() %></td>
                        <td><%= table.getPrice() %></td>
                        <td>
                           <form action="/viewSlotsByCustomer" method="post">
                                <input type="hidden" name="restaurantId" value="<%= table.getRestaurant().getRestaurantId() %>">
                                <input type="hidden" name="table" value="<%= table.getTableId()%>">
                                <input type="submit" value="View Slots">
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
