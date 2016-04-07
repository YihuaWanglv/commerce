package com.iyihua.commerce.remote.user;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import com.iyihua.commerce.model.user.User;

public interface UserRemote {

	public User findUserById(Long id);
	public User createUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException;
	public void deleteUser(Long id); 
	public User findUserByName(String username);
	public User updateUser(User user, Boolean isUpdateSelected) throws NoSuchAlgorithmException, InvalidKeySpecException;
	public List<String> findByUserId(Long userId);
}
