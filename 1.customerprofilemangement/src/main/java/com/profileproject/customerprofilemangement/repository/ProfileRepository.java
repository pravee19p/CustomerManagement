package com.profileproject.customerprofilemangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profileproject.customerprofilemangement.entity.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
