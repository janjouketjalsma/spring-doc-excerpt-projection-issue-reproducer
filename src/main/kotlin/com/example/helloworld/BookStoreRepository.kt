package com.example.helloworld

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface BookStoreRepository: JpaRepository<BookStoreEntity, Int> {
}