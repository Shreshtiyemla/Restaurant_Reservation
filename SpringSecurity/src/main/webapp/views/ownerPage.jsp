<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Owner Page</title>
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
            color: #666;
        }
        .button-container {
            margin-top: 20px;
        }
        .button-container form {
            display: inline-block;
            margin-right: 10px;
        }
        .button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Owner Page</h1>
    <p>Please select one of the following options:</p>
    <div class="button-container">
        <form action="/register">
            <input type="submit" class="button" value="Register">
        </form>
        <form action="/loginOwner">
            <input type="submit" class="button" value="Login">
        </form>
    </div>
</body>
</html>
