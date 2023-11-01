package com.soaasignment.User.Service.repositories;

import com.soaasignment.User.Service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
