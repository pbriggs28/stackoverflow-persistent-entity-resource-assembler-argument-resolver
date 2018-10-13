package com.prestonb.edu.dao;

import com.prestonb.edu.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author pbriggs
 */
public interface UserRepository extends CrudRepository<User, Long>  {

}
