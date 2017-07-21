package org.latin.latinrest.service;

import org.latin.common.Gender;
import org.latin.latinrest.dao.BasicNounModelDao;
import org.latin.latinrest.model.BasicNounModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NounService {

	@Autowired
	BasicNounModelDao nounDao;
	
	public BasicNounModel get(String nominativeSingular) { 
		return nounDao.findOne(nominativeSingular);
	}
	
	public void create(String nominativeSingular, String genitiveSingular, Gender gender) { 
		BasicNounModel basicNoun = new BasicNounModel(nominativeSingular, genitiveSingular, gender);	
		
		nounDao.save(basicNoun);
	}
	
	public void delete(String nominativeSingular) { 
		if(nounDao.exists(nominativeSingular))		
			nounDao.delete(nominativeSingular);
	}	
}
