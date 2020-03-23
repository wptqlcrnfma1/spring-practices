package com.douzone.aoptest.service;

import org.springframework.stereotype.Service;

import com.douzone.aoptest.vo.ProductVo;

@Service
//웹에서는 리스너가 컨텍스트에 줬는데 메인에서 실행되는데 어떻게 서비스를 할꺼냐? > 메인에 컨테이너를 만든다.
public class ProductService {
	
	public ProductVo find(String name) {
		System.out.println("[ProductService] finding ...");
		
		/*//afterThrwing 확인 코드
		if(1-1 == 0) {
			throw new RuntimeException("Finding Exception");
		}
		*/
		
		return new ProductVo(name);
	}
}
