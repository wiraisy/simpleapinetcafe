package com.task.netcafe.boom.main.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.task.netcafe.boom.model.*;

@Service
public class MainService {

    private static List<Transaction> mainlist = new ArrayList<>();
    private List<Transaction> translist = new ArrayList<>();
    private static TotalPay totalpay;

    
	public static TotalPay getTotalpay() {
		return totalpay;
	}

	public static void setTotalpay(TotalPay totalpay) {
		MainService.totalpay = totalpay;
	}

	static{
        MainItem item = new MainItem();
        item.setId(1l);
        item.setType("primary");
        item.setName("browsing");
        item.setPrice(4.0);
        item.setUom("Hour");
        Transaction t = new Transaction();
        t.setId(1l);
        t.setItem(item);
        mainlist.add(t);
        //=================================
        MainItem item1 = new MainItem();
        item1.setId(2l);
        item1.setType("primary");
        item1.setName("typing");
        item1.setPrice(2.0);
        item1.setUom("Hour");
        Transaction t1 = new Transaction();
        t1.setId(2l);
        t1.setItem(item1);
        mainlist.add(t1);
        //================================
        MainItem item2 = new MainItem();
        item2.setId(3l);
        item2.setType("primary");
        item2.setName("gamming");
        item2.setPrice(6.0);
        item2.setUom("Hour");
        Transaction t2 = new Transaction();
        t2.setId(3l);
        t2.setItem(item2);
        mainlist.add(t2);
        //==============================
         MainItem item3 = new MainItem();
         item3.setId(4l);
         item3.setType("additional");
         item3.setName("scan");
         item3.setPrice(1.0);
         item3.setUom("Unit");
         Transaction t3 = new Transaction();
         t3.setId(4l);
         t3.setItem(item3);
         mainlist.add(t3);
        //==============================
         MainItem item4 = new MainItem();
         item4.setId(5l);
         item4.setType("additional");
         item4.setName("print b/w");
         item4.setPrice(0.5);
         item4.setUom("Unit");
         Transaction t4 = new Transaction();
         t4.setId(5l);
         t4.setItem(item4);
         mainlist.add(t4);
        //==============================
        MainItem item5 = new MainItem();
        item5.setId(6l);
        item5.setType("additional");
        item5.setName("print color");
        item5.setPrice(0.8);
        item5.setUom("Unit");
        Transaction t5 = new Transaction();
        t5.setId(6l);
        t5.setItem(item5);
        mainlist.add(t5);
         //==============================
         MainItem item6 = new MainItem();
         item6.setId(7l);
         item6.setType("additional");
         item6.setName("drink");
         item6.setPrice(1.5);
         item6.setUom("Unit");
         Transaction t6 = new Transaction();
         t6.setId(7l);
         t6.setItem(item6);
         mainlist.add(t6);
    }

    public List<Transaction> getallitem(){
        return mainlist;
    }

    public void addbucket(Long id, Double Qty){
    	      for(Transaction t:mainlist) {
    	    	  if(t.getId().equals(id)) {
    	    		  t.setQuantity(Qty);
    	    		  t.setSubtotal(t.getItem().getPrice()*Qty);
    	    		  translist.add(t);
    	    	  }
    	      }
            }
         
    

    public TotalPay showTotalpay(){
        Double total = 0d;
        TotalPay pay = new TotalPay();
        if(!translist.isEmpty()) {
        	for(Transaction transt: translist){
                total += transt.getSubtotal();
            }          
            pay.setBucket(translist);
            pay.setId(1l);
            pay.setTotal_price(total);
            setTotalpay(pay);
        }
        
        return pay;
    }
    
    public TotalPay dopayment(Double Payment){
        TotalPay pa = getTotalpay();
        pa.setPayment(Payment);
        pa.setChange(pa.getPayment() - pa.getTotal_price());
        return pa;
    }
    
    public void reset() {
    	translist.clear();
    	translist = new ArrayList<>();
    	setTotalpay(new TotalPay());
    }
    
    public List<Transaction> getallbucket(){
    	return translist;
    }
    
    public void removeitem(Transaction t) {
    	translist.remove(t);
    }
    
}
