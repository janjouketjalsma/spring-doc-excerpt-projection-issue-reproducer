# Excerpt projection not included in OpenAPI
This is a reproducer project demonstrating that the excerpt projection does not get included in the OpenAPI spec.

The behaviour that should be documented is described here: 
https://docs.spring.io/spring-data/rest/reference/projections-excerpts.html#projections-excerpts.excerpts

Excerpt from page:
> For example, you can alter the PersonRepository as follows:
```
@RepositoryRestResource(excerptProjection = NoAddresses.class)
interface PersonRepository extends CrudRepository<Person, Long> {}
```
> The preceding example directs Spring Data REST to use the NoAddresses projection when embedding Person resources into collections or related resources.

Although this functionality works as advertised, the projection does not get detected by Spring Doc.

## Examples
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
