<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";


// isset($_POST['submit']) ? $_POST['submit'] : null;
 $Uid=isset($_POST['Uid']) ? $_POST['Uid'] : null;
 $IdCertificationTypes=isset($_POST['IdCertificationTypes']) ? $_POST['IdCertificationTypes'] : null;
 $Image=isset($_POST['Image']) ? $_POST['Image'] : null;
 
 $sql="INSERT INTO Certifications VALUES ('$Uid','$IdCertificationTypes','$Image')"; 

 if(mysqli_query($conn,$sql)){
  //thong báo thanh công
    $cc = json_encode(new Certifications($UidSender,$UidReceiver,$RatingPoint,$Comment,$DateSent));
    $ms = json_encode(http_response_code());
    echo "{errorCode: ".$ms.", certification:".$cc."}"; 
 }else{
  //thông báo thất bại
    $cc = json_encode(new Certifications($UidSender,"","","",""));
    $ms = json_encode(http_response_code());
    echo "{errorCode: ".$ms.", certification:".$cc."}"; 
 }
?>