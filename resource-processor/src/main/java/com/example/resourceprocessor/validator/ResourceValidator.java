package com.example.resourceprocessor.validator;

import org.apache.tika.metadata.Metadata;

import java.util.Arrays;
import java.util.List;

public class ResourceValidator {

    public static void validateMetadata(Metadata metadata) {
        if (metadata == null) {
            throw new IllegalArgumentException("Song metadata is missing or contains errors.");
        }

        List<String> metadataKeys = Arrays.asList("xmpDM:album", "xmpDM:artist", "xmpDM:duration", "xmpDM:releaseDate");

        boolean hasMissingValues = metadataKeys.stream()
                .anyMatch(key -> metadata.get(key).isEmpty());

        if (hasMissingValues) {
            throw new IllegalArgumentException("Song metadata is missing or contains errors.");
        }
    }

}

