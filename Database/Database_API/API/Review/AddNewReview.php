<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";


// isset($_POST['submit']) ? $_POST['submit'] : null;
 $UidSender=isset($_POST['UidSender']) ? $_POST['UidSender'] : null;
 $UidReceiver=isset($_POST['UidReceiver']) ? $_POST['UidReceiver'] : null;
 $RatingPoint=isset($_POST['RatingPoint']) ? $_POST['RatingPoint'] : null;
 $Comment=isset($_POST['Comment']) ? $_POST['Comment'] : null;
 $DateSent=isset($_POST['DateSent']) ? $_POST['DateSent'] : null;
 
 $sql="INSERT INTO Reviews VALUES ('$UidSender','$UidReceiver','$RatingPoint','$Comment','$DateSent')"; 

 if(mysqli_query($conn,$sql)){
  //thong báo thanh công
    $rv = json_encode(new Reviews($UidSender,$UidReceiver,$RatingPoint,$Comment,$DateSent));
    $ms = json_encode(http_response_code());
    echo "{errorCode: ".$ms.", review:".$rv."}"; 
 }else{
  //thông báo thất bại
    $rv = json_encode(new Reviews($UidSender,"","","",""));
    $ms = json_encode(http_response_code());
    echo "{errorCode: ".$ms.", review:".$rv."}"; 
 }
?>