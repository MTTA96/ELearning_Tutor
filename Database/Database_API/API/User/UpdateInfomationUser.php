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
 
 $sql="UPDATE Users 
 SET Avatar='$Avatar', FirstName='$FirstName', LastName='$LastName', Sex='$Sex', Birthday='$Birthday', 
 Email='$Email', Phone='$Phone', Address='$Address', Degree='$Degree', Career='$Career' 
 WHERE Uid='$Uid'"; 

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