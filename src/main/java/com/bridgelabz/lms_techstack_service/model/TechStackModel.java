package com.bridgelabz.lms_techstack_service.model;

import com.bridgelabz.lms_techstack_service.dto.TechStackDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * purpose:creating candidate technology model
 * @author Anuj Solanki
 */
@Entity
@Table(name = "techStackData")
@Data
public class TechStackModel {
    @Id
    @GenericGenerator(name = "techStackData",strategy = "increment")
    @GeneratedValue(generator = "techStackData")
    @Column(name = "techStackId")
    private long id;
//    @OneToOne
    private String creatorUser;
    private String imagePath;
    private boolean status;
    private String techName;
    @JsonIgnore
    private LocalDateTime creatorTime;

    public TechStackModel(TechStackDTO techStackDTO) {
        this.techName=techStackDTO.getTechName();
        this.imagePath=techStackDTO.getImagePath();
        this.status=techStackDTO.isStatus();
        this.creatorUser=techStackDTO.getCreatorUser();
    }

    public TechStackModel() {

    }
}
