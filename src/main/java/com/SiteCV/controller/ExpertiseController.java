package com.SiteCV.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SiteCV.domain.Expertise;
import com.SiteCV.services.ExpertiseService;


@RestController
@RequestMapping("/expertise")
public class ExpertiseController {

	@Resource
	private ExpertiseService ExpertiseService;

	@Autowired
	public void setExpertiseService(ExpertiseService ExpertiseService) {
		this.ExpertiseService = ExpertiseService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Expertise> getAllExpertises() {
		return this.ExpertiseService.listAllExpertises();
	}		

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Expertise updateExpertise(@PathVariable(value = "id") int id, @RequestBody Expertise Expertise) {
		Expertise.setIdExpertise(id);
		return this.ExpertiseService.updateExpertise(Expertise);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteExpertise(@PathVariable(value = "id") int id) {
		this.ExpertiseService.deleteExpertise(id);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deleteExpertises() {
		this.ExpertiseService.deleteExpertises();
	}

	public ExpertiseService getExpertiseService() {
		return ExpertiseService;
	}

}
