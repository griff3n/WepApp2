/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function read() {
        
    var req = (window.XMLHttpRequest) ? new XMLHttpRequest() : ((window.ActiveXObject) ? new ActiveXObject("Microsoft.XMLHTTP") : false );
    req.open("GET", "http://localhost:8383/Blatt6Aufgabe2/index.rss", true);
    req.onreadystatechange = function() {
        if(req.readyState === 4 && req.status === 200) {
            var text = "";
            var d = document.getElementById("list");
            var nodes = req.responseXML.getElementsByTagName("title");
            var nodes2 = req.responseXML.getElementsByTagName("link");
            for(var i = 2; i < nodes.length; i++) {
                
                text += "<li><a href=\""+ nodes2[i].firstChild.data.toString()+ "\">" + nodes[i].firstChild.data.toString() + "</a><br></li>";
            }
            d.innerHTML = text;
        }
    }
    req.send(null);
}



