package com.allenti.boot.mp.newsfeed.infrastructure;

import static java.util.Objects.nonNull;

import com.allenti.boot.mp.newsfeed.domain.model.Article;
import com.allenti.boot.mp.newsfeed.domain.repository.ArticleRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class ArticleRepositoryInMemoryImpl implements ArticleRepository {
  private final static Map<Long, Article> inMemoryRepo = new HashMap<>();
  private final static AtomicLong idCounter = new AtomicLong();

  @Override
  public Article getById(Long id) {
    return inMemoryRepo.get(id);
  }

  @Override
  public List<Article> getByTitle(String title) {
    return inMemoryRepo.values().stream().filter(a->a.getTitle().contains(title)).collect(Collectors.toList());
  }

  @Override
  public Long create(Article article) {
    Long id = idCounter.incrementAndGet();
    article.setId(id);
    return Optional.ofNullable(inMemoryRepo.putIfAbsent(id, article)).map(Article::getId).orElse(-1L);
  }

  @Override
  public boolean update(Article article) {
    return nonNull(inMemoryRepo.put(article.getId(), article));
  }

  @Override
  public boolean delete(Long id) {
    return nonNull(inMemoryRepo.remove(id));
  }
}
