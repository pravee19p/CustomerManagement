package com.profileproject.customerprofilemangement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profileproject.customerprofilemangement.dto.ProfileDTO;

import com.profileproject.customerprofilemangement.entity.Profile;
import com.profileproject.customerprofilemangement.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    // Convert Profile entity to ProfileDTO
    private ProfileDTO convertToDTO(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setId(profile.getId());
        profileDTO.setFirstName(profile.getFirstName());
        profileDTO.setLastName(profile.getLastName());
        profileDTO.setEmail(profile.getEmail());
        profileDTO.setPhoneNumber(profile.getPhoneNumber());
        profileDTO.setAddress(profile.getAddress());
        return profileDTO;
    }

    // Convert ProfileDTO to Profile entity
    private Profile convertToEntity(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setId(profileDTO.getId());
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setEmail(profileDTO.getEmail());
        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setAddress(profileDTO.getAddress());
        return profile;
    }

    // Create a new profile
    public ProfileDTO createCustomer(ProfileDTO profileDTO) {
        Profile profile = convertToEntity(profileDTO);
        Profile savedProfile = profileRepository.save(profile);
        return convertToDTO(savedProfile);
    }

    // Get a profile by ID
    public Optional<ProfileDTO> getCustomerById(Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.map(this::convertToDTO);
    }

    // Update an existing profile
    public ProfileDTO updateCustomer(Long id, ProfileDTO profileDTO) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            profile.setFirstName(profileDTO.getFirstName());
            profile.setLastName(profileDTO.getLastName());
            profile.setEmail(profileDTO.getEmail());
            profile.setPhoneNumber(profileDTO.getPhoneNumber());
            profile.setAddress(profileDTO.getAddress());
            Profile updatedProfile = profileRepository.save(profile);
            return convertToDTO(updatedProfile);
        } else {
            throw new RuntimeException("Profile not found");
        }
    }

    // Delete a profile
    public void deleteCustomer(Long id) {
        profileRepository.deleteById(id);
    }

    // Get all profiles
    public List<ProfileDTO> getAllCustomers() {
        List<Profile> profiles = profileRepository.findAll();
        return profiles.stream()
                       .map(this::convertToDTO)
                       .collect(Collectors.toList());
    }
}





// package com.profileproject.customerprofilemangement.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.profileproject.customerprofilemangement.entity.Profile;
// import com.profileproject.customerprofilemangement.repository.ProfileRepository;


// @Service
// public class ProfileService {

//     @Autowired
//     private ProfileRepository profileRepository;
//     public Object getAllCustomer;

//     public Profile createCustomer(Profile profile) {
//        return profileRepository.save(profile);
//     }

//     public Optional<Profile> getCustomerById(Long id) {
//         return profileRepository.findById(id);
//     }

//     public Profile updateCustomer(Long id, Profile profile) {
//         Optional<Profile> p=profileRepository.findById(id);
//         if(p.isPresent()){
//             Profile profile2=p.get();
//             profile2.setEmail(profile.getEmail());
//             profile2.setFirstName(profile.getFirstName());
//             profile2.setLastName(profile.getLastName());
//             profile2.setPhoneNumber(profile.getPhoneNumber());
//             return profileRepository.save(profile2);
//         }

//         if (profileRepository.existsById(id)) {
//             profile.setId(id);
//             return profileRepository.save(profile);
//         }
//         return null;
//     }

//     public void deleteCustomer(Long id) {
//         profileRepository.deleteById(id);
//     }

//     public List<Profile> getAllCustomers() {
//         return  profileRepository.findAll();
        

//     }
// }


