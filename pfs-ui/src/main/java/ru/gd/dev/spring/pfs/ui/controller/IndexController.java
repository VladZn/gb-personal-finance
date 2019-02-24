package ru.gd.dev.spring.pfs.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @autor Eremin Artem on 17.02.2019.
 */

@Controller
public class IndexController {

	@RequestMapping("/test")
	public String index() {
		System.out.println("Indeeeex");
		return "index";
	}
}
