<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";


// isset($_POST['submit']) ? $_POST['submit'] : null;
 $Uid=isset($_POST['Uid']) ? $_POST['Uid'] : null;
 $IdVdTypes=isset($_POST['IdVdTypes']) ? $_POST['IdVdTypes'] : null;
 $CardNumber=isset($_POST['CardNumber']) ? $_POST['CardNumber'] : null;
 $FrontSide=isset($_POST['FrontSide']) ? $_POST['FrontSide'] : null;
 $BackSide=isset($_POST['BackSide']) ? $_POST['BackSide'] : null;
 
 $sql="UPDATE VerificationDocuments SET IdVdTypes='$IdVdTypes', CardNumber='$CardNumber', FrontSide='$FrontSide', BackSide='$BackSide' WHERE Uid='$Uid'"; 

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