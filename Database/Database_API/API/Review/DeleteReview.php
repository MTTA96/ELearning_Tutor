<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";


// isset($_POST['submit']) ? $_POST['submit'] : null;
 $UidSender=isset($_POST['UidSender']) ? $_POST['UidSender'] : null;
 $UidReceiver=isset($_POST['UidReceiver']) ? $_POST['UidReceiver'] : null;
 
 $sql="DELETE FROM Reviews WHERE UidSender='$UidSender' AND UidReceiver='$UidReceiver'"; 

 if(mysqli_query($conn,$sql)){
    //thong báo thanh công
      $ms = json_encode(http_response_code());
      echo "{errorCode: ".$ms.", status: Success}"; 
   }else{
    //thông báo thất bại
      $ms = json_encode(http_response_code());
      echo "{errorCode: ".$ms.", status: Failed}"; 
   }
?>