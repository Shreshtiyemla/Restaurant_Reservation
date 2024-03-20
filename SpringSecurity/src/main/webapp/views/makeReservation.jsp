<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make Reservation</title>
</head>
<body>
<h2>Reservation Form</h2>
<form action="/makeReservation" method="post">
    <label for="customerId">Customer ID:</label>
    <input type="text" id="customerId" name="customerId" required><br><br>

    <label for="billAmount">Bill Amount:</label>
    <input type="text" id="billAmount" name="billAmount" required><br><br>

    <label for="useRewardPoints">Use Reward Points:</label>
    <input type="checkbox" id="useRewardPoints" name="useRewardPoints"><br><br>

    <input type="submit" value="Make Reservation">
</form>
</body>
</html>
