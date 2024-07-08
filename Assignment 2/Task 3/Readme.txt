INSERT INTO SERIES (ID, NAME, DESCRIPTION) VALUES
(1, 'Cricket World Cup 2024', 'The premier international cricket competition featuring teams from around the world.'),
(2, 'T20 World Cup 2024', 'A fast-paced Twenty20 cricket tournament featuring international teams.');

INSERT INTO MATCH (ID, TEAMA, TEAMB, DATE, SERIES_ID) VALUES
(1, 'India', 'Australia', '2024-07-15', 1),
(2, 'England', 'Pakistan', '2024-07-16', 1),
(3, 'South Africa', 'New Zealand', '2024-07-17', 2),
(4, 'Sri Lanka', 'West Indies', '2024-07-18', 2);






Series API Endpoints



1)Create a Series

URL: /api/series
Method: POST
Request Body:
json
Copy code
{
  "name": "Series Name",
  "description": "Description of the series",
  "matches": [
    {
      "teamA": "Team A",
      "teamB": "Team B",
      "date": "2024-07-15"
    }
  ]
}


2)Get All Series

URL: /api/series
Method: GET
Response Body:
json
Copy code
[
  {
    "id": 1,
    "name": "Series Name",
    "description": "Description of the series",
    "matches": [
      {
        "id": 1,
        "teamA": "Team A",
        "teamB": "Team B",
        "date": "2024-07-15"
      }
    ]
  }
]


3)Get a Specific Series by ID

URL: /api/series/{id}
Method: GET
Response Body:
json
Copy code
{
  "id": 1,
  "name": "Series Name",
  "description": "Description of the series",
  "matches": [
    {
      "id": 1,
      "teamA": "Team A",
      "teamB": "Team B",
      "date": "2024-07-15"
    }
  ]
}


4)Update a Series

URL: /api/series/{id}
Method: PUT
Request Body:
json
Copy code
{
  "name": "Updated Series Name",
  "description": "Updated description of the series",
  "matches": [
    {
      "id": 1,
      "teamA": "Updated Team A",
      "teamB": "Updated Team B",
      "date": "2024-07-16"
    }
  ]
}


5)Delete a Series

URL: /api/series/{id}
Method: DELETE



Match API Endpoints

Create a Match

URL: /api/matches
Method: POST
Request Body:
json
Copy code
{
  "teamA": "Team A",
  "teamB": "Team B",
  "date": "2024-07-15",
  "series": {
    "id": 1
  }
}


6)Get All Matches

URL: /api/matches
Method: GET
Response Body:
json
Copy code
[
  {
    "id": 1,
    "teamA": "Team A",
    "teamB": "Team B",
    "date": "2024-07-15",
    "series": {
      "id": 1
    }
  }
]


7)Get a Specific Match by ID

URL: /api/matches/{id}
Method: GET
Response Body:
json
Copy code
{
  "id": 1,
  "teamA": "Team A",
  "teamB": "Team B",
  "date": "2024-07-15",
  "series": {
    "id": 1
  }
}


8)Update a Match

URL: /api/matches/{id}
Method: PUT
Request Body:
json
Copy code
{
  "teamA": "Updated Team A",
  "teamB": "Updated Team B",
  "date": "2024-07-16",
  "series": {
    "id": 1
  }
}


9)Delete a Match

URL: /api/matches/{id}
Method: DELETE


H2 Console
URL: /h2-console
Method: GET
Description: Access the H2 database console for querying and managing the in-memory database.