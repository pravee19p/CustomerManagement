package com.profileproject.customerprofilemangement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profileproject.customerprofilemangement.entity.Profile;
import com.profileproject.customerprofilemangement.repository.ProfileRepository;


@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    public Object getAllCustomer;

    public Profile createCustomer(Profile profile) {
       return profileRepository.save(profile);
    }

    public Optional<Profile> getCustomerById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile updateCustomer(Long id, Profile profile) {
        Optional<Profile> p=profileRepository.findById(id);
        if(p.isPresent()){
            Profile profile2=p.get();
            profile2.setEmail(profile.getEmail());
            profile2.setFirstName(profile.getFirstName());
            profile2.setLastName(profile.getLastName());
            profile2.setPhoneNumber(profile.getPhoneNumber());
            return profileRepository.save(profile2);
        }

        if (profileRepository.existsById(id)) {
            profile.setId(id);
            return profileRepository.save(profile);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        profileRepository.deleteById(id);
    }

    public List<Profile> getAllCustomers() {
        return  profileRepository.findAll();
        

    }
}


