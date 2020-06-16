package com.apidesign.customerapidemo2.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apidesign.customerapidemo2.models.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{
	//JPA refers class and fields not table
			@Query("select address from Address address where address.customer.customerId=:customerId")
			public List<Address> findByCustomerId(@Param("customerId") long customerId);

}