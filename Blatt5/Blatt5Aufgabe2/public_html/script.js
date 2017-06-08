/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var b;
var c;
var d;
function go(){
    b = 'quelle.html';
    c = window.open(b);
    d = c.document.body;
    alert(d.firstChild.nodeType);

//
//c.close();
//document.write(d.nodename.text());
}
