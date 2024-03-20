<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Restaurant.SpringSecurity.Model.ReservationModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Reservations</title>
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
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f0f0f0;
        }
        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        td[colspan="4"] {
            text-align: center;
            font-style: italic;
        }
    </style>
</head>
<body>
    <h1>All Reservations</h1>
    <table>
        <thead>
            <tr>
                <th>Reservation ID</th>
                <th>Customer Name</th>
                <th>Customer Email</th>
                <th>Table Id</th>
                <th>Slot Id</th>
                <th>Slot StartTime </th>
                <th>Slot EndTime </th>


                <!-- Add more columns here if needed -->
            </tr>
        </thead>
        <tbody>
            <%
                List<ReservationModel> reservationModelList = (List<ReservationModel>) request.getAttribute("reservationModelsList");
                if (reservationModelList != null) {
                    for (ReservationModel reservationModel : reservationModelList) {
                        String customerName = "";
                        String customerEmail = "";
                        if (reservationModel.getCustomerReserving() != null) {
                            customerName = reservationModel.getCustomerReserving().getCustomerName();
                            customerEmail = reservationModel.getCustomerReserving().getCustomerEmail();
                        }
            %>
                <tr>
                    <td><%= reservationModel.getReservationId() %></td>
                    <td><%= customerName %></td>
                    <td><%= customerEmail %></td>
                    <td><%= reservationModel.getTableReserving().getTableId() %></td>
                    <td><%= reservationModel.getSlot().getSlotId() %></td>
                    <td><%= reservationModel.getSlot().getSlotStartTime() %></td>
                    <td><%= reservationModel.getSlot().getSlotEndTime() %></td>
                    <!-- Add more cells here to display additional customer details -->
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4">No reservations for this owner</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
