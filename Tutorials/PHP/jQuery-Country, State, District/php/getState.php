<?php

include("mysql.php");

$query = "select * from state where country=".$_POST['c'];
$result = mysqli_query($conn, $query);
$r = '';
while ($row = mysqli_fetch_array($result)) {
    $r = $r . "<option value=" . $row['id'] . ">" . $row['state'] . "</option>";
}
echo $r;
?>