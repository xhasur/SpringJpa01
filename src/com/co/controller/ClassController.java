package com.co.controller;

import com.co.entidades.Persons;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.co.service.ServiceDba;

@Controller
public class ClassController {

	@Autowired
	ServiceDba serviceDba;

	
	
	@RequestMapping(value = "/create.htm")
	public ModelAndView loadcreate(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("create");
	}

	@RequestMapping(value = "/guardar.htm")
	public ModelAndView guardar(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		Persons objAves = new Persons();
		objAves.setId(Integer.parseInt(request.getParameter("id")));
		objAves.setName(request.getParameter("name"));
		objAves.setAge(Integer.parseInt(request.getParameter("age")));
		try {
			serviceDba.insert(objAves);
			result.put("msg", "Se creo el Usuario  " + request.getParameter("name")
					+ "y Edad  " + request.getParameter("age"));
		} catch (Exception e) {
			if (e instanceof SQLException)
				result.put("msg", "Ya existe ese identificador para Persona");
		}
		return new ModelAndView("create", result);
	}

	@RequestMapping(value = "/view")
	public ModelAndView loadview(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("aves", serviceDba.getPersons());
		} catch (Exception e) {
		}

		return new ModelAndView("view", result);
	}

	@RequestMapping(value = "/delete.htm")
	public ModelAndView test(HttpServletRequest request,
			HttpServletResponse response) {

		Persons objPerson = new Persons();
		objPerson.setId(Integer.parseInt(request.getParameter("id")));
		try {
			serviceDba.deletePersonxId(objPerson);
		} catch (Exception e) {
		}

		return new ModelAndView("view");
	}

	

	@RequestMapping(value = "/consultar")
	public ModelAndView Consultar(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("zonas", serviceDba.getPersons());
		} catch (Exception e) {
		}

		return new ModelAndView("viewconsulta", result);

	}

}
