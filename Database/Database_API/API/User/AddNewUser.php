<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";


// isset($_POST['submit']) ? $_POST['submit'] : null;
 $Uid=isset($_POST['Uid']) ? $_POST['Uid'] : null;
 $Avatar=isset($_POST['Avatar']) ? $_POST['Avatar'] : null;
 $FirstName=isset($_POST['FirstName']) ? $_POST['FirstName'] : null;
 $LastName=isset($_POST['LastName']) ? $_POST['LastName'] : null;
 $Sex=isset($_POST['Sex']) ? $_POST['Sex'] : null;
 $Birthday=isset($_POST['Birthday']) ? $_POST['Birthday'] : null;
 $Email=isset($_POST['Email']) ? $_POST['Email'] : null;
 $Phone=isset($_POST['Phone']) ? $_POST['Phone'] : null;
 $Address=isset($_POST['Address']) ? $_POST['Address'] : null;
 $Degree=isset($_POST['Degree']) ? $_POST['Degree'] : null;
 $Career=isset($_POST['Career']) ? $_POST['Career'] : null;
 $Status=isset($_POST['Status']) ? $_POST['Status'] : null;
 $Verification=isset($_POST['Verification']) ? $_POST['Verification'] : null;
 $Authorization=isset($_POST['Authorization']) ? $_POST['Authorization'] : null;
 $DateRegisted=isset($_POST['DateRegisted']) ? $_POST['DateRegisted'] : null;
 

 $sql="INSERT INTO Users VALUES ('$Uid','$Avatar','$FirstName','$LastName','$Sex','$Birthday','$Email','$Phone','$Address','$Degree','$Career','$Status','$Verification','$Authorization','$DateRegisted')"; 

 if(mysqli_query($conn,$sql)){
  //thong báo thanh công
  $us = json_encode(new Users($Uid,$Avatar,$FirstName,$LastName,$Sex,$Birthday,$Email,$Phone,$Address,$Degree,$Career,$Status,$Verification,$Authorization,$DateRegisted));
        $ms = json_encode(http_response_code());
        echo "{errorCode: ".$ms.", user:".$us."}"; 
 }else{
  //thông báo thất bại
    $us = json_encode(new Users($Uid,"","","","","","","","","","","","","",""));
    $ms = json_encode(http_response_code());
    echo "{errorCode: ".$ms.", user:".$us."}"; 
 }
?>