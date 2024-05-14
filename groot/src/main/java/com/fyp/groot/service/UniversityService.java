package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Culture;
import com.fyp.groot.entity.University;
import com.fyp.groot.repository.UniversityRepository;

@Service
public class UniversityService {
	
	@Autowired
    private UniversityRepository universityRepository;

    public University addUniversity(University university) {
        // Add business logic as required (validation, etc.)
        return universityRepository.save(university);
    }
    
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }
    
    public long countUniversities() {
        return universityRepository.count();
    }

	public University getUniversityById(Long id) {
		return universityRepository.findById(id).orElseThrow();
	}
	
	public University updateUniversity(University university, Long universityId) {

		University existingUniversity = universityRepository.findById(universityId).orElseThrow();
		return universityRepository.save(existingUniversity);
	}
	
	public void deleteUniversity(Long universityId) {
		universityRepository.deleteById(universityId);
	}

}



//public List<UniversityResponse> getUniversitiesByStudentId(Long studentId) {
//    // 1. Fetch the student to ensure it exists
//    Student student = studentRepository.findById(studentId)
//            .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));
//        
//    // 2. Get universities associated with the student
//    Set<University> universities = student.getUniversities(); // Assuming you have this relationship in your Student entity
//
//    // 3. Map to UniversityResponse and return
//    return universities.stream()
//        .map(this::mapUniversityToResponse) // Use your existing mapping method or create a new one
//        .collect(Collectors.toList());
//}