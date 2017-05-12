package com.SiteCV.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SiteCV.domain.Langue;
import com.SiteCV.services.LangueService;


@RestController
@RequestMapping("/Langue")
public class LangueController {

	@Resource
	private LangueService LangueService;

	@Autowired
	public void setLangueService(LangueService LangueService) {
		this.LangueService = LangueService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Langue> getAllLangues() {
		return this.LangueService.listAllLangues();
	}		

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Langue updateLangue(@PathVariable(value = "id") int id, @RequestBody Langue Langue) {
		Langue.setIdLanguage(id);
		return this.LangueService.updateLangue(Langue);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteLangue(@PathVariable(value = "id") int id) {
		this.LangueService.deleteLangue(id);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deleteLangues() {
		this.LangueService.deleteLangues();
	}

	public LangueService getLangueService() {
		return LangueService;
	}

}
