package com.nineSoftech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nineSoftech.Entity.Payments;
import com.nineSoftech.Exception.ProductNotFound;
import com.nineSoftech.Service.PaymentsService;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;
    
    

    @GetMapping("/all")
    public ResponseEntity<List<Payments>> getAllPayments() {
        List<Payments> payments = paymentsService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable Long id) {
        Payments payment = paymentsService.getPaymentById(id);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Payments> createPayment(@RequestBody Payments payments) {
    	try {
    		 Payments createdPayment = paymentsService.createPayment(payments);
    		 if(createdPayment == null) {
    			throw new ProductNotFound();
    		 }
    		 return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    	}catch(Exception e) {
    		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	               
    	}
      
       
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payments> updatePayment(@PathVariable Long id, @RequestBody Payments payments) {
       
        try {
        	  Payments updatedPayment = paymentsService.updatePayment(id, payments);
        	  if (updatedPayment != null) {
        		  throw new ProductNotFound();
              }
        	   return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
        }catch (Exception e) { 
      
       
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentsService.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Payments>> getAllPaymentsByEventId(@PathVariable Long eventId) {
        List<Payments> payments = paymentsService.getAllPaymentsByEventId(eventId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}

