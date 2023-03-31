import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Stock {
    private HashSet<Article> articlesMg;
    private HashMap<String, Integer> stockMg;

    public Stock() {
        this.articlesMg = new HashSet<>();
        this.stockMg = new HashMap<>();
    }

    public boolean addNouveauArticle(Article art, int qte) {
        if (this.stockMg.containsKey(art.getNom())) return false;
        articlesMg.add(art);
        stockMg.put(art.getNom(), qte);
        return true;
    }

    public boolean verifArticle(String a ) {
        return this.stockMg.containsKey(a);
    }

    public Article getArticle(String ar) {
        Article result = null;

        if (this.verifArticle(ar)) {
            for (Article article : this.articlesMg) {
                if (article.getNom().equals(ar)) {
                    result = article;
                    break;
                }
            }
        }

        return result;
    }

    public boolean removeArticle(String ar) {
        if (this.verifArticle(ar)) {
            this.stockMg.remove(ar);
            for (Article article : this.articlesMg) {
                if (article.getNom().equals(ar)) {
                    this.articlesMg.remove(article);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public int getQt(String a) {
        if(!this.verifArticle(a))
            return -1;
        else
            return this.stockMg.get(a);
    }

    public Boolean changeQt(String a, int i) {
        if(!this.verifArticle(a)) return false;
        int qt =stockMg.get(a);
        qt = qt +i;
        if(qt < 0) return false;
        stockMg.put(a, qt);
        return true ;
    }

    public void sortStock() {
        TreeMap<String, Integer> tm = new TreeMap<>(this.stockMg);
        System.out.println(tm);
    }
}
