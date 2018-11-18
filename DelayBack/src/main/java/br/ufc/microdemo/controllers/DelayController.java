package br.ufc.microdemo.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.microdemo.model.Delay;
import br.ufc.microdemo.model.Response;

@RestController
public class DelayController {
	
	private static Response waitForTime(Delay delay) {
		int waitFor = delay.getDelay();  
		
		try {
			Thread.sleep(waitFor*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		return new Response("Pong!", waitFor);
	}
	
	@RequestMapping("/")
	public Response mainRequest(@RequestBody Delay delay) {
		try {
			return DelayController.waitForTime(delay);
		}catch(Exception e) {
			return new Response("Error", -1);
		}
	}
}
