--   -Guesses
--        -text
--        - word of the day
--        - (if multiplayer) player_id
--        - example: "trust" is text and it is about the word of the day "scrap"
--      -Words of day
--        - day
--        - text
--        - example: "scrap", "2020-10-12"

CREATE TABLE People(
name TEXT PRIMARY KEY,
day DATE NOT NULL,
age int NOT NULL
);

CREATE TABLE VehicleOwns (
FOREIGN KEY (name) REFERENCES People(name),
make TEXT NOT NULL,
model TEXT NOT NULL,
year INTEGER NOT NULL,
day DATE NOT NULL REFERENCES person(day)
);


CREATE TABLE carsBuy (
make TEXT NOT NULL,
model TEXT NOT NULL,
year INTEGER NOT NULL
);

