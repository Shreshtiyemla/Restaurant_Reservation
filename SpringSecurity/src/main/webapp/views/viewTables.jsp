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
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
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
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 8px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
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
            <th>Delete</th>
        </tr>
        <% if (request.getAttribute("availableTablesModelList") != null) {
                List<AvailableTablesModel> tableList = (List<AvailableTablesModel>) request.getAttribute("availableTablesModelList");
                for(AvailableTablesModel table : tableList) { %>
                    <tr>
                        <td><%= table.getTableId() %></td>
                        <td><%= table.getCapacity() %></td>
                        <td><%= table.isAvailable() %></td>
                        <td><%= table.getPrice() %></td>

                        <td>
                            <form action="/viewSlots" method="post">
                                <input type="hidden" name="restaurantId" value="<%= request.getAttribute("restaurantId") %>" >
                                <input type="hidden" name="tableId" value="<%= table.getTableId() %>" >

                                <input type="submit" value="View Slots">
                            </form>
                        </td>
                    </tr>
            <% }
        } %>
    </table>
</body>
</html>
