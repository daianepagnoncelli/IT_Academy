db.createCollection('comments', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'comments',
      required: ['text', 'publicationDate', 'publishedBy', 'likesCount', 'dislikesCount', 'idCommentedItem', 'idUser', 'idReactedTo'],
      properties: {
        text: {
          bsonType: 'string'
        },
        publicationDate: {
          bsonType: 'date'
        },
        publishedBy: {
          bsonType: 'date'
        },
        likesCount: {
          bsonType: 'int'
        },
        dislikesCount: {
          bsonType: 'int'
        },
        idCommentedItem: {
          bsonType: 'objectId'
        },
        idUser: {
          bsonType: 'objectId'
        },
        idReactedTo: {
          bsonType: 'objectId'
        }
      }
    }
  }
});
