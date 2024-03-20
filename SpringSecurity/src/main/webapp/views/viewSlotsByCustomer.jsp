<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Restaurant.SpringSecurity.Model.SlotModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Slots</title>
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
        input[type="submit"]:disabled {
            background-color: #cccccc;
            cursor: not-allowed;
        }
    </style>
</head>
<body>
    <h1>Slots</h1>
    <table>
        <tr>
            <th>Slot Id</th>
            <th>Slot Start Time</th>
            <th>Slot End Time</th>
            <th>Slot Duration (hours)</th>
            <th>Available</th>
            <th>Reserve Slot</th>
        </tr>
        <%-- Access model attribute directly using scriptlet --%>
        <%
            List<SlotModel> slotModels = (List<SlotModel>) request.getAttribute("slotModel");
            for (SlotModel slotModel : slotModels) {
        %>
            <tr>
                <%-- Access slotModel properties using scriptlet --%>
                <td><%= slotModel.getSlotId() %></td>
                <td><%= slotModel.getSlotStartTime() %></td>
                <td><%= slotModel.getSlotEndTime() %></td>
                <td><%= slotModel.getSlotDuration() %></td>
                <td><%= slotModel.isAvailable() %></td>
                <td>
                    <% if (slotModel.isAvailable()) { %>
                        <form action="/reserveTable" method="post">
                            <input type="hidden" name="customerId" value="${customerId}">
                            <input type="hidden" name="slot" value="<%= slotModel.getSlotId() %>">
                            <input type="submit" value="Reserve">
                        </form>
                    <% } else { %>
                        <input type="submit" value="Reserved" disabled>
                    <% } %>
                </td>
            </tr>
        <% } %>
    </table>
</body>
</html>
