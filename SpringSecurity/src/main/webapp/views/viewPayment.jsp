<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
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
<div class="container">
    <h1>Payment Page</h1>
    <p>Amount To Pay: ${billAmount}</p>
    <form action="/useRewardPoints" method="post">
        <!-- Hidden fields to pass customerId, billAmount, and rewardPointsToUse -->
        <input type="hidden" name="customerId" value="${customerId}">
        <input type="hidden" name="billAmount" value="${billAmount}">
        <input type="hidden" name="tablePrice" value="${tablePrice}">
        <input type="hidden" name="slotId" value="${slotId}">
        <input type="hidden" name="billId" value="${billId}">
        <input type="hidden" name="applyRewardPoints" value="${applyRewardPoints}">
        <input type="submit" value="Pay">
    </form>
</div>
</body>
</html>
