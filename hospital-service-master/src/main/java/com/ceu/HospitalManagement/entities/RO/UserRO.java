package com.ceu.HospitalManagement.entities.RO;

import com.ceu.HospitalManagement.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRO {

    private String id;

    private String name;

    private int yearOfService;

    private String specialty;

    public User toEntity(User user) {

        if (Objects.isNull(user)) {
            user = new User();
        }

        user.setName(name);
        user.setYearOfService(yearOfService);
        user.setSpecialty(specialty);

        return user;
    }
}
