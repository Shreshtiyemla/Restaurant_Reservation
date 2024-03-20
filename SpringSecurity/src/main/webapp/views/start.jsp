<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WELCOME TO RESTAURANT APPLICATION</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .container {
            text-align: center;
            margin-top: 100px;
        }
        h1 {
            color: #333;
        }
        p {
            color: #666;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
            margin: 10px;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .btn-customer {
            background-color: #007bff;
        }
        .btn-customer:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>WELCOME TO RESTAURANT APPLICATION</h1>
        <p>Please select your role:</p>
        <a href="ownerPage" class="btn btn-owner">OWNER</a>
        <a href="customerPage" class="btn btn-customer">CUSTOMER</a>
    </div>
</body>
</html>
