package com.example.usersbooking.service.users;

import com.example.usersbooking.utils.dto.UserDto;
import com.example.usersbooking.model.User;
import com.example.usersbooking.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository _repository;

    @Override
    public Iterable<UserDto> getAll(){
        List<UserDto> users = new ArrayList<UserDto>();
         _repository.findAll().stream().forEach(u->{
                     users.add(new UserDto(u.getName(), u.getActive(), u.getUntil(),
                                u.getAge(), u.getEmail(), u.getPhone(), u.getProfession()));
                    });
         return users;
    }

    @Override
    public UserDto getById(String id){
        Optional<User> user = _repository.findById(id);
        if(user.isPresent()){
            User us = user.get();
            return new UserDto(us.getName(),us.getActive(),us.getUntil(),us.getAge(),
                    us.getEmail(),us.getPhone(),us.getProfession());
        }
        return null;
    }

    @Override
    public UserDto updateSuscription(UserDto user,String id){
        _repository.findById(id)
                .map(u->{
                    u.setName(user.getName());
                    u.setActive(user.getActive());
                    u.setAge(user.getAge());
                    u.setEmail(user.getEmail());
                    u.setPhone(user.getPhone());
                    u.setProfession(user.getProfession());
                    u.setUntil(user.getUntil());

                    return  _repository.save(u);
                }).orElseGet(()->{
                    User u = new User(user.getName(),
                            user.getActive(),
                            user.getUntil(),
                            user.getAge(),
                            user.getEmail(),
                            user.getPhone(),
                            user.getProfession());

                    return _repository.save(u);
                });

        return user;
    }

    @Override
    public UserDto create(UserDto user) {

        User u = new User(user.getName(),
                user.getActive(),
                user.getUntil(),
                user.getAge(),
                user.getEmail(),
                user.getPhone(),
                user.getProfession());
        _repository.save(u);
        return user;
    }

    @Override
    public User delete(String id) {
        return _repository.findById(id)
                .map(u->{
                    _repository.delete(u);
                    return u;
                }).orElseGet(()->{
                    return null;
                });
    }
}
