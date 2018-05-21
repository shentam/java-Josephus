
package com.practice;
/**
 * 

 * <p>Title: Logic</p>

 * <p>Description: the Josephus issue logic class</p>

 * <p>Company: DeltaEdge</p> 

 * @author    Andrew Chao

 * @date       2018��5��18��
 */

public class Logic {

	int amount=0; // ������
	Child firstChild =null; //��һ������
	Child temp=null; //��ʱ����
	int sNo=0;//��ʼλ��
	int rNo=0;//�����
/**
 * 
 
 * <p>Title: setAmount</p>

 * <p>Description:����������</p>

 * @param amount
 */
	public void setAmount(int amount) {

		this.amount =amount;//���ò�������
	}
/**
 * 

 * <p>Title: createCircle</p>

 * <p>Description: ��������</p>
 */
	public void createCircle() {
		//ͨ��ѭ��������ֵchildʵ��ch
		for(int i=1;i<=amount;i++) {
			if(i==1) {
				//��һ��ʵ��������ʼ��
				Child ch=new Child(i);
				this.firstChild =ch;
				this.temp=ch;
			}
			else {
				if(i==amount) {
					//���һ��ʵ��������β�ˣ�,���һ��ʵ����ָ��ָ���һ��ʵ��
					Child ch= new Child(i);
					temp.nextChild=ch;
					temp=ch;
					temp.nextChild=this.firstChild;
				}else {
					//����ʵ��
					Child ch =new Child(i);
					temp.nextChild=ch;
					temp=ch;
				}
			}
		}
	}
/**
 * 

 * <p>Title: setStart</p>

 * <p>Description: ������ʼ��</p>

 * @param number
 */
	public void setStart(int number) {

		this.sNo=number;
	}
/**
 * 

 * <p>Title: setRandom</p>

 * <p>Description: ���������ѡ��</p>

 * @param number
 */
	public void setRandom(int number) {
		
		this.rNo=number;
	}
/**
 * 

 * <p>Title: go</p>

 * <p>Description: ��������</p>
 */
	public void go() {
		//��һ��ָ��ָ���һ��ʵ��
		Child temp=this.firstChild;
		//���������ˣ�ָ��ָ����ʼ��
		for(int i=1;i<sNo;i++) {
			temp=temp.nextChild;
			
		}
		//ѭ����Ҫ��Ȧ��ʵ����ֱ�����һ��
		while(this.amount!=1) {
			
			for(int j=1;j<rNo;j++) {
				//�ҵ�����������ӣ�Ҫ��Ȧ���ˣ�
				temp=temp.nextChild;
			}
			System.out.print("\n���ֳ�Ȧ����"+temp.no);
			//�ҵ������ǰһ������
			Child temp2=temp;
			//�����ҳ���һ������
			while(temp2.nextChild!=temp) {
				temp2=temp2.nextChild;
			}
			temp2.nextChild=temp.nextChild;//��temp2ֱ��ָ���Ȧ�ߵ���һ��
			temp=temp.nextChild;//ָ����һ��
			amount--;//����������һ��
		}
		System.out.print("\nThe last survivor is: "+temp.no);//��ӡ���µ�С��
		
	}

	public void display() {
		// TODO Auto-generated method stub
		Child temp= this.firstChild;
		do {
			System.out.print(temp.no+" ");
			temp=temp.nextChild;
		} while (temp!=this.firstChild);
	}
	

}

