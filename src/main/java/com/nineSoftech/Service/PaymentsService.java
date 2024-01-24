package com.nineSoftech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nineSoftech.Entity.Payments;
import com.nineSoftech.Exception.PostNotFoundException;
import com.nineSoftech.Repository.EventsRepository;
import com.nineSoftech.Repository.PaymentsRepository;
import com.nineSoftech.Repository.UserRepository;



@Service
public class PaymentsService {
	

    @Autowired
    private PaymentsRepository paymentsRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EventsRepository eventsRepository;

    
    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }

    
    public Payments getPaymentById(Long id) {
        Optional<Payments> optionalPayment = paymentsRepository.findById(id);
        return optionalPayment.orElseThrow(() -> new PostNotFoundException("Payment not found with the given ID."));
    }

    
    public Payments createPayment(Payments payments) {
    	
    	if(payments.getUserId()!=null && payments.getEventId()!=null) { 
    		
    		if(this.userRepository.findById(payments.getUserId()).isPresent()&& this.eventsRepository.findById(payments.getEventId()).isPresent()) {
    			
    			   return paymentsRepository.save(payments);
    		}
    	}	
    	return null;
     
    }

    
    public Payments updatePayment(Long id, Payments updatedPayment) {
        Optional<Payments> optionalPayment = paymentsRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payments existingPayment = optionalPayment.get();
            
            existingPayment.setEventId(updatedPayment.getEventId());
            existingPayment.setUserId(updatedPayment.getUserId());
            existingPayment.setAmount(updatedPayment.getAmount());
            existingPayment.setDescription(updatedPayment.getDescription());
            existingPayment.setStatus(updatedPayment.getStatus());
            return paymentsRepository.save(existingPayment);
        }
        return null; 
    }

    
    public void deletePayment(Long id) {
        paymentsRepository.deleteById(id);
    }
    
    public List<Payments> getAllPaymentsByEventId(Long eventId) {
        return paymentsRepository.findAllByEventId(eventId);
    }
}


