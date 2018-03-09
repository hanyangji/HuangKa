package sunwou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sunwou.dao.testDao;
import sunwou.entity.Hello;
@RestController
public class testController {
	
	@Autowired
	private testDao test_dao;

	@RequestMapping("testshow")
	public String show() {
		List<Hello> list=test_dao.find();
		System.out.println(list);
		return list.toString();
	}
}
