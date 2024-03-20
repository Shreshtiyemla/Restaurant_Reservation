<%@page language="java" %>
<html>
<head>
    <title>Owner</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            padding-top: 50px;
        }
        h1 {
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
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
<div>
    <h1>Please Continue with Payment Sections</h1>
    <form action="/bill" method="post">
        <input type="hidden" name="reservationId" value="${reservationId}">
        <input type="hidden" name="customerId" value="${customerId}">
        <input type="submit" value="Generate Bill">
    </form>
</div>
</body>
</html>
