package com.dvdrental.dao;

import com.dvdrental.dto.CategoryDTO;
import com.dvdrental.model.Category;
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

/**
 * @author Sergey Manko
 */

public class CategoryHibernateDAO implements AbstractDAO<CategoryDTO> {
    @SneakyThrows
    @Override
    public List<CategoryDTO> findAll() {

        List<CategoryDTO> result = new ArrayList<>();
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.getCurrentSession();
        try {
            final Transaction transaction = session.beginTransaction();
            List<Category> categories = new ArrayList<>(
                    session.createQuery("SELECT c FROM Category c", Category.class).getResultList());
            transaction.commit();
            result = categories.stream()
                    .map(this::convertEntityToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public CategoryDTO findById(Long id) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.getCurrentSession();
        Category category = new Category();
        try {
            final Transaction transaction = session.beginTransaction();
            category = session.createQuery("SELECT c FROM Category c WHERE c.categoryID = " + id, Category.class).getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertEntityToDto(category);
    }

    @Override
    public void deleteById(Long id) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.getCurrentSession();
        try {
            final Transaction transaction = session.beginTransaction();
            Category category = new Category();
            category.setCategoryID(id);
            session.delete(category);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CategoryDTO convertEntityToDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryID(category.getCategoryID());
        categoryDTO.setName(category.getName());
        categoryDTO.setLastUpdate(DateUtil.convertDateToString(category.getLastUpdate(), DateUtil.DATE_PAGE_FORMAT));
        return categoryDTO;
    }

    @Override
    public void save(CategoryDTO categoryDTO) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.getCurrentSession();
        try {
            final Transaction transaction = session.beginTransaction();
            session.save(convertDTOFromEntity(categoryDTO));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Category convertDTOFromEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryID(categoryDTO.getCategoryID());
        category.setName(categoryDTO.getName());
        category.setLastUpdate(LocalDateTime.now());
        return category;
    }
}
