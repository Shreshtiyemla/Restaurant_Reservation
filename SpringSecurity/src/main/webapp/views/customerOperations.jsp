<%@page language="java" %>
<html>
<head>
    <title>Customer Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            margin-top: 50px;
        }
        div {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        form {
            margin-bottom: 20px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        a {
            text-decoration: none;
            color: #4CAF50;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div>
    <form action="/viewAllRestaurants">
        <input type="submit" value="View All Restaurants">
        <input type="hidden" name="customerId" value="${customerId}">
    </form>
    <a href="/viewYourBookings?customerId=${customerId}">View Your Bookings</a>
    <form action="/customerPage"> <!-- Adjust the action attribute value as needed -->
         <input type="submit" value="Back to Dashboard">
    </form>
</div>
</body>
</html>
