package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Major;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.REPOSITORY.MajorRepository;

@Service
@Transactional
public class MajorSerivice {

	private MajorRepository majorRepository;

	public MajorSerivice(MajorRepository majorDAO) {
		this.majorRepository = majorDAO;
	}

	public Iterable<Major> findAll() {
		return majorRepository.findAll();
	}

	public Major findByMajorName(String majorName) {
		return majorRepository.findByMajorName(majorName);
	}

	public void save(Major major) {
		majorRepository.save(major);
	}

}
