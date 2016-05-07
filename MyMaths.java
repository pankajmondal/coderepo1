package com.self.algorithm.ds.lists;

public class MyMaths {

	public static void main(String[] args) {
		MyMaths maths = new MyMaths();
		int[][]p = maths.pascalTriangle(10);
		long[] fib = fibonacci(25);
		print(fib);
		long [] fibs = fibonacciSquare(25);
		print(fibs);

		for(int i=0;i<999;i++){
			if(sumOfPowX(i))
				System.out.println(powExpr(i));
		}
		/*
		for(int i=0;i<9999;i++){
			if(mulOfDigs(i))
				System.out.println(mulExpr(i));
		}
		*/
		for(int i=0;i<99999;i++){
			if(sumOfFact(i))
				System.out.println(factExpr(i));
		}
		
		for(int i=1;i<99;i++){
				System.out.println("Triangular number ["+i+"] := "+sumUptoN(i));
		}		
		
	}
	
	static long[] fibonacciSquare(int n){
		long[]fib=fibonacci(n);
		for(int i=2;i<n;i++){
			fib[i]=fib[i]*fib[i];
		}
		return fib;
	}
	
	static long[] fibonacci(int n){
		long[]fib=new long[n];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<n;i++){
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib;
	}
	
	int[][] pascalTriangle(int depth){ //p[i][j] = p[i-1][j]+p[i-1][j+1] -> p[2][3] = p[1][3] + p[1][2]; p[2][0]=p[1][0]+p[1][1]
		int[][] pascal=new int[depth][1];
		pascal[0][0]=1;
		for(int i=1;i<depth;i++){
			pascal[i]=new int[i+1];
			for(int j=0;j<=i;j++){
				if(j==0 || j==i){
					pascal[i][j]=1;
				}else{
					pascal[i][j]=pascal[i-1][j-1] + pascal[i-1][j];
				}
			}
		}
		return pascal;
	}
	
	static void print(int[]ia){
		for(int i=0;i<ia.length;i++)
			System.out.print(ia[i]+(i!=(ia.length-1)?", ":""));
		System.out.println();
	}
	static void print(long[]ia){
		for(int i=0;i<ia.length;i++)
			System.out.print(ia[i]+(i!=(ia.length-1)?"\t":""));
		System.out.println();
	}
	static void print(int[][]iaa){
		for(int i=0;i<iaa.length;i++){
			//System.out.print(gaps(iaa.length-i));
			print(iaa[i]);
		}
	}
	static String gaps(int n){
		String g="";
		for(int i=0;i<n;i++)g += "  ";
		return g;
	}
	
	static int numOfDigits(long num){
		int sumOfDigs=0;
		
		while(num>0){
			num=(num-num%10)/10;
			sumOfDigs++;
		}
		return sumOfDigs;
	}
	static String powExpr(long num){
		String ret=num+" = ";
		int numOfDigs=numOfDigits(num);
		for(int i=0;i<numOfDigs;i++){
			int dig=(int)(num % 10);
			ret+= dig+"^"+numOfDigs+((i!=(numOfDigs-1))?" + ":"");
		}
		
		return ret;
	}
	static String mulExpr(long num){
		String ret1=num+" = ",ret="",numOrig=num+"";
		int numOfDigs=numOfDigits(num);
		for(int i=0;i<numOfDigs;i++){
			int dig=(int)(num % 10);
			num=(num-dig)/10;
			ret+= dig+((i!=(numOfDigs-1))?"*":"");
		}
		byte[]barr=ret.getBytes();
		int len=barr.length;
		for(int i=0;i<len/2;i++){
			byte b = barr[i];
			barr[i]=barr[len-i-1];
			barr[len-i-1]=b;
		}
		ret=new String(barr);
		return ret1+ret;
	}
	/**
	 * Armstrong Numbers
	 * @param num
	 * @return
	 */
	static boolean sumOfPowX(long num){
		int numOfDigs=numOfDigits(num);
		long sumOfDigs=0,numOrig=num;
		while(num>0){
			int dig=(int)(num % 10);
			num=(num-dig)/10;
			sumOfDigs+=Math.pow(dig, numOfDigs);
		}
		return sumOfDigs == numOrig;
	}
	
	static boolean mulOfDigs(long num){
		long mulOfDigs=1,numOrig=num;
		while(num>0){
			int dig=(int)(num % 10);
			num=(num-dig)/10;
			mulOfDigs*=dig;
		}
		//System.out.println("mulOfDigs = sumOfDigs "+mulOfDigs+", numOrig "+numOrig+"; diff "+(numOrig-mulOfDigs));
		return mulOfDigs == numOrig;
	}
	
	static boolean sumOfFact(int num){
		long sumOfFacts=0,numOrig=num;
		while(num>0){
			int dig=(int)(num % 10);
			num=(num-dig)/10;
			sumOfFacts+=fact(dig);
		}
		return sumOfFacts == numOrig;
	}
	static long fact(int n){
		if(n<2)return 1;
		else return n*fact(n-1);
	}
	
	static String factExpr(long num){
		String ret1=num+" = ",ret="",numOrig=num+"";
		int numOfDigs=numOfDigits(num);
		int[]digs=new int[numOfDigs];
		for(int i=0;i<numOfDigs;i++){
			int dig=(int)(num % 10);
			num=(num-dig)/10;
			digs[i]=dig;
		}
		byte[]barr=ret.getBytes();
		int len=barr.length;
		for(int i=digs.length-1;i>=0;i--){
			ret +=digs[i]+"! "+(i!=0?"+":"");
		}
		return ret1+ret;
	}
	static int sumUptoN(int n){
		if(n<2)return 1;
		return n+sumUptoN(n-1);
	}
	static long triangularNumber(int num){
		long tsum=0;
		for(int i=1;i<=num;i++){
			tsum+=sumUptoN(i);
		}
		return tsum;
	}
}
// 0,1,1,2,3,5,8,13,21,34,55,89,144,253
