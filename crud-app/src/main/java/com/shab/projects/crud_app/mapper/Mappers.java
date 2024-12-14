package com.shab.projects.crud_app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.shab.projects.crud_app.dto.BikeDTO;
import com.shab.projects.crud_app.dto.ContactDTO;
import com.shab.projects.crud_app.dto.SkillsDTO;
import com.shab.projects.crud_app.dto.UserDTO;
import com.shab.projects.crud_app.entity.BikeEntity;
import com.shab.projects.crud_app.entity.ContactEntity;
import com.shab.projects.crud_app.entity.SkillsEntity;
import com.shab.projects.crud_app.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface Mappers {

    @Mapping(target = "contactEntity", source = "contactDto")
    @Mapping(target = "bikeEntity", source = "bikeDto")
    @Mapping(target = "skillsEntity", source = "skillsDto")
    UserEntity userDTOToUserEntity(UserDTO userDTO);

    @Mapping(target = "contactDto", source = "contactEntity")
    @Mapping(target = "bikeDto", source = "bikeEntity")
    @Mapping(target = "skillsDto", source = "skillsEntity")
    UserDTO userEntityToUserDTO(UserEntity userEntity);

    @Mapping(target = "user", ignore = true) // Make sure user is not set directly for ContactEntity
    ContactEntity contactDTOToContactEntity(ContactDTO contactDTO);

    ContactDTO contactEntityToContactDTO(ContactEntity contactEntity);

    @Mapping(target = "user", ignore = true) // Ensure user is not set directly for BikeEntity
    List<BikeEntity> bikeDTOToBikeEntity(List<BikeDTO> bikeDTO);

    List<BikeDTO> bikeEntityToBikeDTO(List<BikeEntity> bikeEntity);

    @Mapping(target = "user", ignore = true) // If you want to ignore the user field in SkillsEntity here, fine
    List<SkillsEntity> skillsDTOToSkillsEntity(List<SkillsDTO> skillsDTO);

    List<SkillsDTO> skillsEntityTOSkillsDTO(List<SkillsEntity> skillsEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contactEntity", ignore = true)
    @Mapping(target = "bikeEntity", ignore = true)
    @Mapping(target = "skillsEntity", ignore = true)
    void updateUserEntityFromDTO(UserDTO userDTO, @MappingTarget UserEntity existingUserEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateContactEntityFromDTO(ContactDTO contactDTO, @MappingTarget ContactEntity contactEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateBikeEntityFromDTO(BikeDTO bikeDTO, @MappingTarget BikeEntity bikeEntity);

}
