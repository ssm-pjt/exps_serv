package exps.api.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * Sample API 코드
 */
@Slf4j
@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class SampleWebController {
    
	@GetMapping("/index")
    public String indexTest() {
    	log.debug("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    	return "index";
    }
}