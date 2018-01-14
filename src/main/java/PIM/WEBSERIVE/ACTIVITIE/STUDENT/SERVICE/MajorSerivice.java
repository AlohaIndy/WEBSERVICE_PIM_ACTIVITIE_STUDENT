package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.DAO.MajorDAO;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Major;

@Service
@Transactional
public class MajorSerivice {

	private MajorDAO majorDAO;

	public MajorSerivice(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}

	public Iterable<Major> findAll() {
		return majorDAO.findAll();
	}

	public Major findByMajorName(String majorName) {
		return majorDAO.findByMajorName(majorName);
	}

	public void save(Major major) {
		majorDAO.save(major);
	}

}
