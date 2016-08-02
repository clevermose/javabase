package com.base.string;

public class Test1 {

	public static void main(String[] args) {
		
		//编译器在优化的时候,发现a,b,c在编译的时候,值就是固定的
		//不需要等到运行的时候再去计算,那么a,b,c就可以直接赋值为ab1
		//那么在申请内存的时候直接赋值为一个
		String a = "a" + "b" + 1;
		String b = "ab1";
		String c = "ab" + 1;
		
		String d = new String("ab1");
		System.out.println(a == b); //true
		System.out.println(a == c); //true
		System.out.println(a == d); //false
		
		
		//这边的g是由变量e,f和1+起来的,这个字符叠加中出现了变量,即在编译的时候,还不确定具体的值是多少
		//那么JVM是不会去做这样的编译时期的合并
		//也许我们会疑惑,e和f不是被赋予了固定的值了么,但是不要忘了,变量可能变化,编译的时候不知道
		String e = "a";
		String f = "b";
		String g = e + f + 1;
		System.out.println(g == a); //false
	}
}
