package com.example.TODOApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.TODOApplication.Entity.Todo;
import com.example.TODOApplication.Service.TODOService;

@Controller
public class TODOController {

	// For Getting Service Layer Object
	@Autowired
	TODOService todoService;

	@RequestMapping(value = "/addtodo", method = RequestMethod.POST)
	@ResponseBody
	public String createTODO(@ModelAttribute Todo todo) {
		todoService.saveTodo(todo);
		return "success";

	}

	// For Showing on Browser Page

//	@RequestMapping
//	public String loadForm() {
//		return "task";
//	}

	@RequestMapping("/")
	public String getAllTodo(Model model) {
		List<Todo> listOfTodos = todoService.getAllTodos();
		model.addAttribute("listoftodos", listOfTodos);
		return "task";

	}

	@RequestMapping(value = "/updatetodo/{id}")
	public String updateTodo(@PathVariable("id") Long id, @ModelAttribute Todo todo) {
     todoService.updateTodo(id,todo);
     return "redirect:/";
	}
	
	
	@RequestMapping("/deleteTODO/{id}")
	public String deleteTodo(@PathVariable("id") Long id) {
		todoService.deleteTODO(id);
		return "redirect:/";
	}
	

}

//It will not search html page , directly it will return success string on page 
