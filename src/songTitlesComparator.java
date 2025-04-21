// Catherine Neely

import java.util.Comparator;

public class songTitlesComparator implements Comparator<songData>{
    @ Override
    public int compare(songData D1, songData D2) {
        return D1.getSongName().compareToIgnoreCase(D2.getSongName());
    }
}
