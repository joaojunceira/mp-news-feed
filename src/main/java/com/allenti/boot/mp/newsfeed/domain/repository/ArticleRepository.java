package com.allenti.boot.mp.newsfeed.domain.repository;

import com.allenti.boot.mp.newsfeed.domain.model.Article;
import java.util.List;

public interface ArticleRepository {
  Article getById(Long id);
  List<Article> getByTitle(String title);
  Long create(Article article);
  boolean update(Article article);
  boolean delete(Long id);
}
