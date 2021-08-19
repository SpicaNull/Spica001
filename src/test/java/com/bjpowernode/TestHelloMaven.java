package com.bjpowernode;
import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven{
	@Test
	public void testAdd(){
		HelloMaven hello = new HelloMaven();
		int a = 10;
		int b = 20;
		int result = hello.add(a,b);
		//assertEquals(期望值，实际值)，如果两个相同，证明程序是正确的，错误则抛异常。
		Assert.assertEquals(30,result);
	}

	@Test
	public void testAdd2(){
		HelloMaven hello = new HelloMaven();
		int a = 11;
		int b = 20;
		int result = hello.add(a,b);
		//assertEquals(期望值，实际值)，如果两个相同，证明程序是正确的，错误则抛异常。
		Assert.assertEquals(31,result);

	}
	
}