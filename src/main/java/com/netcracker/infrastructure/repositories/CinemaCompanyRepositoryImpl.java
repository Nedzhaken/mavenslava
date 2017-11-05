package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.CinemaCompany;

import java.util.ArrayList;

public class CinemaCompanyRepositoryImpl implements CinemaCompanyRepository {
    private ArrayList<CinemaCompany> companies=new ArrayList<CinemaCompany>();

    @Override
    public void save(CinemaCompany company) {
        companies.add(company);
        System.out.println("Save successfully = "+company.getCompanyid()+" "+company.getName()+" "+company.getCountryname());
    }

    @Override
    public ArrayList<CinemaCompany> load() {
        if (companies.size()==0) {
            System.out.println("Не один стиль не был введен");
            return null;
        }
        else {
            for(int index=0;index<companies.size();index++){
                System.out.println(companies.get(index).getCompanyid()+" "+companies.get(index).getName()+" "+companies.get(index).getCountryname());
            }
            return companies;
        }
    }
}
