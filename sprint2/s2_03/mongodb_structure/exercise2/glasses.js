db.createCollection('glasses', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'glasses',
      required: ['id_glasses', 'frame', 'provider', 'price', 'bought_by'],
      properties: {
        id_glasses: {
          bsonType: 'objectId'
        },
        brand: {
          bsonType: 'string'
        },
        frame: {
          bsonType: 'object',
          title: 'object',
          required: ['metallic', 'pasta', 'flotant'],
          properties: {
            metallic: {
              bsonType: 'string'
            },
            pasta: {
              bsonType: 'string'
            },
            flotant: {
              bsonType: 'string'
            }
          }
        },
        provider: {
          bsonType: 'object',
          title: 'object',
          required: ['id_provider', 'name', 'phone', 'email', 'NIF', 'adress'],
          properties: {
            id_provider: {
              bsonType: 'int'
            },
            name: {
              bsonType: 'string'
            },
            phone: {
              bsonType: 'string'
            },
            email: {
              bsonType: 'string'
            },
            NIF: {
              bsonType: 'string'
            },
            adress: {
              bsonType: 'object',
              title: 'object',
              required: ['street', 'number', 'city', 'postal_code', 'country'],
              properties: {
                street: {
                  bsonType: 'string'
                },
                number: {
                  bsonType: 'string'
                },
                floor: {
                  bsonType: 'string'
                },
                door: {
                  bsonType: 'string'
                },
                city: {
                  bsonType: 'string'
                },
                postal_code: {
                  bsonType: 'string'
                },
                country: {
                  bsonType: 'string'
                }
              }
            }
          }
        },
        price: {
          bsonType: 'int'
        },
        bought_by: {
          bsonType: 'object',
          title: 'object',
          required: ['id_client', 'name', 'info_client'],
          properties: {
            id_client: {
              bsonType: 'objectId'
            },
            name: {
              bsonType: 'string'
            },
            info_client: {
              bsonType: 'object',
              title: 'object',
              required: ['name', 'phone', 'mail', 'adress'],
              properties: {
                name: {
                  bsonType: 'string'
                },
                phone: {
                  bsonType: 'string'
                },
                mail: {
                  bsonType: 'string'
                },
                adress: {
                  bsonType: 'object',
                  title: 'object',
                  properties: {
                    street: {
                      bsonType: 'string'
                    },
                    number: {
                      bsonType: 'string'
                    },
                    floor: {
                      bsonType: 'string'
                    },
                    door: {
                      bsonType: 'string'
                    },
                    city: {
                      bsonType: 'string'
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
});
