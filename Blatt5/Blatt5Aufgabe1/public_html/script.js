/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function testeZeichen (testString, erlaubteZeichen) {
    var allezeichenok = true;
    for (var i = 0; i < testString.length ; i++) {
        if (erlaubteZeichen.indexOf(testString.charAt(i)) === -1) {
            allezeichenok = false;
        }
    }
    return allezeichenok;
} 

function checkanrede() {
    if(document.getElementById('f').checked || document.getElementById('m').checked) {
        return false;
    }
    return true;
}

function checkemail(email) {
    var str = email;
    var mail;
    mail = str.split('@', 2);
    if(mail.length === 1 || mail[0] === "" || mail[1] === "") {
        return true;
    }
    mail = mail[1].split('.' , 2);
    if(mail.length === 1 || mail[0] === "" || mail[1] === "") {
        return true;
    }
    return false;
}

function checkform(myform) {
    if(checkanrede()) {
        alert("Bitte geben sie Ihre Anrede an!");
        return false;
    }
    if(myform.nachname.value === "") {
        myform.nachname.focus();
        alert ("Bitte geben Sie Ihren Nachnamen ein!");
        return false;
    }
    if(myform.vorname.value === "") {
        myform.vorname.focus();
        alert ("Bitte geben Sie Ihren Vornamen ein!");
        return false;
    }
    if(myform.telnr.value === "") {
        myform.telnr.focus();
        alert ("Bitte geben Sie Ihre Telefonnummer ein!");
        return false;
    }
    //din 5008
    if (!testeZeichen (myform.telnr.value, "1234567890-/+")) {
        myform.telnr.focus();
        alert ("Geben Sie eine gültige Telefonnummer ein!");
        return false;
    }
    if(myform.str.value === "") {
        myform.str.focus();
        alert ("Bitte geben Sie Ihre Straße ein!");
        return false;
    }
    if (myform.plz.value === "") {
        myform.plz.focus();
        alert("Bitte geben sie Ihre Postleitzahl an!");
        return false;
    }
    if (!testeZeichen (myform.plz.value, "1234567890")) {
        myform.plz.focus();
        alert ("Geben Sie für die Postleitzahl bitte nur Zahlen ein!");
        return false;
    }
    if (myform.plz.value.length !== 5) {
        myform.plz.focus();
        alert ("Die Postleitzahl sollte fünf Stellen lang sein!");
        return false;
    } 
    if (myform.ort.value === "") {
        myform.ort.focus();
        alert("Bitte geben sie Ihren Ort an!");
        return false;
    }
    if (myform.email.value === "") {
        myform.email.focus();
        alert("Bitte geben sie Ihre E-Mail an!");
        return false;
    }
    if(checkemail(myform.email.value)) {
        myform.email.focus();
        alert("Bitte geben sie eine gültige E-Mail an!");
        return false;
    }

    return confirm("Überprüfung abgeschlossen, alle Eingaben sind in Ordnung." + 
            "\nMöchten Sie die Daten jetzt absenden?");
}

function del() {
    return confirm("Alle Eingaben löschen?");
}