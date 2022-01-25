package com.example.demo.service;

import com.example.demo.exception.CustomException;
import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private IEmployee repository;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee)  {
        try{
            checkout(employee);
        }catch(Exception e){
            throw new CustomException(e.getMessage());
        }
            return repository.save(employee);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        if(employee.getId()!=null && repository.existsById(employee.getId())){
            return repository.saveAndFlush(employee);
        }else{
            throw new CustomException("Something got wrong while updating client");
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(id!=null && id>0){
            repository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public Optional<Employee> findById(Long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public boolean existById(Long id) {
        return repository.existsById(id);
    }

    void checkout(Employee employee) throws Exception{
        if(employee.getName().isEmpty() || employee.getName().isBlank()){
            throw new CustomException("The name can't be null or empty");
        }
        if(employee.getBirthDate()==null){
            throw new CustomException("The date can't be null");
        }
        if(employee.getLastName().isEmpty() || employee.getLastName().isBlank()){
            throw new CustomException("The last name can't be null or empty");
        }
        if(employee.getCompanyBondingDate()==null){
            throw new CustomException("The bonding date to the company can't be null or empty");
        }
        if(employee.getPosition().isBlank() || employee.getPosition().isEmpty()){
            throw new CustomException("The position can't be null or empty");
        }
        if(employee.getSalary()<=0){
            throw new CustomException("The salary can't be less than 0 or 0");
        }
        if(employee.getDocumentNumber().length()<10 || employee.getDocumentNumber().isEmpty() || employee.getDocumentNumber().isBlank()){
            throw new CustomException("The employee document must have 10 digits and not be null or empty");
        }
        int actual= getYears(employee.getBirthDate(), employee.getCompanyBondingDate());
        if(actual<18){
            throw new CustomException("The employee must have 18+");
        }
    }

    public int getYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
                        a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }

    public Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
