<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";


// isset($_POST['submit']) ? $_POST['submit'] : null;
 $Uid=isset($_POST['Uid']) ? $_POST['Uid'] : null;
 
 $sql="SELECT * FROM VerificationDocuments WHERE Uid='$Uid'";

 $mang=array();
 if(mysqli_num_rows($data) > 0)
 {
    while ($row=mysqli_fetch_assoc($data)) {
        array_push($mang, new VerificationDocuments($row['Uid'],$row['IdVdTypes'],$row['CardNumber'],$row['FrontSide'],$row['BackSide']))}
        $mang = json_encode($mang);
        $ms = json_encode(http_response_code());
        echo "{errorCode: ".$ms.", verificationDocuments:".$mang."}"; 
 }else{
    $mang = json_encode($mang);
    $ms = json_encode(http_response_code());
    echo "{errorCode: ".$ms.", verificationDocuments:".$mang."}"; 
 }
?>