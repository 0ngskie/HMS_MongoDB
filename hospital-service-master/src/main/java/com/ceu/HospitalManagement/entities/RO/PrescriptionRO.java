package com.ceu.HospitalManagement.entities.RO;
import com.ceu.HospitalManagement.entities.Prescription;
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
public class PrescriptionRO {
    private String id;

    private String name;

    private User doctor;

    public Prescription toEntity(Prescription prescription) {

        if (Objects.isNull(prescription)) {
            prescription = new Prescription();
        }

        prescription.setName(name);
        prescription.setDoctor(doctor);

        return prescription;
    }
}
