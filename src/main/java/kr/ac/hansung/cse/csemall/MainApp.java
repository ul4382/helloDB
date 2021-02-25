package kr.ac.hansung.cse.csemall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("kr/ac/hansung/cse/conf/beans.xml");
		
		OfferDao offerDao = (OfferDao) context.getBean("offerDao");
		System.out.println("The record count is " + offerDao.getRowCount());		
		
		//Test cRud method
		List<Offer> offerList = offerDao.getOffers();
		
		for(Offer offer:offerList)
		System.out.println(offer);
		
		Offer offer= new Offer();
		offer.setName("trudy");
		offer.setEmail("trudy@hansung.ac.kr");
		offer.setText("an instructor of spring framework");
		
		if(offerDao.insert(offer))
			System.out.println("object is inserted successfully");
		else
			System.out.println("object insert failed");
		
		offer=offerDao.getOffer("trudy");
		offer.setName("yulim");
		if(offerDao.update(offer)) {
			System.out.println("object is updated successfully");
		}
		else
			System.out.println("object update failed");
		
		offer=offerDao.getOffer("yulim");
		System.out.println(offer);
		if(offerDao.delete(offer.getId())) {
			System.out.println("object is deleted successfully");
		}
		else
			System.out.println("object delete failed");
		
		context.close();
		
	}

}
