package com.example.fileUpploaderAndDownloader.controllers;

import com.example.fileUpploaderAndDownloader.DTO.DownloadProfilePictureDTO;
import com.example.fileUpploaderAndDownloader.entities.UserEntity;
import com.example.fileUpploaderAndDownloader.repositories.UserRepository;
import com.example.fileUpploaderAndDownloader.services.FileStorageService;
import com.example.fileUpploaderAndDownloader.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    FileStorageService fileStorageService;

    @PostMapping
    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }

    @GetMapping("/getAll")
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getOne(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserEntity user) {
        user.setId(id);
        userRepository.save(user);
    }

    @SneakyThrows
    @GetMapping("/{id}/profile")
    public @ResponseBody byte[] getProfileImage(@PathVariable Long id, HttpServletResponse response) {
        DownloadProfilePictureDTO downloadProfilePictureDTO = userService.downloadProfilePicture(id);
        String filename = downloadProfilePictureDTO.getUser().getProfilePicture();
        if (filename == null) throw new Exception("User doesn't have a picture");
        String extension = FilenameUtils.getExtension(downloadProfilePictureDTO.getUser().getProfilePicture());
        switch (extension) {
            case "jpg":
            case "jpeg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "gif":
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
            case "png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
        }
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + filename + "\"");
        return downloadProfilePictureDTO.getProfileImage();
    }


    @PostMapping("/{id}/profile")
    public UserEntity uploadProfileImage(@PathVariable Long id, @RequestParam MultipartFile profilepic) {
        return userService.uploadProfilePic(id, profilepic);

    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id) {
        userService.remove(id);
    }
}
