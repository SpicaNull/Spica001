package com.bjpowernode;

public class HelloMaven{
	public int add(int a,int b){
		return a+b;
	}
	public static void main(String[] args){
		HelloMaven hello = new HelloMaven();
		int a = 10;
		int b = 20;
		int result = hello.add(a,b);
		System.out.println(a+" + "+b+" = "+result);
	}
}