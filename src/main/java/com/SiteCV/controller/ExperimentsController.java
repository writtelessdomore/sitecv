package com.SiteCV.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SiteCV.domain.Experiments;
import com.SiteCV.services.ExperimentsService;


@RestController
@RequestMapping("/Experiments")
public class ExperimentsController {

	@Resource
	private ExperimentsService ExperimentsService;

	@Autowired
	public void setExperimentsService(ExperimentsService ExperimentsService) {
		this.ExperimentsService = ExperimentsService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Experiments> getAllExperimentss() {
		return this.ExperimentsService.listAllExperimentss();
	}		

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Experiments updateExperiments(@PathVariable(value = "id") int id, @RequestBody Experiments Experiments) {
		Experiments.setIdExperiments(id);
		return this.ExperimentsService.updateExperiments(Experiments);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteExperiments(@PathVariable(value = "id") int id) {
		this.ExperimentsService.deleteExperiments(id);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deleteExperimentss() {
		this.ExperimentsService.deleteExperimentss();
	}

	public ExperimentsService getExperimentsService() {
		return ExperimentsService;
	}

}
