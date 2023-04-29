package com.gl.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.entity.Student;
import com.gl.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	public StudentService studentService;

	@RequestMapping("/list")
	public String StudentList(Model model) {
		List<Student> theStudents = studentService.findAll();
		model.addAttribute("students", theStudents);
		return "list-student";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("StudentId") int id, Model themodel) {
		Student student = studentService.findById(id);
		themodel.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("lname") String lname,
			@RequestParam("fname") String fname, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		System.out.println(id);
		Student student;
		if (id != 0) {
			student = studentService.findById(id);
			student.setFname(fname);
			student.setLname(lname);
			student.setCourse(course);
			student.setCountry(country);
		} else
			student = new Student(fname, lname, course, country);

		studentService.save(student);
		return "redirect:students/list";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("StudentId") int id) {
		studentService.deleteByTn(id);
		return "redirect:students/list";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi" + user.getName() + ", No access for this page");
		} else {
			model.addObject("msg", " No access for this page");
		}
		
		model.setViewName("403");
		return model;
	}

	{
			
	}

}
