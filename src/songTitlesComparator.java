// Catherine Neely

import java.util.Comparator;

public class songTitlesComparator implements Comparator<songData>{
    @ Override
    public int compare(songData D1, songData D2) {
        return Integer.compare(D1.getSongAlbumYear(), D2.getSongAlbumYear());
    }
}
