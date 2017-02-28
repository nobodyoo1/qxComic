package com.comic.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comic.service.TempService;

@Controller
public class TempController {

	@Autowired
	@Qualifier("tempService")
	private TempService tempService;
	
	@RequestMapping("/import")
	@ResponseBody
	public String dataImport() throws IOException{
		tempService.run();
		return "running...";
	}
	@RequestMapping("/import2")
	@ResponseBody
	public String dataImport2() throws Exception{
		tempService.run2();
		return "KuKu comic...imported";
	}
	@RequestMapping("/import3")
	@ResponseBody
	public String dataImport3() throws Exception{
		tempService.run3();
		return "4399 imported";
	}
}
