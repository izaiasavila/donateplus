package com.donateplus.donateplusapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donateplus.donateplusapi.client.PaymentClient;
import com.donateplus.donateplusapi.controller.dto.DonationDTO;

/**
 * This class responsible to provide services about donation
 * @author j.a.vasconcelos
 *
 */
@Service
public class DonateService {

	private static final Logger LOG = LoggerFactory.getLogger(DonateService.class);
	
	@Autowired
	private PaymentClient paymentClient;

	/**
	 * Responsible to call maicroservice payment
	 * 
	 * @param donationDTO
	 * @return return uuid payment.
	 */
	public Long makeDonation(DonationDTO donationDTO) {

		LOG.info("Make donate of user {}", donationDTO.getIdUser());
		
		Long uuid = paymentClient.create(donationDTO);
		
		LOG.info("Payment okay!");
		return uuid;
	}

}
