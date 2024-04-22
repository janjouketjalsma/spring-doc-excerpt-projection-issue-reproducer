package com.example.helloworld

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "book")
class BookEntity {
    @Id
    var id: Int? = null

    var title: String = ""

    var description: String = ""
}