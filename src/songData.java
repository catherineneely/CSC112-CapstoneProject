// Catherine Neely

public class songData {

    private String songGenre;
    private String songArtist;
    private int songPopularity;
    private String songAlbum;
    private String songName;
    private String songAlbumYear;
    private String songSubgenre;

    // constructors
    public songData() {
        this.songGenre = "";
        this.songArtist = "";
        this.songPopularity = 0;
        this.songAlbum = "";
        this.songName = "";
        this.songAlbumYear = "";
        this.songSubgenre = "";
    }
    public songData(String SG, String SArt, int SP, String SAlb, String SN, String SAY, String SSG) {
        this.songGenre = SG;
        this.songArtist = SArt;
        this.songPopularity = SP;
        this.songAlbum = SAlb;
        this.songName = SN;
        this.songAlbumYear = SAY;
        this.songSubgenre = SSG;
    }

    // getter and setter methods
    public String getSongGenre() {
        return songGenre;
    }
    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }
    public String getSongArtist() {
        return songArtist;
    }
    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }
    public int getSongPopularity() {
        return songPopularity;
    }
    public void setSongPopularity(int songPopularity) {
        this.songPopularity = songPopularity;
    }
    public String getSongAlbum() {
        return songAlbum;
    }
    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }
    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public String getSongAlbumYear() {
        return songAlbumYear;
    }
    public void setSongAlbumYear(String songAlbumYear) {
        this.songAlbumYear = songAlbumYear;
    }
    public String getSongSubgenre() {
        return songSubgenre;
    }
    public void setSongSubgenre(String songSubgenre) {
        this.songSubgenre = songSubgenre;
    }
}
