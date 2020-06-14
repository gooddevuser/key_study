package com.key.mykey;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test; 

public class study_20200610 {
	/*
	 * TODO : 1. 테스트 메소드 생성 2. 테스트 메소드 통과 3. 리팩토링
	 */

	public class Validator {

		private static final int ID_MIN_SIZE = 4;
		private static final int ID_MAX_SIZE = 8;

		public boolean idValidate(String id) {

			int idSize = id.length();
			if (idSize > ID_MAX_SIZE) {
				throw new IdSizeOverEX();
			} else if (idSize < ID_MIN_SIZE){
				throw new IdSizeLessEX();
			}
			
			return true;
			
		}

	}
	Validator v;
	
	@Before
	public void setU() {
		v = new Validator();
		System.out.println("초기화");
	};

	@After
	public void tearDown() {
		System.out.println("종료");
	}
	
	@Test
	public void testValidSuccess() throws Exception {
		assertTrue(v.idValidate("asdf"));
		System.out.println("성공");
	}

	public class IdSizeOverEX extends RuntimeException{
		
	}
	public class IdSizeLessEX extends RuntimeException{
		
	}
	
	@Test(expected=IdSizeOverEX.class)
	public void testValidFail_idLimitOver() throws Exception {
		v.idValidate("asdfgwert");
		System.out.println("길어");
	}

	@Test(expected=IdSizeLessEX.class)
	public void testValidFail_idLimitLess() throws Exception {
		v.idValidate("as");
		System.out.println("짧아");
	}

}
