db.createCollection('playlist', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'playlist',
      required: ['name', 'publishedBy', 'creationDate', 'state', 'videos'],
      properties: {
        name: {
          bsonType: 'string'
        },
        publishedBy: {
          bsonType: 'objectId'
        },
        creationDate: {
          bsonType: 'timestamp'
        },
        state: {
          enum:
        },
        videos: {
          bsonType: 'array',
          items: {
            title: 'object',
            required: ['title', 'size', 'fileName', 'duration', 'thumbnail', 'reprodutions', 'state', 'channel', 'idUser', 'idReactedTo', 'idUser', 'idReactedTo'],
            properties: {
              title: {
                bsonType: 'string'
              },
              description: {
                bsonType: 'string'
              },
              size: {
                bsonType: 'string'
              },
              fileName: {
                bsonType: 'string'
              },
              duration: {
                bsonType: 'string'
              },
              thumbnail: {
                bsonType: 'string'
              },
              reprodutions: {
                bsonType: 'int'
              },
              likesCount: {
                bsonType: 'int'
              },
              dislikesCount: {
                bsonType: 'int'
              },
              state: {
                enum:
              },
              channel: {
                bsonType: 'object',
                title: 'object',
                required: ['name', 'user'],
                properties: {
                  name: {
                    bsonType: 'string'
                  },
                  description: {
                    bsonType: 'string'
                  },
                  creationDate: {
                    bsonType: 'string'
                  },
                  user: {
                    bsonType: 'object',
                    title: 'object',
                    required: ['name', 'email', 'password', 'birthDate', 'gender', 'country', 'postal_code', 'mySubscriptions', 'idUser', 'idReactedTo'],
                    properties: {
                      name: {
                        bsonType: 'string'
                      },
                      email: {
                        bsonType: 'string'
                      },
                      password: {
                        bsonType: 'string'
                      },
                      birthDate: {
                        bsonType: 'date'
                      },
                      gender: {
                        enum:
                      },
                      country: {
                        enum:
                      },
                      postal_code: {
                        bsonType: 'string'
                      },
                      mySubscriptions: {
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
              },
              tags: {
                bsonType: 'array',
                items: {
                  bsonType: 'string'
                }
              },
              subscribers: {
                bsonType: 'array',
                items: {
                  bsonType: 'objectId'
                }
              },
              idUser: {
                bsonType: 'objectId'
              },
              idReactedTo: {
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
      }
    }
  }
});
