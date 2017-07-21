package org.latin.latinrest.controller;

import org.latin.common.Gender;
import org.latin.latinrest.model.BasicNounModel;
import org.latin.latinrest.service.NounService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noun")
public class NounController {
	
	@Autowired
	NounService nounService;
	
	@GetMapping(value="/{nominative}")
	public BasicNounModel getNoun(@PathVariable(name="nominative") String nominativeSingular) {
		return nounService.get(nominativeSingular);
	}
	
	@PutMapping(value="/create")
	public void createNoun(
			@RequestParam String nominativeSingular, 
			@RequestParam String genitiveSingular, 
			@RequestParam Gender gender) {
		nounService.create(nominativeSingular, genitiveSingular, gender);
	}
	
	@DeleteMapping(value="/{nominative}")
	public void deleteNoun(@PathVariable(name="nominative") String nominativeSingular) { 	
		nounService.delete(nominativeSingular);
	}
	
}
