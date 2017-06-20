package de.fhbielefeld.shop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ffehring
 */
public class ShoppingCart {
    
    private int id;
    
    private List<Article> articles = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    
    public void addArticle(Article article) {
        this.articles.add(article);
    }
}
