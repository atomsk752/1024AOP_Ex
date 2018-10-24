package org.atomsk.controller;

import org.atomsk.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class SampleServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private SampleService service;
	
	@Test
	public void testMulti() {
		//String str = "10아름다운 이 강산을 지키는 우리 사나이 기백으로 오늘을 산다 폭탄의 불바다를 무릎 쓰면서 고향땅 부모형제 평화를 위해 왜이렇게사는게힘들기만한지누가인생이아름답다고만했는지";
		
		String str = "10생이아름답다고만했는지";
		
		service.addMulti(str);
	}
	
	@Test
	public void testAdd()throws Exception {
		
		log.info(service.getClass().getName());
		
		log.info("RESULT: "+service.doAdd("123", "456"));
		
	}
}

