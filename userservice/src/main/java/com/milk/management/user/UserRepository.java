package com.milk.management.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	User findUserById(long id);
	
	User save(User user) ;
	
	void delete(User user);

	User findUserByMailId(String mailId);
}
