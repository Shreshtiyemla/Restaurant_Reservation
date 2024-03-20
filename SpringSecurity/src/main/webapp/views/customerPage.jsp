<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Page</title>
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
        p {
            margin-top: 20px;
            font-size: 18px;
        }
        .button-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            margin-top: 20px;
        }
        .button {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 10px;
        }
        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Customer Page</h1>
    <p>Please select one of the following options:</p>
    <div class="button-container">
        <form action="/registerCustomer">
            <input type="submit" class="button" value="Register">
        </form>
        <form action="/loginCustomer">
            <input type="submit" class="button" value="Login">
        </form>
        <form action="/">
            <input type="submit" class="button" value="Back to Dashboard">
        </form>
    </div>
</body>
</html>
