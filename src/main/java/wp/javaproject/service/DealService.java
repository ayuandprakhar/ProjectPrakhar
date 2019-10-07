package wp.javaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.javaproject.dao.DealDAOInterface;
import wp.javaproject.entities.Deals;

@Service
public class DealService implements DealServiceInterface {

	@Autowired
	DealDAOInterface dealDAO;
	
	public void addDeal(Deals deal) {
		dealDAO.addDeal(deal);

	}

	public void removeDeal(String deal_no) {
		dealDAO.removeDeal(deal_no);

	}

	public List<Deals> getAllDeals() {
		
		return dealDAO.getAllDeals();
	}

	public List<Deals> getDealsByTransporter(String email) {
		
		return dealDAO.getDealsByTransporter(email);
	}

	public Deals getDealById(String deal_no) {
		return dealDAO.getDealById(deal_no);
	}

}
