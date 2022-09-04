package com.bridgelabz.lms_techstack_service.controller;

import com.bridgelabz.lms_techstack_service.dto.TechStackDTO;
import com.bridgelabz.lms_techstack_service.services.ITechStackServices;
import com.bridgelabz.lms_techstack_service.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *  Purpose:candidate technology allocation
 * @author Anuj Solanki
 * @date 03/09/2022
 */
@RestController
@RequestMapping("/techStack")
public class TechStackController {

    @Autowired
    ITechStackServices techStackServices;

    /**
     *  Purpose:adding technology
     * @param token
     * @param techStackDTO
     * @return
     */
    @PostMapping("/addTechStack")
    public ResponseEntity<Response> addTechStack(@RequestHeader String token, @Valid @RequestBody TechStackDTO techStackDTO){
        Response response = techStackServices.addTechStack(token,techStackDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     *  Purpose:getting technology
     * @param token
     * @param techStackId
     * @return
     */
    @GetMapping("/getTechStack")
    public ResponseEntity<Response>  getTechStack(@RequestHeader String token,@RequestParam long techStackId){
        Response response =  techStackServices.getTechStack(token,techStackId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /**
     *  Purpose:updating technology
     * @param token
     * @param techStackId
     * @param techStackDTO
     * @return
     */
    @PutMapping("/updateTechStack")
    public ResponseEntity<Response>  updateTechStack(@RequestHeader String token,@RequestParam long techStackId,@Valid @RequestBody TechStackDTO techStackDTO){
        Response response =  techStackServices.updateTechStack(token,techStackId,techStackDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /**
     *  Purpose:deleting technology
     * @param token
     * @param techStackId
     * @return
     */
    @DeleteMapping("/deleteTechStack")
    public ResponseEntity<Response>  deleteTechStack(@RequestHeader String token,@RequestParam long techStackId){
        Response response = techStackServices.deleteTechStack(token,techStackId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
