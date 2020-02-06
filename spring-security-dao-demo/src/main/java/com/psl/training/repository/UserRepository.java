package com.psl.training.repository;

import java.util.Optional;

import com.psl.training.model.User;

public interface UserRepository //extends JpaRepository<User,Long> {
{
	
	public Optional<User> findByUsername(String username);
}
