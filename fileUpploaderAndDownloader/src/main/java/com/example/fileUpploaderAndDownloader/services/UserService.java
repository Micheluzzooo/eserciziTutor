package com.example.fileUpploaderAndDownloader.services;

import com.example.fileUpploaderAndDownloader.DTO.DownloadProfilePictureDTO;
import com.example.fileUpploaderAndDownloader.entities.UserEntity;
import com.example.fileUpploaderAndDownloader.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @SneakyThrows
    private UserEntity getUser(Long userId){
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()) throw new Exception("User not found");
        return optionalUser.get();
    }

    @SneakyThrows
    public UserEntity uploadProfilePic(Long userId, MultipartFile profilePic) {
        UserEntity user = getUser(userId);
        if(user.getProfilePicture() != null) {
            fileStorageService.remove(user.getProfilePicture());
        }
        String filename = fileStorageService.upload(profilePic);
        user.setProfilePicture(filename);
        return userRepository.save(user);
    }

    @SneakyThrows
    public DownloadProfilePictureDTO downloadProfilePicture(Long userId)  {
        UserEntity user = getUser(userId);

        DownloadProfilePictureDTO dto = new DownloadProfilePictureDTO();
        dto.setUser(user);

        if(user.getProfilePicture() == null) return dto;

        byte[] profilePictureBytes = fileStorageService.download(user.getProfilePicture());
        dto.setProfileImage(profilePictureBytes);
        return dto;
    }

    @SneakyThrows
    public void remove(Long userId) {
        UserEntity user = getUser(userId);
        if(user.getProfilePicture() != null) {
            fileStorageService.remove(user.getProfilePicture());
        }
        userRepository.deleteById(userId);
    }
}
