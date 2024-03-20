<%@page language="java" %>
<html>
<head>
    <title>Owner</title>
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
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div>
    <form action="/add">
        <input type="submit" value="Add Restaurants">
    </form>

    <form action="/viewOwner">
        <input type="submit" value="View Restaurants">
    </form>

    <form action="/viewReservations">
        <input type="hidden" name="ownerId" value="${ownerId}">
        <input type="submit" value="View Reservations">
    </form>
</div>
</body>
</html>
