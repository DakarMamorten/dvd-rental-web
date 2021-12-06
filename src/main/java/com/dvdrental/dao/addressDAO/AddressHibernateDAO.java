package com.dvdrental.dao.addressDAO;

import com.dvdrental.dao.AbstractDAO;
import com.dvdrental.dto.AddressDTO;
import com.dvdrental.model.Address;
import com.dvdrental.util.DateUtil;
import com.dvdrental.util.HibernateUtil;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressHibernateDAO implements AbstractDAO<AddressDTO> {
    @SneakyThrows
    @Override
    public List<AddressDTO> findAll() {
        List<AddressDTO> result = new ArrayList<>();
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.getCurrentSession();
        try {
            final Transaction transaction = session.beginTransaction();
            List<Address> addresses = new ArrayList<>(
                    session.createQuery("SELECT a FROM  Address a", Address.class).getResultList());
            transaction.commit();
            result = addresses.stream()
                    .map(this::convertEntityToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public AddressDTO findById(Long id) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.getCurrentSession();
        Address address = new Address();
        try {
            final Transaction transaction = session.beginTransaction();
            address = session.createQuery("SELECT a FROM Address a WHERE a.addressId = " + id, Address.class).getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertEntityToDto(address);
    }

    @Override
    public void deleteById(Long id) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.getCurrentSession();
        try {
            final Transaction transaction = session.beginTransaction();
            Address address = new Address();
            address.setAddressId(id);
            session.delete(address);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(AddressDTO addressDTO) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.getCurrentSession();
        try {
            final Transaction transaction = session.beginTransaction();
            session.save(convertDTOFromEntity(addressDTO));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public AddressDTO convertEntityToDto(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(address.getAddressId());
        addressDTO.setAddress(address.getAddress());
        addressDTO.setAddress2(address.getAddress2());
        addressDTO.setDistrict(address.getDistrict());
        addressDTO.setCityId(address.getCityId());
        addressDTO.setPostelCode(address.getPostelCode());
        addressDTO.setPhone(address.getPhone());
        addressDTO.setLastUpdate(DateUtil.convertDateToString(address.getLastUpdate(), DateUtil.DATE_PAGE_FORMAT));
        return addressDTO;
    }

    private Address convertDTOFromEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setAddressId(addressDTO.getAddressId());
        address.setAddress(addressDTO.getAddress());
        address.setAddress2(addressDTO.getAddress2());
        address.setDistrict(addressDTO.getDistrict());
        address.setCityId(addressDTO.getCityId());
        address.setPostelCode(addressDTO.getPostelCode());
        address.setPhone(addressDTO.getPhone());
        address.setLastUpdate(LocalDateTime.now());
        return address;
    }

}
