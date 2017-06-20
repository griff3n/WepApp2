package de.fhbielefeld.shop.rest;

import de.fhbielefeld.shop.Database;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Diese Resource wird nach dem Start der Applikation aufgerufen.
 * 
 * 
 * @author ffehring
 */
@Path("")
public class RootResource {
    
    @GET
    @Produces(MediaType.TEXT_HTML + ";charset=utf-8")
    public String welcome() {
        
        Database.init();
        String page = "";
        page +=  "<h1>Willkommen beim FH WebShop WebService!</h1>";
        page += "<p>Nutzen Sie unseren tollen WebService und verkaufen Sie für uns unsere Artikel.</p>";
        
        page += "<ul>";
        
        page += "<p><li>Einen einzigen Artikel ansehen:<br>";
        page += "<form name=\"artikelAnzeigen\" method=\"post\" action=\"shop/article\">";
        page += "<label>Id: </label>";
        page += "<input type=\"number\" value=\"0\" name=\"id\"><br>";
        page += "<input type=\"submit\" value=\"anzeigen\" name=\"zeigeArtikel\">";
        page += "</form>";
        page += "</li></p>";
        
        page += "<p><li>Alle Artikel anzeigen:<br>";
        page += "<form name=\"alleArtikelAnzeigen\" method=\"post\" action=\"shop/articles\">";
        page += "<input type=\"submit\" value=\"anzeigen\" name=\"zeigeAlleArtikel\">";
        page += "</form>";
        page += "</li></p>";
        
        page += "<p><li>Einen neuen Artikel anlegen:<br>";
        page += "<form name=\"artikelAnlegen\" method=\"post\" action=\"shop/newArticle\">";
        page += "<label>Name: </label>";
        page += "<input type=\"text\" value=\"0\" name=\"name\"><br>";
        page += "<label>Preis: </label>";
        page += "<input type=\"number\" value=\"0\" name=\"price\" step=\"0.01\"><br>";
        page += "<input type=\"submit\" value=\"anlegen\" name=\"legeArtikelAn\">";
        page += "</form>";
        page += "</li></p>";
        
        page += "<p><li>Artikel in den Warenkoorb legen:";
        page += "<form name=\"inWarenkorbLegen\" method=\"post\" action=\"shop/toCart\">";
        page += "<label>ArtikelId: </label>";
        page += "<input type=\"number\" value=\"0\" name=\"articleid\"><br>";
        page += "<input type=\"submit\" value=\"reinlegen\" name=\"legeInWarenkorp\">";
        page += "</form>";
        page += "</li></p>";
        
        page += "<p><li>Warenkorb ansehen:";
        page += "<form name=\"warenkorbAnsehen\" method=\"post\" action=\"shop/getCart\">";
        page += "<input type=\"submit\" value=\"ansehen\" name=\"seheWarenkorbAn\">";
        page += "</form>";
        page += "</li></p>";
        page += "</ul>";
        return page;
    }
}
