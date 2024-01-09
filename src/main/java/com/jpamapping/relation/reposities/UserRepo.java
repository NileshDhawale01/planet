package com.jpamapping.relation.reposities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpamapping.relation.entities.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByName(String name);
}
