<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
</head>
<body>
<form method="post" action=#>
    <table border=0>
        <tr>
            <td>Name </td><td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Address </td><td><input type="text" name="addr"></td>
        </tr>
        <tr>
            <td>Phone </td><td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>


<?php
    include("mysql.php");

    if(!isset($_POST['submit']))
        exit();
    
    $query= "INSERT INTO `users`(`name`, `address`, `phone_no`) VALUES ('".$_POST['name']."','".$_POST['addr']."','".$_POST['phone']."')";
    
     mysqli_query($conn, $query);   
?>