package com.example.helloworld

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(excerptProjection = BookExcerptProjection::class)
interface BookRepository: JpaRepository<BookEntity, Int> {
}