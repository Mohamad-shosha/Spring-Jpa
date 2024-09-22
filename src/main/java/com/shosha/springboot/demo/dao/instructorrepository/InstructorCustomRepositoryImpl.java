package com.shosha.springboot.demo.dao.instructorrepository;

import com.shosha.springboot.demo.model.entity.Address;
import com.shosha.springboot.demo.model.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class InstructorCustomRepositoryImpl implements InstructorCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String getIdByEmail(String email) {
        String sql = "SELECT instructor_id FROM Instructors WHERE email = :email";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("email", email);
        return (String) query.getSingleResult();
    }

    @Override
    public String getCourseCodeByEmail(String email) {
        String sql = "SELECT course_code FROM Instructors AS I,Courses AS C WHERE email = :email AND" +
                " I.course_id = C.course_id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("email", email);
        return (String) query.getSingleResult();

    }

    public Address getAddressFromInstructor(Instructor instructor) {
        String jpql = "SELECT A FROM Address A WHERE A.id = :addressId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("addressId", instructor.getAddressId());
        return (Address) query.getSingleResult();
    }

    @Override
    public Address getAddressByEmail(String email) {
        String jpql = "SELECT A FROM Address A WHERE A.id = (SELECT I.addressId " +
                "FROM instructors AS I WHERE email = :email) ";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("email", email);
        return (Address) query.getSingleResult();
    }

    @Override
    public Address getAddressByCourseName(String courseName) {
        String jpql = "SELECT A FROM Address A WHERE A.id = (SELECT I.addressId " +
                "FROM Instructor I JOIN Course C ON I.courseId = C.id WHERE C.name = :courseName)";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("courseName", courseName);
        return (Address) query.getSingleResult();
    }
    
}