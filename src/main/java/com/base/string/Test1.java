package com.base.string;

public class Test1 {

	public static void main(String[] args) {
		
		//���������Ż���ʱ��,����a,b,c�ڱ����ʱ��,ֵ���ǹ̶���
		//����Ҫ�ȵ����е�ʱ����ȥ����,��ôa,b,c�Ϳ���ֱ�Ӹ�ֵΪab1
		//��ô�������ڴ��ʱ��ֱ�Ӹ�ֵΪһ��
		String a = "a" + "b" + 1;
		String b = "ab1";
		String c = "ab" + 1;
		
		String d = new String("ab1");
		System.out.println(a == b); //true
		System.out.println(a == c); //true
		System.out.println(a == d); //false
		
		
		//��ߵ�g���ɱ���e,f��1+������,����ַ������г����˱���,���ڱ����ʱ��,����ȷ�������ֵ�Ƕ���
		//��ôJVM�ǲ���ȥ�������ı���ʱ�ڵĺϲ�
		//Ҳ�����ǻ��ɻ�,e��f���Ǳ������˹̶���ֵ��ô,���ǲ�Ҫ����,�������ܱ仯,�����ʱ��֪��
		String e = "a";
		String f = "b";
		String g = e + f + 1;
		System.out.println(g == a); //false
	}
}
