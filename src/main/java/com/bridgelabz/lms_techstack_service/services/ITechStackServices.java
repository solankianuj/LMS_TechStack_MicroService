package com.bridgelabz.lms_techstack_service.services;

import com.bridgelabz.lms_techstack_service.dto.TechStackDTO;
import com.bridgelabz.lms_techstack_service.model.TechStackModel;
import com.bridgelabz.lms_techstack_service.util.Response;

public interface ITechStackServices {

    Response addTechStack(String token, TechStackDTO techStackDTO);

    Response getTechStack(String token, long techStackId);

    Response updateTechStack(String token, long techStackId, TechStackDTO techStackDTO);

    Response deleteTechStack(String token, long techStackId);
}
