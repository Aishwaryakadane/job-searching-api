package com.Test.Job.search.Service;

import com.Test.Job.search.Model.Models;
import com.Test.Job.search.Model.Type;
import com.Test.Job.search.Repo.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    IJobRepo jobRepo;

    public String addingjob(Models mod) {
        jobRepo.save(mod);
        return "added";
    }


    public List<Models> getcalled() {
        return (List<Models>) jobRepo.findAll();
    }

    public String updating(Models mm) {
        jobRepo.save(mm);
        return "updated";
    }

    public String getallatonce(List<Models> list) {
        jobRepo.saveAll(list);
        return list.size() + "added";
    }

    public String dele(Models id) {
        jobRepo.delete(id);
        return "deleted";
    }

    public List<Models> getJobByCompanyName(String companyName) {
      return jobRepo.findByCompanyName(companyName);
    }

    public List<Models> getJobByTitle(String title) {
        return jobRepo.findByTitle(title);
    }

    public List<Models> getJobBySalary(Double salary) {
        return jobRepo.findBySalaryGreaterThanEqual(salary);
    }

    public String updateSalaryOfSimilarJobType(Type type) {
        jobRepo.updateAllSalaryOfSimilarType(type.name());

        return "Salaries Updated";
    }

    public String removeAllJobsOfTheSameCompany(String cName) {

        jobRepo.deleteJobsFromTheSameCompany(cName);

        return"Jobs Deleted from the Same Company";
    }
}
