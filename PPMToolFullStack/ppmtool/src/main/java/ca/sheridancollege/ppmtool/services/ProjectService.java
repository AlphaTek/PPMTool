package ca.sheridancollege.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.ppmtool.domain.Project;
import ca.sheridancollege.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	
	public Project saveOrUpdateProject(Project project) {
		
		//Logic
		
		return projectRepository.save(project);
	}
	
}
