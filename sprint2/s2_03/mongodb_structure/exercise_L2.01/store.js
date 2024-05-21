db.createCollection('store', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'store',
      required: ['store_id', 'name', 'order', 'adress', 'employees'],
      properties: {
        store_id: {
          bsonType: 'objectId'
        },
        name: {
          bsonType: 'string'
        },
        order: {
          bsonType: 'object',
          title: 'object',
          required: ['order_id', 'customer', 'products', 'total_price', 'date_hour'],
          properties: {
            order_id: {
              bsonType: 'objectId'
            },
            customer: {
              bsonType: 'object',
              title: 'object',
              required: ['customer_id', 'name', 'order_type'],
              properties: {
                customer_id: {
                  bsonType: 'objectId'
                },
                name: {
                  bsonType: 'string'
                },
                order_type: {
                  bsonType: 'object',
                  title: 'object',
                  required: ['delivery', 'pick-up_reference'],
                  properties: {
                    delivery: {
                      bsonType: 'object',
                      title: 'object',
                      required: ['street', 'number', 'floor', 'phone', 'rider'],
                      properties: {
                        street: {
                          bsonType: 'string'
                        },
                        number: {
                          bsonType: 'int'
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
                        phone: {
                          bsonType: 'string'
                        },
                        notes: {
                          bsonType: 'string'
                        },
                        rider: {
                          bsonType: 'string'
                        }
                      }
                    },
                    pick - up_reference: {
                      bsonType: 'string'
                    }
                  }
                }
              }
            },
            products: {
              bsonType: 'object',
              title: 'object',
              required: ['pizza'],
              properties: {
                pizza: {
                  bsonType: 'object',
                  title: 'object',
                  required: ['name', 'category', 'description', 'dough', 'price'],
                  properties: {
                    name: {
                      bsonType: 'string'
                    },
                    category: {
                      bsonType: 'string'
                    },
                    description: {
                      bsonType: 'string'
                    },
                    dough: {
                      enum:
                    },
                    price: {
                      bsonType: 'int'
                    },
                    image: {
                      bsonType: 'string'
                    }
                  }
                },
                hamburguer: {
                  bsonType: 'object',
                  title: 'object',
                  required: ['name', 'description', 'price'],
                  properties: {
                    name: {
                      bsonType: 'string'
                    },
                    description: {
                      bsonType: 'string'
                    },
                    price: {
                      bsonType: 'int'
                    },
                    image: {
                      bsonType: 'string'
                    }
                  }
                },
                drink: {
                  bsonType: 'object',
                  title: 'object',
                  required: ['name', 'price'],
                  properties: {
                    name: {
                      bsonType: 'string'
                    },
                    price: {
                      bsonType: 'int'
                    },
                    image: {
                      bsonType: 'string'
                    }
                  }
                }
              }
            },
            total_price: {
              bsonType: 'decimal'
            },
            date_hour: {
              bsonType: 'string'
            }
          }
        },
        adress: {
          bsonType: 'object',
          title: 'object',
          required: ['street', 'number', 'city'],
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
            }
          }
        },
        employees: {
          bsonType: 'object',
          title: 'object',
          required: ['employees_id', 'name', 'second_name', 'NIF', 'phone', 'job'],
          properties: {
            employees_id: {
              bsonType: 'objectId'
            },
            name: {
              bsonType: 'string'
            },
            second_name: {
              bsonType: 'string'
            },
            NIF: {
              bsonType: 'string'
            },
            phone: {
              bsonType: 'string'
            },
            job: {
              bsonType: 'object',
              title: 'object',
              properties: {
                rider: {
                  bsonType: 'string'
                },
                cooker: {
                  bsonType: 'string'
                }
              }
            }
          }
        }
      }
    }
  }
});
