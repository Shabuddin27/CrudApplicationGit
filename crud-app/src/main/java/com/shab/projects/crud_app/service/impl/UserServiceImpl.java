package com.shab.projects.crud_app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shab.projects.crud_app.dto.BikeDTO;
import com.shab.projects.crud_app.dto.UserDTO;
import com.shab.projects.crud_app.entity.BikeEntity;
import com.shab.projects.crud_app.entity.ContactEntity;
import com.shab.projects.crud_app.entity.SkillsEntity;
import com.shab.projects.crud_app.entity.UserEntity;
import com.shab.projects.crud_app.mapper.Mappers;
import com.shab.projects.crud_app.repository.BikeRepository;
import com.shab.projects.crud_app.repository.ContactInfoRepository;
import com.shab.projects.crud_app.repository.SkillsRepository;
import com.shab.projects.crud_app.repository.UserRepository;
import com.shab.projects.crud_app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BikeRepository bikeRepository;

	@Autowired
	private ContactInfoRepository contactRepository;
	
	@Autowired
	private SkillsRepository skillsRepository;

	@Autowired
	private Mappers mappers;

	@Override
	public String addUser(UserDTO userDTO) {

		// Convert UserDTO to UserEntity using MapStruct
		UserEntity userEntity = mappers.userDTOToUserEntity(userDTO);

		// Save the UserEntity first
		userRepository.save(userEntity); // This will persist the UserEntity and generate an ID

		// If the contactEntity is provided, save it separately
		if (userEntity.getContactEntity() != null) {
			ContactEntity contactEntity = userEntity.getContactEntity();
			contactEntity.setUser(userEntity); // Associate the contact with the already saved user
			contactRepository.save(contactEntity); // Now save the ContactEntity
		}

		// If the bikeEntity list is provided, save each bike entity and associate it
		// with the user
		if (userEntity.getBikeEntity() != null) {
			for (BikeEntity bikeEntity : userEntity.getBikeEntity()) {
				bikeEntity.setUser(userEntity); // Associate bike with user
				bikeRepository.save(bikeEntity); // Save each BikeEntity separately
			}
		}

		if (userEntity.getSkillsEntity() != null) {
		    for (SkillsEntity skillsEntity : userEntity.getSkillsEntity()) {
		        if (skillsEntity.getUser() == null) {
		            skillsEntity.setUser(new ArrayList<>()); // Initialize the list if it's null
		        }
		        skillsEntity.getUser().add(userEntity); // Add the user to the skill's user list
		        skillsRepository.save(skillsEntity); // Save each SkillsEntity separately
		    }
		}


		return "User " + userDTO.getName() + " added successfully";
	}

	@Override
	public List<UserDTO> getAllUsers() {
	    List<UserEntity> userEntities = userRepository.findAll();

	    // Convert UserEntities to UserDTOs using MapStruct
	    return userEntities.stream()
	        .map(mappers::userEntityToUserDTO)
	        .collect(Collectors.toList());
	}

	
	@Transactional
	@Override
	public String updateUser(int id, UserDTO userDTO) {
	    Optional<UserEntity> existingUserOpt = userRepository.findById(id);

	    if (existingUserOpt.isPresent()) {
	        UserEntity existingUser = existingUserOpt.get();

	        // Update only the provided fields in UserEntity
	        mappers.updateUserEntityFromDTO(userDTO, existingUser);

	        // Handle ContactEntity update
	        if (userDTO.getContactDto() != null) {
	            if (existingUser.getContactEntity() != null) {
	                mappers.updateContactEntityFromDTO(userDTO.getContactDto(), existingUser.getContactEntity());
	            } else {
	                ContactEntity newContactEntity = mappers.contactDTOToContactEntity(userDTO.getContactDto());
	                newContactEntity.setUser(existingUser);
	                existingUser.setContactEntity(newContactEntity);
	            }
	        }

	        // Handle BikeEntity updates
	        if (userDTO.getBikeDto() != null) {
	            for (BikeDTO bikeDTO : userDTO.getBikeDto()) {
	                if (bikeDTO.getId() != 0) {
	                    // Update existing bikes
	                    bikeRepository.findById(bikeDTO.getId()).ifPresent(existingBike -> 
	                        mappers.updateBikeEntityFromDTO(bikeDTO, existingBike)
	                    );
	                } else {
	                    // Add new bikes
	                    BikeEntity newBikeEntity = mappers.bikeDTOToBikeEntity(List.of(bikeDTO)).get(0);
	                    newBikeEntity.setUser(existingUser);
	                    existingUser.getBikeEntity().add(newBikeEntity);
	                }
	            }
	        }

	        // Save the updated UserEntity
	        userRepository.save(existingUser);

	        return "User " + id + " updated successfully";
	    }

	    return "User " + id + " not found";
	}









	@Override
	public String deleteUser(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return "User " + id + " deleted successfully";
		}
		return "User " + id + " not found";
	}
}
