package com.model2.mvc.service.purchase.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductDaoImpl;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml" })
public class PurchaseServiceTest {

		// TODO Auto-generated method stub
		@Autowired
		@Qualifier("purchaseServiceImpl")
		private PurchaseService purchaseService;
		
		//@Test
		public void testAddPurchase() throws Exception {
			
			Purchase purchase = new Purchase();
			User user = new User();
			user.setUserName("�׽�Ʈ�� ����");
			user.setUserId("user01");
			user.setPassword("8080");
			Product product = new Product();
			product.setProdName("�׽�Ʈ�� ��ǰ");
			product.setProdNo(10002);
			purchase.setBuyer(user);
			purchase.setPurchaseProd(product);
			purchase.setReceiverName("������");
			purchase.setDivyRequest("Ȯ���մϴ�");
			purchase.setPaymentOption("2");
			purchase.setReceiverPhone("999999");
			purchase.setDivyAddr("�ƴ�");
			purchase.setTranCode("3");
			purchase.setDivyDate("2020-11-17");
			
			purchaseService.addPurchase(purchase);
			
			purchase = purchaseService.getPurchase(10007);
			
			System.out.println("Add , Get Purchase Test : "+purchase);
			
			Assert.assertEquals(10007, purchase.getTranNo());
			Assert.assertEquals("������", purchase.getReceiverName());
			Assert.assertEquals("Ȯ���մϴ�", purchase.getDivyRequest());
			Assert.assertEquals("�׽�Ʈ�� ��ǰ", purchase.getPurchaseProd().getProdName());
			Assert.assertEquals("�׽�Ʈ�� ����", purchase.getBuyer().getUserName());
		}
		
		//@Test
		public void testGetPurchase() throws Exception {
			
			Purchase purchase = new Purchase();
			
			purchase = purchaseService.getPurchase(10007);

			//==> console Ȯ��
			System.out.println(purchase);
			
			//==> API Ȯ��
			Assert.assertEquals(10007, purchase.getTranNo());
			Assert.assertEquals("������", purchase.getReceiverName());

		}
		
		//@Test
		 public void testUpdatePurchase() throws Exception{
			 
			Purchase purchase = new Purchase();
			purchase = purchaseService.getPurchase(10007);
			Assert.assertNotNull(purchase);
			
			Assert.assertEquals(10007, purchase.getTranNo());
			Assert.assertEquals("������", purchase.getReceiverName());
			
			purchase.setReceiverName("����Ȯ�ο�");
			
			purchaseService.updatePurchase(purchase);
			
			purchase = purchaseService.getPurchase(10007);
			Assert.assertNotNull(purchase);
			
			//==> console Ȯ��
			System.out.println(purchase);
				
			//==> API Ȯ��
			Assert.assertEquals(10007, purchase.getTranNo());
			Assert.assertEquals("����Ȯ�ο�", purchase.getReceiverName());
		 }
		 
		 
		 //@Test
		 public void testGetProductList() throws Exception {
			 	Search search = new Search();
			 	User user = new User();
			 	user.setUserId("user01");
			 	search.setCurrentPage(1);
			 	search.setPageSize(3);
			 	Map<String,Object> map = purchaseService.getPurchaseList(search,user.getUserId());
			 	
			 	List<Object> list = (List<Object>)map.get("list");
			 	Assert.assertEquals(3, list.size());
			 	
				//==> console Ȯ��
			 	System.out.println(list);
			 	
			 	Integer totalCount = (Integer)map.get("totalCount");
			 	System.out.println(totalCount);
			 	
			 	System.out.println("=======================================");
			 	
			 	search.setCurrentPage(1);
			 	search.setPageSize(3);
			 	search.setSearchCondition("0");
			 	search.setSearchKeyword("");
			 	map = purchaseService.getPurchaseList(search,user.getUserId());
			 	
			 	list = (List<Object>)map.get("list");
			 	Assert.assertEquals(3, list.size());
			 	
			 	//==> console Ȯ��
			 	//System.out.println(list);
			 	
			 	totalCount = (Integer)map.get("totalCount");
			 	System.out.println(totalCount);
			 }
		 
		 //@Test
		 public void testGetSaleList() throws Exception {
			 Search search = new Search();
			 	User user = new User();
			 	user.setUserId("user01");
			 	search.setCurrentPage(1);
			 	search.setPageSize(3);
			 	Map<String,Object> map = purchaseService.getSaleList(search);
			 	
			 	List<Object> list = (List<Object>)map.get("list");
			 	Assert.assertEquals(3, list.size());
			 	
				//==> console Ȯ��
			 	System.out.println(list);
			 	
			 	Integer totalCount = (Integer)map.get("totalCount");
			 	System.out.println(totalCount);
			 	
			 	System.out.println("=======================================");
			 	
			 	search.setCurrentPage(1);
			 	search.setPageSize(3);
			 	search.setSearchCondition("0");
			 	search.setSearchKeyword("");
			 	map = purchaseService.getPurchaseList(search,user.getUserId());
			 	
			 	list = (List<Object>)map.get("list");
			 	Assert.assertEquals(3, list.size());
			 	
			 	//==> console Ȯ��
			 	//System.out.println(list);
			 	
			 	totalCount = (Integer)map.get("totalCount");
			 	System.out.println(totalCount);
		 }
		 //@Test
		 public void testGetPurchase2() throws Exception{
			 
			    Purchase purchase = new Purchase();
				Product product = new Product();
				purchase = purchaseService.getPurchase2(10001);

				//==> console Ȯ��
				System.out.println(purchase);
				
				//==> API Ȯ��
				Assert.assertNull(purchase.getTranNo());
		 }
		 @Test
		 public void testUpdateTranCode() throws Exception {
			 Purchase purchase = new Purchase();
				purchase = purchaseService.getPurchase(10007);
				Assert.assertNotNull(purchase);
				
				Assert.assertEquals(10007, purchase.getTranNo());
				
				purchase.setReceiverName("����Ȯ�ο�");
				purchase.setTranCode("2");
				purchaseService.updateTranCode(purchase);
				purchase = purchaseService.getPurchase(10007);
				Assert.assertEquals("2", purchase.getTranCode().trim());
		 }
	
		

}
