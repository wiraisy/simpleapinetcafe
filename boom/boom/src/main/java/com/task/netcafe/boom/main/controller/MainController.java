package com.task.netcafe.boom.main.controller;

import java.util.List;
import com.task.netcafe.boom.main.config.ResourceException;
import com.task.netcafe.boom.main.service.MainService;
import com.task.netcafe.boom.model.TotalPay;
import com.task.netcafe.boom.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NetCaffe")
public class MainController {

	@Autowired
    private MainService service;

    @GetMapping(value = "/getallitem")
    public ResponseEntity<List<Transaction>> getallitem(){
        return new ResponseEntity<>(service.getallitem(), HttpStatus.OK);
    }

    @PostMapping(value = "/addbucket/{id}/{quantity}")
    public ResponseEntity<Void> addbucket(@RequestParam("id") Long id,@RequestParam("quantity") Double quantity){
    	if(quantity< 0.5) {
    		throw new ResourceException(HttpStatus.UNPROCESSABLE_ENTITY, "Minimum Usage Quantity is 0.5 Hour");
    	}else {
    		 service.addbucket(id, quantity);
    	}
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/showtotalpay")
    public ResponseEntity<TotalPay> showtotalpay(){
        return new ResponseEntity<>(service.showTotalpay(), HttpStatus.OK);
    }

    @PostMapping(value = "/dopayment/{payment}")
    public ResponseEntity<TotalPay> dopayment(@RequestParam("payment") Double payment){
    	TotalPay io = service.dopayment(payment);
    	service.reset();
        return new ResponseEntity<>(io, HttpStatus.OK);
    }


}
