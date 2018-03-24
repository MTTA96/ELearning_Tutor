<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";


// isset($_POST['submit']) ? $_POST['submit'] : null;
 $Uid=isset($_POST['Uid']) ? $_POST['Uid'] : null;
 $IdField=isset($_POST['IdField']) ? $_POST['IdField'] : null;
 
 $sql="INSERT INTO FieldsConcern VALUES ('$Uid','$IdField')"; 

 if(mysqli_query($conn,$sql)){
  //thong báo thanh công
    $fc = json_encode(new FieldsConcern($Uid,$IdField));
    $ms = json_encode(http_response_code());
    echo "{errorCode: ".$ms.", fieldsConcern:".$fc."}"; 
 }else{
  //thông báo thất bại
    $fc = json_encode(new FieldsConcern($Uid,""));
    $ms = json_encode(http_response_code());
    echo "{errorCode: ".$ms.", fieldsConcern:".$fc."}"; 
 }
?>