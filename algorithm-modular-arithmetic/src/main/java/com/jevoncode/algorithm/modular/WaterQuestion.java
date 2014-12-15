package com.jevoncode.algorithm.modular;

public class WaterQuestion {
	public static int calculate(int a, int b, int target) {
		System.out.println("开始计算使用"+a+"升的容器和"+b+"升的容器获取"+target+"升水,需要多少步...");
		int max = a;
		int min = b;
		int maxNow = 0;
		int minNow = 0;
		int water = 0;
		int count = 0;
		int formulaCount = 0;
		if (a == b ) {
			System.out.println("容器容量相等,不能获取你想要的水");
			return -1;
		}
		if (a < b) {
			max = b;
			min = a;
		}
		while (water != target) {
			
			if (count != 0){
				System.out.println("第"+(++count) + "步,将 "+max+" 升的容器里的水(现"+maxNow+"升水)倒至"+min+" 升的容器(现"+minNow+"升水).");
				minNow = maxNow;
				maxNow =0;
			}
			System.out.println("第"+(++count) + "步 ：装满 "+max+" 升的容器.");
			maxNow = max;
			System.out.println("公式"+(++formulaCount)+":(" + max + "+" + water + ")%" + min+"="+((max + water) % min)+",以及对应的步骤如下:");
			for (int i = 0; i < (max + water) / min; i++) {
				System.out.println("第"+(++count) + "步 ：将 "+max+" 升的容器里的水(现"+maxNow+"升水)倒至"+min+" 升的容器(现"+minNow+"升水).");
				maxNow = maxNow -(min-minNow);
				if(maxNow==target)
					break;
				System.out.println("第"+(++count) + "步 ：将"+min+" 升的容器里的水倒掉.");
				minNow = 0;
			}
			water = (max + water) % min;
			System.out.println("已获取水 " + water+" 升");

		}
		System.out.println("一共需要" + count+"步");
		return count;
	}
	
	public static void main(String[] args) {
		calculate(7, 11, 2);
	}
}
