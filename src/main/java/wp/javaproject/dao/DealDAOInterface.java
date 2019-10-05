package wp.javaproject.dao;

import java.util.List;

import wp.javaproject.entities.Deals;

public interface DealDAOInterface {

	public void addDeal(Deals deal);
	public void removeDeal(String deal_no);
	public List<Deals> getAllDeals();
	public List<Deals> getDealsByTransporter(String email);
}
