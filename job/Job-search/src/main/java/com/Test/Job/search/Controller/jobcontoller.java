package com.Test.Job.search.Controller;

import com.Test.Job.search.Model.Models;
import com.Test.Job.search.Model.Type;
import com.Test.Job.search.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class jobcontoller {

    @Autowired
    JobService jobservice;


    @PostMapping("posting")
    public String addjob(@RequestBody Models mod){
        return jobservice.addingjob(mod);
    }

    @PostMapping("put/all")
    public String putonce(@RequestBody List<Models> list){
        return jobservice.getallatonce(list);
    }

    @GetMapping("gettingall")
    public List<Models> getjob(){
        return jobservice.getcalled();
    }

    @PutMapping("updating")
    public String upadte(@RequestBody Models mm){
        return jobservice.updating(mm);
    }

    @DeleteMapping("deleting/{id}")
    public String dele(@PathVariable Models id ){
        return jobservice.dele(id);
    }

    @GetMapping("getting/by/companyName/{companyName}")
    public List<Models> getJobByCompanyName(@PathVariable String companyName){
        return jobservice.getJobByCompanyName(companyName);
    }

    @GetMapping("getting/by/title/{title}")
    public List<Models> getJobByTitle(@PathVariable String title){
        return jobservice.getJobByTitle(title);
    }

    @GetMapping("getting/by/salary/{salary}")
    public List<Models> getJobBySalary(@PathVariable Double salary){
        return jobservice.getJobBySalary(salary);
    }

    @PutMapping("jobs/salaryHike/jobType/{type}")
    public String updateSalaryOfSimilarJobType(@PathVariable Type type)
    {
        return jobservice.updateSalaryOfSimilarJobType(type);
    }

    @DeleteMapping("jobs/company/{cName}")
    public String removeAllJobsOfTheSameCompany(@PathVariable String cName)
    {
        return jobservice.removeAllJobsOfTheSameCompany(cName);
    }
}
