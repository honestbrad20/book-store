<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <!--<title> Responsiive Admin Dashboard | CodingLab </title>-->
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<#include "dashboard.ftlh">
    <div class="home-content">
        <div class="sales-boxes">
            <div class="recent-sales box">
                <div class="title">Index Page</div>
                <br>
                Nama : <input type="text" value="${name}"><br>
                Umur : <input type="text" value="${age}"><br>
                Alamat : <textarea >${address}</textarea><br>
    <#list daftar as x>
        ${x} <br>
    </#list>
                <br>
                <p>Is Married ? ${isMarried?string}</p>
            </div>
        </div>

</body>