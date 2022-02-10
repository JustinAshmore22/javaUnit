--   -Guesses
--        -text
--        - word of the day
--        - (if multiplayer) player_id
--        - example: "trust" is text and it is about the word of the day "scrap"
--      -Words of day
--        - day
--        - text
--        - example: "scrap", "2020-10-12"

--CREATE TABLE People(
--name TEXT PRIMARY KEY,
--day DATE NOT NULL,
--age int NOT NULL
--);
--
CREATE TABLE VehicleOwns2 (
name TEXT,
FOREIGN KEY (name) REFERENCES People(name) ON DELETE CASCADE,
make TEXT NOT NULL,
model TEXT NOT NULL,
year int NOT NULL
);


CREATE TABLE cars (
make TEXT,

model TEXT NOT NULL,

year INTEGER NOT NULL,
cost INTEGER

);

