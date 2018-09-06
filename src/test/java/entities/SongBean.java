package entities;

public class SongBean {

    private long id;
    private String artist;
    private String album;
    private String name;
    private String genre;

    public SongBean(long id, String artist, String album, String name, String genre) {
        this.id = id;
        this.artist = artist;
        this.album = album;
        this.name = name;
        this.genre = genre;
    }

    public long getIdSong() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "{\"artist\":\"" + artist + "\"" +
                ",\"album\":\"" + album + "\"" +
                ",\"name\":\"" + name + "\"" +
                '}';
    }
}