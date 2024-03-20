<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Restaurant.SpringSecurity.Entity.Reservation" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booked Slots</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        td form {
            display: inline-block;
        }
        td form input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        td form input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Booked Slots</h1>
    <table>
        <tr>
            <th>Reservation ID</th>
            <th>Table ID</th>
            <th>Starting Time</th>
            <th>Ending Time</th>
            <th>Cancel Reservation</th>
            <th>Payment Status</th>
        </tr>
        <%
            List<Reservation> reservationList = (List<Reservation>) request.getAttribute("bookedSlots");
            if (reservationList != null) {
                for (Reservation reservation : reservationList) {
        %>
            <tr>
                <td><%= reservation.getReservationId() %></td>
                <td><%= reservation.getTableReserving().getTableId() %></td>
                <td><%= reservation.getSlot().getSlotStartTime() %></td>
                <td><%= reservation.getSlot().getSlotEndTime() %></td>
                <td>
                    <form action="/cancelReservation" method="post">
                        <input type="hidden" name="reservationId" value="<%= reservation.getReservationId() %>">
                        <input type="hidden" name="slotId" value="<%= reservation.getSlot().getSlotId() %>">
                        <input type="submit" value="Cancel Reservation">
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
