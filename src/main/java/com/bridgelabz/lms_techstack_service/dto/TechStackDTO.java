package com.bridgelabz.lms_techstack_service.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * purpose:creating candidate technology dto and adding validation on candidate technology dto
 * @author Anuj Solanki
 */
@Data
public class TechStackDTO {
    @NotEmpty(message = "imagePath Can't be Null.")
    private String imagePath;
    private boolean status;
    @NotEmpty(message = "techName is required")
    private String techName;
    @NotEmpty(message = "creatorUser is required")
    private String creatorUser;

}
