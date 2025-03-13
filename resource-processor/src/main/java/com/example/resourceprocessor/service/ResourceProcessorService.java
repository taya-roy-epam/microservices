package com.example.resourceprocessor.service;
import com.example.resourceprocessor.mapper.SongMetadataMapper;
import com.example.resourceprocessor.model.SongMetadata;
import com.example.resourceprocessor.validator.ResourceValidator;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import org.xml.sax.ContentHandler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class ResourceProcessorService {

    public SongMetadata extractMetadata(Integer id, byte[] fileBytes) {
        try (InputStream input = new ByteArrayInputStream(fileBytes)) {
            ContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            AutoDetectParser parser = new AutoDetectParser();
            parser.parse(input, handler, metadata, new ParseContext());
            ResourceValidator.validateMetadata(metadata);
            return SongMetadataMapper.mapToSongMetadata(id, metadata);
        } catch (Exception e) {
            throw new IllegalArgumentException("The request body is invalid MP3.");
        }
    }

}
