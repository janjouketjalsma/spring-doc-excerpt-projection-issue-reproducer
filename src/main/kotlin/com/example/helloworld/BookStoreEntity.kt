package com.example.helloworld

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name = "book_store")
class BookStoreEntity {
    @Id
    var id: Int? = null

    var name: String = ""

    @OneToMany
    var books: List<BookEntity> = emptyList()
}