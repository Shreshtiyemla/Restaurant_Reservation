<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Slots Added Successfully</title>
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
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 20px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Slots Added Successfully</h1>
    <p>Your slots have been successfully added.</p>
    <form action="/viewOwner"> <!-- Adjust the action attribute value as needed -->
        <input type="submit" value="Back to Dashboard">
    </form>
</body>
</html>
