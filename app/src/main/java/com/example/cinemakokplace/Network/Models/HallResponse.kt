package com.example.cinemakokplace.Network.Models

data class HallResponse(
    val id:Int ,
    val name: String,
    val cinemaId: Int,
    val gridSize: Int,
    val cinema: CinemaResponse,
    val seats: List<SeatResponse>,
    val filmViews: List<FilmViewResponse>
    /*
    * [
  {
    "id": 0,
    "title": "string",
    "director": "string",
    "description": "string",
    "releaseYear": 0,
    "genre": "string",
    "durationMinutes": 0,
    "poster": "string",
    "filmViews": [
      {
        "id": 0,
        "startTime": "2023-12-14T20:40:46.659Z",
        "filmId": 0,
        "film": "string",
        "hallId": 0,
        "hall": {
          "id": 0,
          "name": "string",
          "cinemaId": 0,
          "gridSize": 0,
          "cinema": {
            "id": 0,
            "name": "string",
            "location": "string",
            "description": "string",
            "companyLogin": "string",
            "logo": "string",
            "company": {
              "login": "string",
              "password": "string",
              "name": "string",
              "address": "string",
              "logo": "string",
              "cinemas": [
                "string"
              ]
            },
            "halls": [
              "string"
            ]
          },
          "seats": [
            {
              "id": 0,
              "rowNumber": 0,
              "seatNumber": 0,
              "hallId": 0,
              "isVIP": true,
              "hall": "string"
            }
          ],
          "filmViews": [
            "string"
          ]
        }
      }
    ]
  }
]
    * */
)
