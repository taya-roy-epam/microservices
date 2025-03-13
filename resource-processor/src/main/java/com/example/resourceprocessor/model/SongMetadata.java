package com.example.resourceprocessor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongMetadata {

    Long id;
    String name;
    String artist;
    String album;
    String duration;
    String year;

}
