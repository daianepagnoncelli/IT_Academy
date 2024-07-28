db.createCollection("games", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      title: "games",
      required: ["_id", "dice1", "dice2", "isWin", "idPlayer"],
      properties: {
        _id: {
          bsonType: "objectId",
          description: "must be an objectId and is required",
        },
        dice1: {
          bsonType: "int",
          description: "must be an integer and is required",
        },
        dice2: {
          bsonType: "int",
          description: "must be an integer and is required",
        },
        isWin: {
          bsonType: "bool",
          description: "must be a boolean and is required",
        },
        idPlayer: {
          bsonType: "int",
          description: "must be an integer and is required",
        },
        _class: {
          bsonType: "string",
          description: "must be a string",
        },
      },
    },
  },
});
