	package com.SiteCV.services;

import java.util.Collection;

import com.SiteCV.domain.Langue;

public interface LangueService {

	Collection<Langue> listAllLangues();

	Langue getLangueById(Integer id);

	Langue addLangue(Langue Langue);

	Langue updateLangue(Langue Langue);

	void deleteLangue(int id);

	void deleteLangues();

}
