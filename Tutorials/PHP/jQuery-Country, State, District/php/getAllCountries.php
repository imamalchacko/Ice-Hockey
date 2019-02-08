
<?php

include("mysql.php");

$query = "select * from country";
$result = mysqli_query($conn, $query);
$r='';
while($row = mysqli_fetch_array($result)) {
   $r=$r."<option value=".$row['id'].">". $row['name']."</option>" ;
}
echo $r;

?>