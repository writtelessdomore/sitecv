package com.SiteCvs.services.impl;

import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SiteCvs.domain.Partie;
import com.SiteCvs.repositories.PartieRepository;
import com.SiteCvs.services.PartieService;

@Service
public class PartieServiceImpl implements PartieService{

	private PartieRepository PartieRepository;

	@Autowired
	public void setPartieRepository(PartieRepository PartieRepository) {
		this.PartieRepository = PartieRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Partie> listAllParties() {
		return IteratorUtils.toList(this.PartieRepository.findAll().iterator());
	}
	
	public Partie getLastPartie(){
		
		Partie partieRes = new Partie();
		
		@SuppressWarnings("unchecked")
		Collection<Partie> listPartie = IteratorUtils.toList(this.PartieRepository.findAll().iterator());
		for(Partie partie : listPartie){
		 partieRes = partie;
		}
		return partieRes;
	}

	@Override
	public Partie getPartieById(Integer id) {
		return this.PartieRepository.findOne(id);
	}

	@Override
	public Partie updatePartie(Partie Partie) {
		return this.PartieRepository.save(Partie);
	}
	
	@Override
	public Partie addPartie(Partie Partie) {
		return this.PartieRepository.save(Partie);
	}

	@Override
	public void deletePartie(int id) {
		this.PartieRepository.delete(id);
	}

	@Override
	public void deleteParties() {
		this.PartieRepository.deleteAll();
	}

}
