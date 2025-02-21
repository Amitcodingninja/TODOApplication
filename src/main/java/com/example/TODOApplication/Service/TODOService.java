package com.example.TODOApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.TODOApplication.Entity.Todo;
import com.example.TODOApplication.Repository.TODORepository;

@Service
public class TODOService {
	
	@Autowired
	TODORepository todoRepository;

	public void saveTodo(Todo todo) {
		
		todoRepository.save(todo);
		
		
		
	}

	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
		
		
	}

	public void updateTodo(Long id, Todo newtodo) {
		Optional<Todo> todoOldBox = todoRepository.findTODOById(id);
		if (todoOldBox.isPresent()) {
			Todo oldTodo =todoOldBox.get();
			oldTodo.setTaskContent(newtodo.getTaskContent());
			oldTodo.setCompletionStatus(newtodo.getCompletionStatus());
			todoRepository.updateTodo(oldTodo);
		}
		
	}

	public void deleteTODO(Long id) {
		todoRepository.deleteTODOById(id);
	}

}
