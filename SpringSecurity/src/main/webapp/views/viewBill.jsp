<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.Restaurant.SpringSecurity.Model.BillModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bill Details</title>
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
        .pay-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .pay-btn:hover {
            background-color: #45a049;
        }
        .message {
            margin-top: 10px;
            text-align: center;
            color: #008000; /* Green color for success message */
        }
    </style>
</head>
<body>
    <h1>Bill Details</h1>

    <table>
        <tr>
            <th>Bill ID</th>
            <th>Reservation ID</th>
            <th>Customer ID</th>
            <th>Bill Amount</th>
            <th>Date</th>
            <th>Action</th>
            <th>Bill Status</th>
        </tr>

        <%
            BillModel billModel = (BillModel) request.getAttribute("bills");
            if (billModel != null) {
        %>
        <tr>
            <td><%= billModel.getBillId() %></td>
            <td><%= billModel.getReservation().getReservationId() %></td>
            <td><%= billModel.getCustomerBill().getCustomerId() %></td>
            <td><%= billModel.getBillAmount() %></td>
            <td><%= billModel.getDate() %></td>
            <td>
                <form action="/processPaymentAndRewardPoints" method="post">
                    <input type="hidden" name="customerId" value="${customerId}">
                    <input type="hidden" name="reservationId" value="<%= billModel.getReservation().getReservationId() %>">
                    <input type="hidden" name="tableId" value="<%= billModel.getReservation().getTableReserving().getTableId() %>">
                    <input type="hidden" name="slotId" value="<%= billModel.getReservation().getSlot().getSlotId() %>">
                    <input type="hidden" name="tablePrice" value="<%= billModel.getBillAmount() %>">
                    <input type="hidden" name="billId" value="<%= billModel.getBillId() %>">
                    <input type="submit" class="pay-btn" value="Process Payment and Generate Reward Points">
                </form>
                <div class="message">
                    ${message} <!-- Display success message or other data from the controller -->
                </div>
            </td>
            <td><%= billModel.isBillStatus() %></td>
        </tr>
        <%
            } else {
        %>
        <tr>
            <td colspan="5">No bill found</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
