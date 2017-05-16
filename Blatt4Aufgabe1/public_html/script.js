/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function durchlauf() {
    var breite = document.body.clientWidth;
    var logoDiv = document.getElementById('logo');
    var logoImg = document.getElementById('star');
    var imgBreite = logoImg.width + 'px';
    logoDiv.style.width = imgBreite;
    logoImg.style.position = 'absolute';
    logoPos = -logoImg.width;
    
    window.setInterval(function() {
        var i = 128;
        var scrollLeft = document.body.clientWidth;
        
        if(breite !== scrollLeft) {
            breite = scrollLeft;
        }
        logoPos += 1;
        if(logoPos > i) {
            logoPos = -breite;
        }
       logoImg.style.left = logoPos + 'px';
    }, 5);
    
}




