CREATE TABLE song_metadata (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    artist VARCHAR(255),
    album VARCHAR(255),
    duration VARCHAR(50),
    year VARCHAR(10)
);
