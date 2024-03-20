<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f7f7f7;
        }
        form {
            width: 50%;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            display: block;
            margin: 20px auto 0;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Payment Page</h1>
    <form action="/pay" method="post">
        <label for="customerId">Customer ID:</label>
        <input type="text" id="customerId" name="customerId" value="<%= request.getAttribute("customerId") %>" readonly>
        <label for="tableId">Table ID:</label>
        <input type="text" id="tableId" name="tableId" value="<%= request.getAttribute("tableId") %>" readonly>
        <label for="slotId">Slot ID:</label>
        <input type="text" id="slotId" name="slotId" value="<%= request.getAttribute("slotId") %>" readonly>
        <label for="reservationId">Reservation ID:</label>
        <input type="text" id="reservationId" name="reservationId" value="<%= request.getAttribute("reservationId") %>" readonly>
        <label for="billId">Bill ID:</label>
        <input type="text" id="billId" name="billId" value="<%= request.getAttribute("billId") %>" readonly>
        <label for="tablePrice">Table Price:</label>
        <input type="text" id="tablePrice" name="tablePrice" value="<%= request.getAttribute("tablePrice") %>" readonly>
        <% int rewardPoints = (int) request.getAttribute("rewardPoints");
           if (rewardPoints > 0) { %>
            <label for="discountPrice">Discount Price:</label>
            <input type="text" id="discountPrice" name="discountPrice" value="<%= request.getAttribute("discountPrice") %>" readonly>
            <label for="rewardPoints">Available Reward Points:</label>
            <input type="number" name="rewardPoints" value="<%= rewardPoints %>" readonly>
            <label>Apply Reward Points:</label>
            <input type="radio" id="applyRewardPointsYes" name="applyRewardPoints" value="yes" required />
            <label for="applyRewardPointsYes">Yes</label>
            <input type="radio" id="applyRewardPointsNo" name="applyRewardPoints" value="no" required />
            <label for="applyRewardPointsNo">No</label>
        <% } else { %>
            <input type="hidden" id="applyRewardPointsYes" name="applyRewardPoints" value="no"  />
            <input type="hidden" id="discountPrice" name="discountPrice" value="<%= request.getAttribute("discountPrice") %>" readonly>
        <% } %>
        <label for="paymentMethod">Payment Method:</label>
        <select id="paymentMethod" name="paymentMethod">
            <option value="creditCard">Credit Card</option>
            <option value="paypal">PayPal</option>
            <option value="bankTransfer">Bank Transfer</option>
        </select>
        <input type="submit" value="Pay">
    </form>
</body>
</html>
