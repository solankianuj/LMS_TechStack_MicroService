package com.bridgelabz.lms_techstack_service.services;

import com.bridgelabz.lms_techstack_service.dto.TechStackDTO;
import com.bridgelabz.lms_techstack_service.exception.TechStackNotFound;
import com.bridgelabz.lms_techstack_service.model.TechStackModel;
import com.bridgelabz.lms_techstack_service.repository.ITechStackRepository;
import com.bridgelabz.lms_techstack_service.util.Response;
import com.bridgelabz.lms_techstack_service.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 *  Purpose:creating different candidate technology services
 * @author Anuj Solanki
 * @date 03/09/2022
 */
@Service
public class TechStackServices implements ITechStackServices {

    @Autowired
    ITechStackRepository techStackRepository;

    @Autowired
    Token tokenUtil;
    @Autowired
    RestTemplate restTemplate;

    /**
     * Purpose:adding technology
     * @param token
     * @param techStackDTO
     * @return
     */
    @Override
    public Response addTechStack(String token, TechStackDTO techStackDTO) {
        boolean isUserPresent=restTemplate.getForObject("http://localhost:8082/admin/validatingUser/"+token, Boolean.class);
        if(isUserPresent){
        TechStackModel techStackModel = new TechStackModel(techStackDTO);
        techStackModel.setCreatorTime(LocalDateTime.now());
        techStackRepository.save(techStackModel);
        return new Response("TechStack added",200,techStackModel);
        }
        throw new TechStackNotFound(200,"Admin Not Found !");
    }

    /**
     * Purpose:getting technology
     * @param token
     * @param techStackId
     * @return
     */
    @Override
    public Response getTechStack(String token, long techStackId) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validatingUser/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<TechStackModel> techStackModel = techStackRepository.findById(techStackId);
            if (techStackModel.isPresent()) {
                return new Response("Fetching TechStack  Details", 200, techStackModel.get());
            }
            throw new TechStackNotFound(200, "TechStack Not Available");
        }
        throw new TechStackNotFound(200, "Admin Not Available");
    }

    /**
     * Purpose:updating techStack details
     * @param token
     * @param techStackId
     * @param techStackDTO
     * @return
     */
    @Override
    public Response updateTechStack(String token, long techStackId, TechStackDTO techStackDTO) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validatingUser/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<TechStackModel> techStackModel = techStackRepository.findById(techStackId);
            if (techStackModel.isPresent()) {
                techStackModel.get().setTechName(techStackDTO.getTechName());
                techStackModel.get().setImagePath(techStackDTO.getImagePath());
                techStackModel.get().setStatus(techStackDTO.isStatus());
                techStackModel.get().setCreatorUser(techStackDTO.getCreatorUser());
                techStackRepository.save(techStackModel.get());
                return new Response("Updating TechStack details", 200, techStackModel.get());
            }
            throw new TechStackNotFound(200, "TechStack Not Available");
        }
        throw new TechStackNotFound(200, "Admin Not Available");

    }

    /**
     * Purpose:deleting technology
     * @param token
     * @param techStackId
     * @return
     */
    @Override
    public Response deleteTechStack(String token, long techStackId) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validatingUser/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<TechStackModel> techStackModel = techStackRepository.findById(techStackId);
            if (techStackModel.isPresent()) {
                techStackRepository.delete(techStackModel.get());
                return new Response("Deleting TechStack ", 200, techStackModel.get());

            }
            throw new TechStackNotFound(200, "TechStack Not Available");

        }
        throw new TechStackNotFound(200, "Admin Not Available");

    }
}