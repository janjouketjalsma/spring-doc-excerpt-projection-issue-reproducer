Current Spring doc for response for BookStore (only relevant part):
```
      "EntityModelBookStoreEntity": {
        "required": [
          "books",
          "name"
        ],
        "type": "object",
        "properties": {
          "name": {
            "type": "string"
          },
          "_links": {
            "$ref": "#/components/schemas/Links"
          }
        }
      },
```
Source: http://localhost:8080/v3/api-docs

Expected Spring doc for response based on actual response:
```
      "EntityModelBookStoreEntity": {
        "required": [
          "books",
          "name"
        ],
        "type": "object",
        "properties": {
          "name": {
            "type": "string"
          },
          "_embedded" : {
            "type": "object",
            "properties": {
              "books": {
                "type": "array",
                "items": {
                  "type": "object",
                  "properties": {
                    "name": {
                      "type": "string"
                    },
                    "_links": {
                      "$ref": "#/components/schemas/Links"
                    }
                  }
                }
              }
            }
          }
          "_links": {
            "$ref": "#/components/schemas/Links"
          }
        }
      },
```

Actual response example:
```
{
  "name" : "Store",
  "_embedded" : {
    "books" : [ {
      "title" : "Hello",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/bookEntities/1{?projection}",
          "templated" : true
        }
      }
    }, {
      "title" : "World",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/bookEntities/2{?projection}",
          "templated" : true
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/bookStoreEntities/1"
    },
    "bookStoreEntity" : {
      "href" : "http://localhost:8080/bookStoreEntities/1"
    },
    "books" : {
      "href" : "http://localhost:8080/bookStoreEntities/1/books{?projection}",
      "templated" : true
    }
  }
}
```
Source: http://localhost:8080/bookStoreEntities/1
