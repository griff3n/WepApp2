/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function umrechnen() {
    var k = 1000;
    var m = 1000 * 1000;
    var g = 1000 * 1000 * 1000;
    var result = 0;
    var input = document.getElementById("input").value;
    var select = getSelection();
    switch (select) {
        case 0:
            result = input * 1;
            break;
        case 1:
            result = input * k;
            break;
        case 2:
            result = input * m;
            break;
        case 3:
            result = input * g;
            break;
        case 4:
            result = input * m;
            break;
    }
    document.getElementById("mm3").value = result;
    document.getElementById("cm3").value = result / k;
    document.getElementById("dm3").value = result / m;
    document.getElementById("m3").value = result / g;
    document.getElementById("l").value = result / m;
}

function getSelection() {
    for (var i = 0; i < document.Volumenrechner.volumen.length;i++) {
        if(document.getElementById("list").options[i].selected) {
            return document.getElementById("list").options[i].index;
        }
    }
    return -1;
}

document.getElementById("input").onchange = umrechnen;
document.getElementById("list").onchange = umrechnen;