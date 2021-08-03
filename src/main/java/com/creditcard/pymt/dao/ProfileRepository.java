package com.creditcard.pymt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.pymt.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	Profile findByProfileId(int id);
}
