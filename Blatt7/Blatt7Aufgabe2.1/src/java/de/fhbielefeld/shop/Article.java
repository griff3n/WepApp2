package de.fhbielefeld.shop;

/**
 * Article class for holding informations about articles.
 * 
 * @author ffehring
 */
public class Article {
    
    private int id;
    private String name;
    private Double price;
    private Packet defaultpacket;

    public Article(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    
    public Article(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Packet getDefaultpacket() {
        return defaultpacket;
    }

    public void setDefaultpacket(Packet defaultpacket) {
        this.defaultpacket = defaultpacket;
    }
}
