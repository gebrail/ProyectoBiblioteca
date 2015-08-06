/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function listadodecuentas()
{
    var conexion;
    if (window.XMLHttpRequest) {
        conexion = new XMLHttpRequest();
    } else {
        conexion = new ActiveXObject("Microsoft.XMLHTTP");
    }
    conexion.onreadystatechange = function() {
        if (conexion.readyState == 4 && conexion.status == 200) {
            document.getElementById("listadodecuentas").innerHTML = conexion.responseText;
        }
    }
    conexion.open("POST", "/Biblioteca2/ControllerPersona", true);
    conexion.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    conexion.send("&opcion=" + 1);
}

function listadodecuentasxroles()
{
    var conexion;
    if (window.XMLHttpRequest) {
        conexion = new XMLHttpRequest();
    } else {
        conexion = new ActiveXObject("Microsoft.XMLHTTP");
    }
    conexion.onreadystatechange = function() {
        if (conexion.readyState == 4 && conexion.status == 200) {
            document.getElementById("listadodecuentasroles").innerHTML = conexion.responseText;
        }
    }
    conexion.open("POST", "/Biblioteca2/ControllerPersona", true);
    conexion.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    conexion.send("&opcion=" + 2);
}

function listadodecuentasxusername()
{
    var conexion;
    if (window.XMLHttpRequest) {
        conexion = new XMLHttpRequest();
    } else {
        conexion = new ActiveXObject("Microsoft.XMLHTTP");
    }
    conexion.onreadystatechange = function() {
        if (conexion.readyState == 4 && conexion.status == 200) {
            document.getElementById("listadodecuentasusername").innerHTML = conexion.responseText;
        }
    }
    conexion.open("POST", "/Biblioteca2/ControllerPersona", true);
    conexion.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    conexion.send("&opcion=" + 3);
}