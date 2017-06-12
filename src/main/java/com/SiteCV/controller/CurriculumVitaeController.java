package com.SiteCV.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SiteCV.domain.CurriculumVitae;
import com.SiteCV.services.CurriculumVitaeService;


@RestController
@RequestMapping("/CurriculumVitae")
public class CurriculumVitaeController {

	@Resource
	private CurriculumVitaeService CurriculumVitaeService;

	@Autowired
	public void setCurriculumVitaeService(CurriculumVitaeService CurriculumVitaeService) {
		this.CurriculumVitaeService = CurriculumVitaeService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<CurriculumVitae> getAllCurriculumVitaes() {
		return this.CurriculumVitaeService.listAllCurriculumVitaes();
	}		
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public CurriculumVitae getById(@PathVariable(value = "id") int id) {
		return this.CurriculumVitaeService.getCurriculumVitaeById(id);
	}	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public CurriculumVitae updateCurriculumVitae(@PathVariable(value = "id") int id, @RequestBody CurriculumVitae CurriculumVitae) {
		CurriculumVitae.setIdCurriculumVitae(id);
		return this.CurriculumVitaeService.updateCurriculumVitae(CurriculumVitae);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCurriculumVitae(@PathVariable(value = "id") int id) {
		this.CurriculumVitaeService.deleteCurriculumVitae(id);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deleteCurriculumVitaes() {
		this.CurriculumVitaeService.deleteCurriculumVitaes();
	}

	public CurriculumVitaeService getCurriculumVitaeService() {
		return CurriculumVitaeService;
	}

}
