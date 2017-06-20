package de.fhbielefeld.shop;

import javax.ejb.Stateless;
import javax.ws.rs.*;

/**
 * Dieser WebService tut ALLES rund um den Shop.
 * 
 * @author ffehring
 */
@Stateless  //Sorgt dafür das sich der WebService etwas merken kann
@Path("shop")
public class ShopResource {

    private ShoppingCart cart;  // Speichert den Warenkorb über mehrere Aufrufe hinweg
    
    /**
     * Gets information about one article
     * 
     * @param id    Articles (database) id
     * @return      Article information as json
     */
    @POST
    @Path("article")
    public String article(
        @FormParam("id") int id) {
        String articlejson = "";
        Article article = Database.selectArticle(id);
        
        if(article == null) {
            articlejson += "Artikel nicht vorhanden.<br><br>";
            articlejson += "<a href='..'>zur&uuml;ck</a>";
            return articlejson;
        }
        
        articlejson += "{";
        articlejson += "\"id\": " + article.getId() + ",";
        articlejson += "\"name\": \"" + article.getName() + "\",";
        articlejson += "\"price\": " + article.getPrice();
        articlejson += "}<br><br>";
        articlejson += "<a href='..'>zur&uuml;ck</a>";
        return articlejson;
    }
    
    /**
     * Lists all available articles
     * 
     * @return json list of articles
     */
    @POST
    @Path("articles")
    public String availableArticles() {
        String ret = "[<br>";
        int i = 0;
        for (Article curArticle : Database.selectAllArticles()) {
            if (i > 0) {
                ret += ",";
            }
            ret += "{";
            ret += "\"id\": \"" + curArticle.getId() + "\",";
            ret += "\"name\": \"" + curArticle.getName() + "\",";
            ret += "\"price\": " + curArticle.getPrice();
            if (curArticle.getDefaultpacket() != null) {
                ret += ",";
                ret += "\"packet\": {";
                ret += "   \"name\": \"" + curArticle.getDefaultpacket().getName() + "\"";
                ret += "   \"price\": " + curArticle.getDefaultpacket().getPrice() + "";
                ret += "}";
            }
            ret += "}<br>";
            i++;
        }

        ret += "]<br><br>";
        ret += "<a href='..'>zur&uuml;ck</a>";

        return ret;
    }
    
    /**
     * Creates an new article.
     * 
     * @param name      New articles name
     * @param price     New artiles price
     * @return          Status of creation
     */
    @POST
    @Path("newArticle")
    public String newArticle(
            @FormParam("name") String name,
            @FormParam("price") Double price) {
        String ret ="";
        if(name==null || name.isEmpty()) {
            ret += "Name vergessen!<br><br>";
            ret += "<a href='..'>zur&uuml;ck</a>";
            return ret;
        }
        if(price==null) {
            ret += "Preis vergessen!<br><br>";
            ret += "<a href='..'>zur&uuml;ck</a>";
            return ret;
        }
        
        Article newArticle = new Article(name,price);
        Database.insertArticle(newArticle);
        
        ret += "saved!<br><br>";
        ret += "<a href='..'>zur&uuml;ck</a>";
        return ret;
    }

    @POST
    @Path("getCart")
    public String getCart() {
        String ret = "";
        if(cart == null || cart.getArticles().size()==0) {
            ret += "Sie haben leider noch nichts in ihrem Warenkorb.<br><br>";
            ret += "<a href='..'>zur&uuml;ck</a>";
            return ret;
        }
        
        ret += "[";
        
        int i=0;
        for(Article curArticle : cart.getArticles()) {
            if(i>0) {
                ret += ",";
            }
            ret += "{";
            ret += "\"name\": "+curArticle.getName() + "";
            ret += "}";
            i++;
        }
        
        ret += "]<br><br>";
        ret += "<a href='..'>zur&uuml;ck</a>";
        return ret;
    }
    
    @GET
    @Path("newCart")
    public String newCart() {
        ShoppingCart sc = new ShoppingCart();
        sc = Database.insertCart(sc);
        String ret = "";
        ret += "{\"id\": "+sc.getId()+"}<br><br>";
        ret += "<a href='..'>zur&uuml;ck</a>";
        return ret;
    }
    
    @POST
    @Path("toCart")
    public String addToCart(
            @FormParam("articleid") int articleid) {

        // Create new cart if not exists
        if(this.cart==null) {
            cart = new ShoppingCart();
            cart = Database.insertCart(cart);
        }
        
        // Get article from database and add to cart
        Article article = Database.selectArticle(articleid);
        cart.addArticle(article);
        
        // Update cart in database
        Database.updateCart(cart);
        String ret = "";
        ret += "added " + article.getName() + "<br><br>";
        ret += "<a href='..'>zur&uuml;ck</a>";
        return ret;
    }

}
