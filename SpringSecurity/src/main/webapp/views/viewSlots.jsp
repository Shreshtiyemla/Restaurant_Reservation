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
        td:nth-child(5) {
            color: green; /* Change the color for available slots */
        }
        td[colspan="5"] {
            text-align: center;
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
        </tr>
        <%
            List<SlotModel> slotModels = (List<SlotModel>) request.getAttribute("slotModel");
            if (slotModels != null && !slotModels.isEmpty()) {
                for (SlotModel slotModel : slotModels) {
        %>
            <tr>
                <%-- Access slotModel properties using scriptlet --%>
                <td><%= slotModel.getSlotId() %></td>
                <td><%= slotModel.getSlotStartTime() %></td>
                <td><%= slotModel.getSlotEndTime() %></td>
                <td><%= slotModel.getSlotDuration().toHours() %></td>
                <td><%= slotModel.isAvailable() %></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="5">No slots available</td>
            </tr>
        <% } %>
    </table>
</body>
</html>
