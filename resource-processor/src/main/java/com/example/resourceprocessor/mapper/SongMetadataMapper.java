package com.example.resourceprocessor.mapper;

import com.example.resourceprocessor.model.SongMetadata;
import org.apache.tika.metadata.Metadata;

public class SongMetadataMapper {

    public static SongMetadata mapToSongMetadata(Integer id, Metadata metadata) {
        SongMetadata songMetadata = new SongMetadata();
        songMetadata.setId(Long.valueOf(id));
        songMetadata.setName(metadata.get("xmpDM:album"));
        songMetadata.setArtist(metadata.get("xmpDM:artist"));
        songMetadata.setAlbum(metadata.get("xmpDM:album"));
        songMetadata.setDuration(formatDuration(metadata.get("xmpDM:duration")));
        songMetadata.setYear(metadata.get("xmpDM:releaseDate"));
        return songMetadata;
    }

    private static String formatDuration(String duration) {
        double durationInSeconds = Double.parseDouble(duration);

        int minutes = (int) durationInSeconds / 60;
        int seconds = (int) durationInSeconds % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

}
