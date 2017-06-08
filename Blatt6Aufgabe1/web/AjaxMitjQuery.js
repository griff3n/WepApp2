/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $("button:eq(0)").click(function () {
        $.get("check_ip.jsp", function (data) {
            $("#a1").html(data);
        });
    });
    
    $("button:eq(1)").click(function () {
        $.get("check_date.jsp", function (data) {
            $("#a2").html(data);
        });
    });
    
    $("button:eq(2)").click(function () {
        $.get("check_host.jsp", function (data) {
            $("#a3").html(data);
        });
    });
    
    $("button:eq(3)").click(function () {
        $.get("check_language.jsp", function (data) {
            $("#a4").html(data);
        });
    });
    
    $("button:eq(4)").click(function () {
        $.get("check_mime.jsp", function (data) {
            $("#a5").html(data);
        });
    });
    
    $("button:eq(5)").click(function () {
        $.get("check_userAgent.jsp", function (data) {
            $("#a6").html(data);
        });
    });
});
