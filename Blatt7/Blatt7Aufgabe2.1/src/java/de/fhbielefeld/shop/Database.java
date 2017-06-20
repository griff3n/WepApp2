package de.fhbielefeld.shop;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateful;

/**
 * This is an awesome database implementation ;)
 * Diese Datei nicht bearbeiten für Aufgabe 2.1
 * 
 * @author ffehring
 */
@Stateful
public class Database {
    
    private static Map<Integer,Article> articles = new HashMap<>();
    private static Map<Integer,Packet> packets = new HashMap<>();
    private static Map<Integer,ShoppingCart> carts = new HashMap<>();

    
    public static void init() {
        Packet ps = new Packet(0,"S",2.99);
        Packet pm = new Packet(1,"M", 3.99);
        Packet pl = new Packet(2,"L", 4.99);
        
        Article pc = new Article(0, "pc",999.95);
        pc.setDefaultpacket(pl);
        Article tablet = new Article(1, "tablet", 299.00);
        tablet.setDefaultpacket(pm);
        Article smartphone = new Article(2, "smartphone",99.99);
        smartphone.setDefaultpacket(ps);
        
        articles.put(0, pc);
        articles.put(1, tablet);
        articles.put(2, smartphone);
        
        packets.put(0, ps);
        packets.put(1, pm);
        packets.put(2, pl);
        
    }
    
    public static Article insertArticle(Article article) {
        if(articles.size()==0)
            Database.init();
        
        int nextId = articles.size();
        article.setId(nextId);
        
        articles.put(nextId, article);
        
        return article;
    }
    
    public static Article selectArticle(int id) {
        if(articles.size()==0)
            Database.init();
        
        return articles.get(id);
    }
    
    public static Collection<Article> selectAllArticles() {
        if(articles.size()==0)
            Database.init();
        
        return articles.values();
    }
    
    public static ShoppingCart selectCart(int id) {
        return carts.get(id);
    }
    
    public static ShoppingCart insertCart(ShoppingCart cart) {
        // Create new id for cart
        int nextId = carts.size();
        cart.setId(nextId);
        
        carts.put(nextId, cart);
        
        return cart;
    }
    
    public static ShoppingCart updateCart(ShoppingCart cart) {
        carts.put(cart.getId(), cart);
        return cart;
    }
    
}
