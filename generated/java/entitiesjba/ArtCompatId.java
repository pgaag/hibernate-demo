package entitiesjba;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ArtCompatId implements java.io.Serializable {
    private static final long serialVersionUID = -2454000303145908030L;
    @Size(max = 100)
    @NotNull
    @Column(name = "article", nullable = false, length = 100)
    private String article;

    @Size(max = 100)
    @NotNull
    @Column(name = "compatible_article", nullable = false, length = 100)
    private String compatibleArticle;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getCompatibleArticle() {
        return compatibleArticle;
    }

    public void setCompatibleArticle(String compatibleArticle) {
        this.compatibleArticle = compatibleArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ArtCompatId entity = (ArtCompatId) o;
        return Objects.equals(this.compatibleArticle, entity.compatibleArticle) &&
                Objects.equals(this.article, entity.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compatibleArticle, article);
    }

    @Override
    public String toString() {
        return "ArtCompatId{" +
                "article='" + article + '\'' +
                ", compatibleArticle='" + compatibleArticle + '\'' +
                '}';
    }
}