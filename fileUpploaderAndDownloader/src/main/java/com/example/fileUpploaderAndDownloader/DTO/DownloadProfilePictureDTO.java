package com.example.fileUpploaderAndDownloader.DTO;

import com.example.fileUpploaderAndDownloader.entities.UserEntity;
import lombok.Data;

@Data
public class DownloadProfilePictureDTO {

    private UserEntity user;
    private byte[] profileImage;

}
