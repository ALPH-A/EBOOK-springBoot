package tn.spring.bookStore.service;

import java.util.List;

import tn.spring.bookStore.exception.ServiceValidationException;

public interface AbstractService<T, Bean, PK> {

	T findById(PK id) throws ServiceValidationException;

	List<T> findAll();

	T save(Bean b) throws ServiceValidationException;

	void deleteById(PK id) throws ServiceValidationException;

}
