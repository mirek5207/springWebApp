package com.springFramework.springWebApp.repositories;

import com.springFramework.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
