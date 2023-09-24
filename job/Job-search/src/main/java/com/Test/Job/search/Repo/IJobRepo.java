package com.Test.Job.search.Repo;

import com.Test.Job.search.Model.Models;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Models, Integer> {
    List<Models> findByCompanyName(String companyName);

    List<Models> findByTitle(String title);

    List<Models> findBySalaryGreaterThanEqual(Double salary);

    @Modifying
    @Transactional
    @Query(value = "update Models Set salary = salary+ (salary+10/100) where job_Type= :type", nativeQuery = true)
    void updateAllSalaryOfSimilarType(String type);

    @Modifying
    @Transactional
    @Query(value ="Delete From Models where company_Name= :cName", nativeQuery = true)
    void deleteJobsFromTheSameCompany(String cName);
}


