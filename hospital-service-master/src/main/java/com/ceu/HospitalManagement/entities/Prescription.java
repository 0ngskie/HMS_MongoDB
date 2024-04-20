package com.ceu.HospitalManagement.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(value = "Prescription")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    private String id;

    private String name;


    @DocumentReference(collection = "User")
    private User doctor;
}
