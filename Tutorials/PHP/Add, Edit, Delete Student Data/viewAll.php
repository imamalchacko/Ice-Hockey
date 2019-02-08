
<?php

include("mysql.php");

$query = "select * from users";
$result=mysqli_query($conn, $query);
echo "<table border=1>";
echo "<tr><th>Name</th><th>Address</th><th>Phone</th><th>Edit</th><th>Delete</th></tr>";
while($row=mysqli_fetch_array($result)){
    echo "<tr>";
    echo "<td>".$row['name']."</td>";
    echo "<td>" . $row['address'] . "</td>";
    echo "<td>".$row['phone_no']."</td>";
    echo "<td><a href='edit.php?id=".$row['id']."'>Edit</td>";
    echo "<td><a href='delete.php?id=" . $row['id'] . "'>Delete</td>";
    echo "</tr>";
}

?>