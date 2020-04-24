package com.uca.capas.formulario.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.formulario.model.Alumno;

@Controller
public class MainController {

	@RequestMapping("/agregar")
	public String index(Alumno alumno) {

		return "agregar";
	}

	@RequestMapping("/validacion")
	public ModelAndView validar(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String birth = request.getParameter("birth");
		// Split
		String[] birthpart = birth.split("-");

		String birthp = request.getParameter("birthPlace");
		String school = request.getParameter("schoolName");
		String phone = request.getParameter("phone");
		String cellphone = request.getParameter("cellPhone");

		int year = Integer.parseInt(birthpart[0]);

		if (name.length() < 1 || lastname.length() < 1 || birthpart[2].equals("2003") || birthp.length() < 1
				|| school.length() < 1 || name.length() > 25 || lastname.length() > 25 || birthp.length() > 25
				|| school.length() > 100 || phone.length() != 8 || cellphone.length() != 8) {
			mav.addObject("titulo", "Errores: ");

			if (name.length() < 1 || name.length() > 25) {
				mav.addObject("nameerr",
						"Su nombre debe contener entre 1 y 25 caracteres, el suyo contiene: " + name.length());
			}
			if (lastname.length() < 1 || lastname.length() > 25) {
				mav.addObject("lastnameerr",
						"Su apellido debe contener entre 1 y 25 caracteres, el suyo contiene: " + lastname.length());
			}
			if (year < 2003) {
				mav.addObject("birth", "Su año de nacimiento debe ser mayor al 2003, el suyo contiene: " + year);
			}
			if (birthp.length() < 1 || birthp.length() > 25) {
				mav.addObject("birthPerr",
						"El nombre de su lugar de nacimiento debe contener entre 1 y 25 caracteres, el suyo contiene: "
								+ birthp.length());
			}
			if (school.length() < 1 || school.length() > 25) {
				mav.addObject("schoolerr",
						"El nombre de su colegio debe contener entre 1 y 25 caracteres, el suyo contiene: "
								+ school.length());
			}
			if (phone.length() != 8) {
				mav.addObject("phoneerr",
						"Su numero fijo debe ser de 8 caracteres, el suyo contiene: " + phone.length());
			}
			if (cellphone.length() != 8) {
				mav.addObject("cellphoneerr",
						"Su numero fijo debe ser de 8 caracteres, el suyo contiene: " + cellphone.length());
			}
		} else {
			mav.addObject("titulo", "Alumno ingresado con exito");
		}

		mav.setViewName("validacion");
		return mav;

	}
}
