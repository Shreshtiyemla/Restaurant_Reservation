<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f2f2f2;
        }
        h2 {
            color: #333;
        }
        p {
            margin-bottom: 10px;
        }
        .back-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .back-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Reservation Confirmation</h2>
    <p>Reservation made successfully for Customer ID: ${customerId}</p>
    <p>Total Reward Points: ${rewardPoints}</p>
    <form action="/" method="get">
        <button type="submit" class="back-button">Back to Main Page</button>
    </form>
</body>
</html>
