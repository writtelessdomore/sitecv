package com.SiteCV.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SiteCV.domain.Formation;
import com.SiteCV.services.FormationService;


@RestController
@RequestMapping("/Formation")
public class FormationController2 {

	@Resource
	private FormationService FormationService;

	@Autowired
	public void setFormationService(FormationService FormationService) {
		this.FormationService = FormationService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Formation> getAllFormations() {
		return this.FormationService.listAllFormations();
	}		

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Formation updateFormation(@PathVariable(value = "id") int id, @RequestBody Formation Formation) {
		Formation.setIdFormation(id);
		return this.FormationService.updateFormation(Formation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteFormation(@PathVariable(value = "id") int id) {
		this.FormationService.deleteFormation(id);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deleteFormations() {
		this.FormationService.deleteFormations();
	}

	public FormationService getFormationService() {
		return FormationService;
	}

}
