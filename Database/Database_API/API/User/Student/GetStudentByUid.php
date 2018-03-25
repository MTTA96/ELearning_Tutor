<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";

//Lấy Uid truyền vào
$Uid=isset($_GET['Uid']) ? $_GET['Uid'] : null;
// Thực thi lệnh lấy dữ liệu ra
$sql="SELECT * FROM Users WHERE Uid='$Uid'";

$data=mysqli_query($conn,$sql);

//Lấy Users vừa tìm được
 if(mysqli_num_rows($data) > 0)
    {
        while ($row=mysqli_fetch_assoc($data)) {
			   $stu = json_encode(new Users($row['Uid'],$row['Avatar'],$row['FirstName'],$row['LastName'],$row['Sex'],$row['Birthday'],$row['Email'],$row['Phone'],$row['Address'],$row['Degree'],$row['Career'],$row['Status'],$row['Verification'],$row['Authorization'],$row['DateRegisted']));

		  }
        $ms = json_encode(http_response_code());
        echo "{errorCode: ".$ms.", user:".$stu."}";  

    }
    else {
        $stu = json_encode(new Users($Uid,"","","","","","","","","","","","","",""));
        $ms = json_encode(http_response_code());
        echo "{errorCode: ".$ms.", user:".$stu."}"; 
        // echo http_response_code();
    }

?>