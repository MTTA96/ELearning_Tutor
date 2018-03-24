<?php

// Kết nối database
require "/storage/ssd4/981/5026981/APIs/DbConnection.php";
require "/storage/ssd4/981/5026981/APIs/Model.php";

// Thực thi lệnh lấy dữ liệu ra
$sql="SELECT * FROM Users WHERE Authorization=2 || Authorization=3";

$data=mysqli_query($conn,$sql);

$mang=array();

//Lấy Users vừa tìm được
 if(mysqli_num_rows($data) > 0)
    {
        while ($row=mysqli_fetch_assoc($data)) {
            array_push($mang,new Users($row['Uid'],$row['Avatar'],$row['FirstName'],$row['LastName'],$row['Sex'],$row['Birthday'],$row['Email'],$row['Phone'],$row['Address'],$row['Degree'],$row['Career'],$row['Status'],$row['Verification'],$row['Authorization'],$row['DateRegisted']));
          }
        $mang = json_encode($mang);
        $ms = json_encode(http_response_code());
        echo "{errorCode: ".$ms.", teachers:".$mang."}";  

    }
    else {
        $mang = json_encode($mang);
        $ms = json_encode(http_response_code());
        echo "{errorCode: ".$ms.", teachers:".$mang."}"; 
    }

?>