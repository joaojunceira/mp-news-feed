package com.allenti.boot.mp.newsfeed.domain.service;

import com.allenti.boot.mp.newsfeed.domain.model.Article;
import com.allenti.boot.mp.newsfeed.domain.repository.ArticleRepository;
import java.util.List;

public class NewsServiceImpl implements NewsService {
  private ArticleRepository articleRepository;

  @Override
  public List<Article> getByTitle(String title) {
    return articleRepository.getByTitle(title);
  }

  @Override
  public Article getById(Long id) {
    return articleRepository.getById(id);
  }

  @Override
  public boolean deleteById(Long id) {
    return articleRepository.delete(id);
  }

  public boolean delete(Article article) {
    return articleRepository.delete(article.getId());
  }

  @Override
  public Article update(Article article) {
    Long id = articleRepository.create(article);
    article.setId(id);
    return article;
  }

  @Override
  public Long create(Article article) {
    return articleRepository.create(article);
  }
}
