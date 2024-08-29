create table if not exists playlist(
    songId INTEGER PRIMARY KEY AUTO_INCREMENT,
    songName VARCHAR(255),
    lyricist VARCHAR(255),
    singer VARCHAR(255),
    musicDirector VARCHAR(255)
);