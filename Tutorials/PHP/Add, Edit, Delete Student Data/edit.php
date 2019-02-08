<!DOCTYPE html>
<?php
include("mysql.php");

$query = "select * from users where id=".$_GET['id'];
$result = mysqli_query($conn, $query);
while ($row = mysqli_fetch_array($result)) {
    $name=$row['name'];
    $addr=$row['address'];
    $phone=$row['phone_no'];
}
?>
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
            <td>Name </td><td><input type="text" name="name" value=<?php echo $name; ?>></td>
        </tr>
        <tr>
            <td>Address </td><td><input type="text" name="addr" value=<?php echo $addr; ?>></td>
        </tr>
        <tr>
            <td>Phone </td><td><input type="text" name="phone" value=<?php echo $phone; ?>></td>
        </tr>
        <tr>
            <td><input type="submit" name="update"></td>
        </tr>
    </table>
</form>
</body>
</html>


<?php
   
    if(!isset($_POST['update']))
        exit();
    
    $query= "update `users` set name='".$_POST['name']."', address='".$_POST['addr']."', phone_no='".$_POST['phone']. "' where id=" . $_GET['id'];
     mysqli_query($conn, $query);
        header("location: viewAll.php ");

?>