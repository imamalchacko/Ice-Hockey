
<?php
include("mysql.php");


$query = "delete from users where id=" . $_GET['id'];
mysqli_query($conn, $query);
echo $query;
header("location: viewAll.php");
?>