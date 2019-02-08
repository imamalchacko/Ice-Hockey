<?php
    include("mysql.php");
    $query= "INSERT INTO `state`(`country`,`state`) VALUES ('" . $_POST['c'] . "','".$_POST['s']."')";
    mysqli_query($conn, $query);

    echo 1;
?>