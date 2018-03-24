<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";


// isset($_POST['submit']) ? $_POST['submit'] : null;
 $UidReceiver=isset($_POST['UidReceiver']) ? $_POST['UidReceiver'] : null;
 
 $sql="SELECT * FROM Reviews WHERE UidReceiver='$UidReceiver'"; 

 $mang=array();
 if(mysqli_num_rows($data) > 0)
 {
    while ($row=mysqli_fetch_assoc($data)) {
        array_push($mang, new Reviews($row['UidSender'],$row['UidReceiver'],$row['RatingPoint'],$row['Comment'],$row['DateSent']))}
        $mang = json_encode($mang);
        $ms = json_encode(http_response_code());
        echo "{errorCode: ".$ms.", reviews:".$mang."}"; 
 }else{
    $mang = json_encode($mang);
    $ms = json_encode(http_response_code());
    echo "{errorCode: ".$ms.", reviews:".$mang."}"; 
 }
?>