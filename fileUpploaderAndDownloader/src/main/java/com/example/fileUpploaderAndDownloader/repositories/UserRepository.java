package com.example.fileUpploaderAndDownloader.repositories;

import com.example.fileUpploaderAndDownloader.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
