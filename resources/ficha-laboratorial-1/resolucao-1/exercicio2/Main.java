package exercicio2;

public class Main {
	private static long stopTime;
	private static long startTime;
	static void ex1j(long n){
		long soma=0;
		startTimer();
		for(long i=1;i<n;i*=2)
			soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}
	static void ex1i(long n){
		long soma=0;
		startTimer();
		for(long i=0;i<n*n;i++)
			for (long j=0;j<i;j++)
				soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}
	static void ex1h(long n){
		long soma=0;
		startTimer();
		for(long i=0;i<n;i++)
			for (long j=0;j<i;j++)
				soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}
	static void ex1g(long n){
		long soma=0;
		startTimer();
		for(long i=0;i<n;i++)
			for (long j=0;j<n*n;j++)
				soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}
	static void ex1f(long n){
		long soma=0;
		startTimer();
		if(n>20000)
			n=20000;
		for(long i=0;i<n;i++)
			for (long j=0;j<n;j++)
				soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}
	static void ex1e(long n){
		long soma=0;
		startTimer();
		for(long i=0;i<n;i++)
			soma++;
		for (long j=0;j<n;j++)
			soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}
	static void ex1d(long n){
		long soma=0;
		startTimer();
		for(long i=0;i<1000;i++)
			for (long j=0;j<n;j++)
				soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}
	static void ex1c(long n){
		long soma=0;
		startTimer();
		for(long i=0;i<n;i+=2)
			soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}
	static void ex1b(long n){
		long soma=0;
		startTimer();
		for(long i=0;i<n;i++)
			soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}
	static void ex1a(long n){
		long soma=0;
		startTimer();
		for(long i=0;i<n;i++)
			for(long j=0;j<n;j++)
					soma++;
		System.out.print("Soma="+soma);
		stopTimer();
		showTime();
	}	
	private static void showTime() {
		long interval=stopTime-startTime;
		long secs=interval/1000000000L;
		long decs=interval-secs*1000000000L;
		decs/=100000000L;
		System.out.println("\tsecs="+secs+"."+decs);
	}
	private static void stopTimer() {
		stopTime=System.nanoTime();
	}
	private static void startTimer() {
		startTime=System.nanoTime();
	}
	public static void main(String[] args) {
		long n = 40000;
		System.out.println("\n### A ###");
		System.out.print("N:\t");    ex1a(n);
		System.out.print("4N:\t");   ex1a(4*n);

		n = 2000000000L;
		System.out.println("\n### B ###");
		System.out.print("N:\t");	ex1b(n);
		System.out.print("4N:\t");	ex1b(4*n);

		n = 4000000000L;
		System.out.println("\n### C ###");
		System.out.print("N:\t");	ex1c(n);
		System.out.print("4N:\t");	ex1c(4*n);

		n = 1000000;
		System.out.println("\n### D ###");
		System.out.print("N:\t");	ex1d(n);
		System.out.print("4N:\t");	ex1d(4*n);

		n = 300000000;
		System.out.println("\n### E ###");
		System.out.print("N:\t");	ex1e(n);
		System.out.print("4N:\t");	ex1e(4*n);

		n = 3000000;
		System.out.println("\n### F ###");
		System.out.print("N:\t");	ex1f(n);
		System.out.print("4N:\t");	ex1f(4*n);

		n = 1000;
		System.out.println("\n### G ###");
		System.out.print("N:\t");	ex1g(n);
		System.out.print("4N:\t");	ex1g(4*n);

		n = 40000;
		System.out.println("\n### H ###");
		System.out.print("N:\t");	ex1h(n);
		System.out.print("4N:\t");	ex1h(4*n);

		n = 200;
		System.out.println("\n### I ###");
		System.out.print("N:\t");	ex1i(n);
		System.out.print("4N:\t");	ex1i(4*n);

		n = 200000000000000000L;
		System.out.println("\n### J ###");
		System.out.print("N:\t");	ex1j(n);
		System.out.print("4N:\t");	ex1j(4*n);
	}
}
