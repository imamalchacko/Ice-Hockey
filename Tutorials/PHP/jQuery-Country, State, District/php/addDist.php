<?php
include("mysql.php");
$query = "INSERT INTO `dist`(`country`,`state`,`district`) VALUES ('" . $_POST['c'] . "','" . $_POST['s'] . "','" . $_POST['d'] . "')";
mysqli_query($conn, $query);

echo 1;
?>