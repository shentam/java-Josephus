
package com.practice;
/**
 * 

 * <p>Title: Logic</p>

 * <p>Description: the Josephus issue logic class</p>

 * <p>Company: DeltaEdge</p> 

 * @author    Andrew Chao

 * @date       2018年5月18日
 */

public class Logic {

	int amount=0; // 总人数
	Child firstChild =null; //第一个孩子
	Child temp=null; //临时变量
	int sNo=0;//起始位置
	int rNo=0;//随机数
/**
 * 
 
 * <p>Title: setAmount</p>

 * <p>Description:设置总人数</p>

 * @param amount
 */
	public void setAmount(int amount) {

		this.amount =amount;//设置参与人数
	}
/**
 * 

 * <p>Title: createCircle</p>

 * <p>Description: 创建环表</p>
 */
	public void createCircle() {
		//通过循环遍历赋值child实例ch
		for(int i=1;i<=amount;i++) {
			if(i==1) {
				//第一个实例（环表开始）
				Child ch=new Child(i);
				this.firstChild =ch;
				this.temp=ch;
			}
			else {
				if(i==amount) {
					//最后一个实例（环表尾端）,最后一个实例的指针指向第一个实例
					Child ch= new Child(i);
					temp.nextChild=ch;
					temp=ch;
					temp.nextChild=this.firstChild;
				}else {
					//正常实例
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

 * <p>Description: 设置起始点</p>

 * @param number
 */
	public void setStart(int number) {

		this.sNo=number;
	}
/**
 * 

 * <p>Title: setRandom</p>

 * <p>Description: 设置随机挑选数</p>

 * @param number
 */
	public void setRandom(int number) {
		
		this.rNo=number;
	}
/**
 * 

 * <p>Title: go</p>

 * <p>Description: 环表运行</p>
 */
	public void go() {
		//第一个指针指向第一个实例
		Child temp=this.firstChild;
		//遍历所有人，指针指向起始点
		for(int i=1;i<sNo;i++) {
			temp=temp.nextChild;
			
		}
		//循环出要出圈的实例，直到最后一个
		while(this.amount!=1) {
			
			for(int j=1;j<rNo;j++) {
				//找到随机数个孩子（要出圈的人）
				temp=temp.nextChild;
			}
			System.out.print("\n此轮出圈的是"+temp.no);
			//找到随机数前一个孩子
			Child temp2=temp;
			//遍历找出上一个孩子
			while(temp2.nextChild!=temp) {
				temp2=temp2.nextChild;
			}
			temp2.nextChild=temp.nextChild;//将temp2直接指向出圈者的下一个
			temp=temp.nextChild;//指向下一轮
			amount--;//总人数减少一个
		}
		System.out.print("\nThe last survivor is: "+temp.no);//打印留下的小孩
		
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

