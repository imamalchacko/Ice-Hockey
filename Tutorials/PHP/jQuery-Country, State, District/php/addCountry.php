<?php
    include("mysql.php");
    $query= "INSERT INTO `country`(`name`) VALUES ('".$_POST['name']."')";
    mysqli_query($conn, $query);

    echo 1;
?>