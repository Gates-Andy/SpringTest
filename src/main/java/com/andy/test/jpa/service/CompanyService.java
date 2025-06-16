package com.andy.test.jpa.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.jpa.domain.Company;
import com.andy.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public Company addCompany(int id, String name, String business, String scale, int headcount) {

		Company company_name = Company.builder().id(id).name(name).business(business).scale(scale).headcount(headcount)
				.createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build();

		Company result = companyRepository.save(company_name);

		return result;

	}

	public Company updateCompany(int id, String scale, int headcount) {
		Optional<Company> optionalCompany = companyRepository.findById(id);

		if (optionalCompany.isPresent()) {
			Company company = optionalCompany.get();

			company = company.toBuilder().scale(scale).headcount(headcount).build();

			Company result = companyRepository.save(company);

			return result;

		} else {

			return null;

		}

	}

	public void deleteCompany(int id) {
		Optional<Company> optionalCompany = companyRepository.findById(id);

		if (optionalCompany.isPresent()) {

			Company company = optionalCompany.get();

			companyRepository.delete(company);

		} else {

			System.out.println("삭제할 회사가 존재하지 않습니다. id=" + id);

		}

	}

}
