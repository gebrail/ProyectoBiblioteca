/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarTextoVacio(cadena) {
    if (cadena == null || cadena.length == 0 || /^\s+$/.test(cadena))
        return false;
    else
        return true;
}

function validaSoloTexto(cadena) {
    var patron = /^([a-zA-Z]|\s*)*$/;
    if (!cadena.search(patron))
        return true;
    else
        return false;
}

function validaTextoNumeros(cadena) {
    var patron = /^([0-9A-Za-z]|\s*)*$/;
    if (!cadena.search(patron))
        return true;
    else
        return false;
}


function validarSession(usuario, password) {
    if (!validarTextoVacio(usuario) || !validarTextoVacio(password)) {
        alert("Por favor verifique el usuario o la contraseña");

       
    }
    else {
        var adm = document.getElementById("inicioSesion");
        adm.action = "/Biblioteca2/ControllerPersona";
        adm.submit();
    }



}


