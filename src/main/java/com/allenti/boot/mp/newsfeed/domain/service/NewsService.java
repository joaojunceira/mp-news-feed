package com.allenti.boot.mp.newsfeed.domain.service;

import com.allenti.boot.mp.newsfeed.domain.model.Article;
import java.util.List;

public interface NewsService {
  List<Article> getByTitle(String title);
  Article getById(Long id);
  boolean deleteById(Long id);
  Article update(Article article);
  Long create(Article article);
}
