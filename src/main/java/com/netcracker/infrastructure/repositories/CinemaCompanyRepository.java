package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.CinemaCompany;

import java.util.ArrayList;

public interface CinemaCompanyRepository {
        public void save(CinemaCompany style);
        public ArrayList<CinemaCompany> load();
}
