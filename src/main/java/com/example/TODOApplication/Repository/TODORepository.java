package com.example.TODOApplication.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.TODOApplication.Entity.Todo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class TODORepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Todo todo) {
		entityManager.persist(todo);

	}

	public List<Todo> findAll() {
		TypedQuery<Todo> typedQuery = entityManager.createQuery("from Todo", Todo.class);
		return typedQuery.getResultList();
	}

	public Optional<Todo> findTODOById(Long id) {
		Todo todo = entityManager.find(Todo.class, id);
		return Optional.ofNullable(todo);

	}

	@Transactional
	public void updateTodo(Todo todo) {
		entityManager.merge(todo);
	}

	@Transactional
	public void deleteTODOById(Long id) {
		Todo todo = entityManager.find(Todo.class, id);
		if (todo != null) {
			entityManager.remove(todo);
		}
	}

}
