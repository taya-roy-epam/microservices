package com.example.ResourceService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteSongMetadataResponse {

    String message;
    Integer[] ids;
}
