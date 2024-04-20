package com.reservationapp4.service;


import com.reservationapp4.entity.UserRegistration;
import com.reservationapp4.payload.UserRegistrationDto;
import com.reservationapp4.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    public UserRegistrationDto createUser(UserRegistration userRegistration){
        userRegistrationRepository.save(userRegistration);
        return null;
    }

    public UserRegistration getUserbyId(long id) {
       return userRegistrationRepository.findById(id).get();
    }
}
