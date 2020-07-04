package com.apidesign.customerapidemo2.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apidesign.customerapidemo2.models.Address;
import com.apidesign.customerapidemo2.models.Customer;
import com.apidesign.customerapidemo2.repositories.AddressRepository;
import com.apidesign.customerapidemo2.repositories.CustomerRepository;
@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private EntityManager entityManager;
	// insert the address for the specific customer
	public Address saveAddress(long customerId,Address address)
	{
		Customer customer=customerService.getCustomerById(customerId);
		if(customer!=null)
		{
			address.setCustomer(customer);
			addressRepo.save(address);
			return address;
		}
		else
			return null;
		
	}
	
	public List<Address> getAllAddresses(long customerId)
	{
		return this.addressRepo.findByCustomerId(customerId);
	}
	
}
