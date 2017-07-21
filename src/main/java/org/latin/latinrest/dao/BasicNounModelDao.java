package org.latin.latinrest.dao;

import org.latin.latinrest.model.BasicNounModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface BasicNounModelDao extends CrudRepository<BasicNounModel, String>{

}
