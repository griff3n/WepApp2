/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var x = 256, y = 256, moveDir = 0;

function attach(elem, type, fn) {
    if(elem.addEventListener) {
        elem.addEventListener(type, fn, false);
    } else if (elem.attachEvent) {
        elem.attachEvent('on' + type, fn);
    }
}

function loadImg(sCon, imgUrl, x, y, sx, sy, stageContext, bufferCanvas, callback) {
    var img = new Image();
    img.src = imgUrl;
    img.onload = function () {
        sCon.drawImage(img, x, y, sx, sy);
        callback();
    };
}

function paintBackBuffer(stageContext, bufferCanvas, bufferContext, moveDir) {
    bufferContext.clearRect(0, 0, 512, 512);
    loadImg(bufferContext, 'runway.jpg', 0, 0, 512, 512, stageContext, bufferCanvas, function () {
        loadImg(bufferContext, 'buggy_' + moveDir + '.gif', x, y, 64, 64, stageContext, bufferCanvas, function () {
            stageContext.drawImage(bufferCanvas, 0, 0, 512, 512);
        });
    });
}

window.onload = function() {
    var stageCanvas, stageContext, bufferCanvas, bufferContext;
    stageCanvas = document.getElementById('stage');
    stageContext = stageCanvas.getContext('2d');
    bufferCanvas = document.getElementById('buffer');
    bufferContext = bufferCanvas.getContext('2d');
    
    attach(document, 'keypress', function (e){
        switch (e.keyCode) {
            case 37:
            case 97:
                moveDir = 6;
                x -= 5;
                y += 0;
            break;
            case 38:
            case 119:
                moveDir = 0;
                x += 0;
                y -= 5;
            break;
            case 39:
            case 100:
                moveDir = 2;
                x += 5;
                y += 0;
            break;
            case 40:
            case 115:
                moveDir = 4;
                x += 0;
                y += 5;
            break;
        }
        paintBackBuffer(stageContext, bufferCanvas, bufferContext, moveDir);
    });
    paintBackBuffer(stageContext, bufferCanvas, bufferContext, moveDir);
};