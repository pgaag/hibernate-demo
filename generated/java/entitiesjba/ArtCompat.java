package entitiesjba;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "art_compat")
public class ArtCompat {
    @EmbeddedId
    private ArtCompatId id;

    @MapsId("article")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "article", nullable = false)
    private entitiesjba.Article article;

    @MapsId("compatibleArticle")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "compatible_article", nullable = false)
    private entitiesjba.Article compatibleArticle;

    public ArtCompatId getId() {
        return id;
    }

    public void setId(ArtCompatId id) {
        this.id = id;
    }

    public entitiesjba.Article getArticle() {
        return article;
    }

    public void setArticle(entitiesjba.Article article) {
        this.article = article;
    }

    public entitiesjba.Article getCompatibleArticle() {
        return compatibleArticle;
    }

    public void setCompatibleArticle(entitiesjba.Article compatibleArticle) {
        this.compatibleArticle = compatibleArticle;
    }

    @Override
    public String toString() {
        return "ArtCompat{" +
                "id=" + id +
                ", article=" + article +
                ", compatibleArticle=" + compatibleArticle +
                '}';
    }
}