package ca.sheridancollege.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.ppmtool.domain.Project;
import ca.sheridancollege.ppmtool.exceptions.ProjectIdException;
import ca.sheridancollege.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	// Logic
	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException(
					"Project ID '" + project.getProjectIdentifier().toUpperCase() + "already exists");

		}
	}

	public Project findProjectByIdentifier(String projectId) {

		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

		if (project == null) {

			throw new ProjectIdException("Project ID '" + projectId.toUpperCase() + "' does not exist' ");
		}

		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectid) {
		
		Project project = projectRepository.findByProjectIdentifier(projectid.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Cannot delete Project with ID '" + projectid + "'. This project does not exist");
		}
		
		projectRepository.delete(project);
	}

}
