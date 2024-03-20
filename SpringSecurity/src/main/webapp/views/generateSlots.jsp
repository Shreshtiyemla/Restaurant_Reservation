<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Generate Slots</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            margin-top: 50px;
        }
        h1 {
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        input[type="text"] {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 20px;
        }
        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Generate Slots</h1>
    <form action="/generateSlots" method="post">
        <label for="tableId">Table ID:</label>
        <input type="text" id="tableId" name="tableId" required><br>
        <label for="restaurantId">Restaurant ID:</label>
        <input type="text" id="restaurantId" name="restaurantId" required><br>
        <button type="submit">Generate Slots</button>
    </form>
</body>
</html>
