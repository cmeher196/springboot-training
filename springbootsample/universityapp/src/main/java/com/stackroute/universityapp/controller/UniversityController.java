package com.stackroute.universityapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.universityapp.exception.UniversityAlreadyExistException;
import com.stackroute.universityapp.exception.UniversityNotFoundException;
import com.stackroute.universityapp.model.University;
import com.stackroute.universityapp.service.UniversityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/university")
public class UniversityController {

	
	@Autowired
	UniversityService userve;
	
	
	@GetMapping("/showdetails/{uniname}")
	public ResponseEntity<?> getuniversitydetails(@PathVariable("uniname") String uname)
	{
		University uobj=userve.finduniversitybyname(uname);
		return new ResponseEntity<University>(uobj,HttpStatus.OK);
	}
	
	@PostMapping("/addUniversity")
	
	public ResponseEntity<?> saveuniverse(@RequestBody University uninew)
	{
		try {
		University uniresult=userve.addUniversity(uninew);
			return new ResponseEntity<University>(uniresult,HttpStatus.OK);
		} 
		catch (UniversityAlreadyExistException e) {
			 
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
	
	@GetMapping("/showuniversities")
	public ResponseEntity<?> show()
	{
		
		List<University> universities=userve.getallUniversitites();
		return new ResponseEntity<List>(universities,HttpStatus.OK);
	}
	
	
	@ApiOperation(value="delete",response=Iterable.class)
	@ApiResponses(
			value= {
					
					@ApiResponse(code=200,message="University record is deleted"),
					@ApiResponse(code=404,message="University id is invalid hence no records deleted")
			}
			)
	
	@DeleteMapping ("/deleteuniversity/{paramid}")
	
	public ResponseEntity<?> deletedata(@PathVariable("paramid") String universeid)
	{
		try {
			userve.deleteUniversity(universeid);
			return new ResponseEntity<String>("deleted",HttpStatus.OK);
			
		} catch (UniversityNotFoundException e) {
		 
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}
	}
	
	
	
	@PutMapping("/modifyuniversity")
	public ResponseEntity<?> modifydata(@RequestBody University universe)
	{
		
	try {
		University	modiuni=userve.modifyUniversity(universe);
		return new ResponseEntity<University>(modiuni,HttpStatus.OK);
		
		
	}
	
	catch (UniversityNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
		
	}
	
}








