package ports;

import domain.entities.Article;

import java.util.List;

public interface ArticleRepository {
    Article findById(int id);
    List<Article> findAll();
    void save(Article bonus);
    void update(Article bonus);
    void delete(int id);
}
