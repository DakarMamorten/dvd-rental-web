package com.dvdrental.dao.customer;

import com.dvdrental.dao.AbstractDAO;
import com.dvdrental.dto.CustomerDTO;
import com.dvdrental.model.Customer;
import com.dvdrental.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Manko
 */
public class CustomerHibernateDAO implements AbstractDAO<CustomerDTO> {
	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerDTO> result = new ArrayList<>();
		final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		try {
			final Transaction transaction = session.beginTransaction();
			result.addAll(session.createQuery("SELECT c FROM Customer c ", Customer.class)
					.getResultStream()
					.map(this::convertEntityToDto)
					.collect(Collectors.toList()));
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public CustomerDTO findById(Long id) {
		final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		Customer customer = new Customer();
		try {
			final Transaction transaction = session.beginTransaction();
			customer = session.createQuery("SELECT c FROM Customer c WHERE c.customerId = " + id, Customer.class)
					.getSingleResult();
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return convertEntityToDto(customer);
	}

	@Override
	public void deleteById(Long id) {
		final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		try {
			final Transaction transaction = session.beginTransaction();
			Customer customer = new Customer();
			customer.setCustomerId(id);
			session.delete(customer);
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(CustomerDTO customerDTO) {
		final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		try {
			final Transaction transaction = session.beginTransaction();
			session.save(convertDTOToEntity(customerDTO));
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CustomerDTO convertEntityToDto(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setStoreId(customer.getStoreId());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setAddressId(customer.getAddressId());
		customerDTO.setActivebool(customer.isActivebool());
		customerDTO.setCreateDate(customer.getCreateDate().toLocalDate());
		customerDTO.setLastUpdate(customer.getLastUpdate());
		customerDTO.setActive(customer.getActive());
		return customerDTO;
	}

	private Customer convertDTOToEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setStoreId(customerDTO.getStoreId());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setEmail(customerDTO.getEmail());
		customer.setAddressId(customerDTO.getAddressId());
		customer.setActivebool(customerDTO.isActivebool());
//		customer.setCreateDate(
//				Date.valueOf(DateUtil.convertDateToString(customerDTO.getLastUpdate(), DateUtil.DATE_PAGE_FORMAT)));
		customer.setLastUpdate(LocalDateTime.now());
		customer.setActive(customerDTO.getActive());
		return customer;
	}
}
