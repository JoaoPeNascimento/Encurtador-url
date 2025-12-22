package com.joaopenascimento.urlshortener.repository;

import com.joaopenascimento.urlshortener.entity.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlEntity, String> {
}
