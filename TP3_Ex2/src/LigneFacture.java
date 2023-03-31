public class LigneFacture {
    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int qt;
    private Article article;

    public LigneFacture(int id, int qt, Article article) {
        this.id = id;
        this.qt = qt;
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public int getId() {
        return id;
    }

    public double getMontantTotal() {
        return this.article.getPU() * this.qt;
    }
}