package com.co.controller;

import com.co.entidades.Countries;
import com.co.entidades.Regions;
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
import java.math.BigDecimal;
import java.math.BigInteger;

@Controller
public class ClassController {

    @Autowired
    ServiceDba serviceDba;

    @RequestMapping(value = "/view")
    public ModelAndView loadview(HttpServletRequest request,
            HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result.put("countries", serviceDba.getCountries());
        } catch (Exception e) {
        }

        return new ModelAndView("view", result);
    }

    @RequestMapping(value = "/delete.htm")
    public ModelAndView delete(HttpServletRequest request,
            HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        Countries objCountries = new Countries();
        objCountries.setCountryId(request.getParameter("id"));
        try {
            serviceDba.deleteCountryxId(objCountries);
            result.put("countries", serviceDba.getCountries());
        } catch (Exception e) {
        }

        return new ModelAndView("view", result);
    }

    @RequestMapping(value = "/create.htm")
    public ModelAndView loadcreate(HttpServletRequest request,
            HttpServletResponse response) {
                Map<String, Object> result = new HashMap<String, Object>();
        try {
            result.put("countries", serviceDba.getCountries());
        } catch (Exception e) {
        }
        return new ModelAndView("create", result);
    }
    
     @RequestMapping(value = "/guardar.htm")
    public ModelAndView guardar(HttpServletRequest request,
            HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        Countries objCountries = new Countries();
        Regions region = new Regions();
        objCountries.setCountryId(request.getParameter("id"));
        objCountries.setCountryName(request.getParameter("name"));
        region.setRegionId(new BigDecimal(request.getParameter("country")));
        objCountries.setRegionId(region);
        try {
            serviceDba.insert(objCountries);
            result.put("msg", "Se creo   " + request.getParameter("name"));
            result.put("countries", serviceDba.getCountries());
        } catch (Exception e) {
            if (e instanceof SQLException) {
                result.put("msg", "Ya existe ese identificador para Persona");
            }
        }
        return new ModelAndView("view", result);
    }

}
