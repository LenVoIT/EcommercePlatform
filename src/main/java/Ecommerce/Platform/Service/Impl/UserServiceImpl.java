package Ecommerce.Platform.Service.Impl;

import Ecommerce.Platform.Entity.UserEntity;
import Ecommerce.Platform.Model.UserDTO;
import Ecommerce.Platform.Repository.UserRepository;
import Ecommerce.Platform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity create(UserDTO dto) {
        return null;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Iterable<UserEntity> findAll() {
        return null;
    }

    @Override
    public UserEntity findById(int id) {
        return null;
    }

    @Override
    public UserEntity update(int id, UserDTO dto) {
        return null;
    }
}
