package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class C2841 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		Stack<Integer>stack1=new Stack<>();
		Stack<Integer>stack2=new Stack<>();
		Stack<Integer>stack3=new Stack<>();
		Stack<Integer>stack4=new Stack<>();
		Stack<Integer>stack5=new Stack<>();
		Stack<Integer>stack6=new Stack<>();
		int ret=0;
		for(int i=0;i<n; i++) {
			st=new StringTokenizer(br.readLine());
			int line=Integer.parseInt(st.nextToken());
			int plat=Integer.parseInt(st.nextToken());
			if(line==1) {
				if(stack1.isEmpty()) {
					stack1.add(plat);
					ret++;
				}else {
					if(stack1.peek()<plat) {
						stack1.add(plat);
						ret++;
					}else if(stack1.peek()==plat) {
						
					}else {
						while(!stack1.isEmpty()&&stack1.peek()>plat) {
							stack1.pop();
							ret++;
						}
						if(stack1.isEmpty()) {
							stack1.add(plat);
							ret++;
						}else {
							if(stack1.peek()==plat) {
								
							}else {
								ret++;
								stack1.add(plat);
							}
						}
						
					}
				}
			}
			if(line==2) {
				if(stack2.isEmpty()) {
					stack2.add(plat);
					ret++;
				}else {
					if(stack2.peek()<plat) {
						stack2.add(plat);
						ret++;
					}else if(stack2.peek()==plat) {
						
					}else {
						while(!stack2.isEmpty()&&stack2.peek()>plat) {
							stack2.pop();
							ret++;
						}
						if(stack2.isEmpty()) {
							stack2.add(plat);
							ret++;
						}else {
							if(stack2.peek()==plat) {
								
							}else {
								ret++;
								stack2.add(plat);
							}
						}
						
					}
				}
			}
			if(line==3) {
				if(stack3.isEmpty()) {
					stack3.add(plat);
					ret++;
				}else {
					if(stack3.peek()<plat) {
						stack3.add(plat);
						ret++;
					}else if(stack3.peek()==plat) {
						
					}else {
						while(!stack3.isEmpty()&&stack3.peek()>plat) {
							stack3.pop();
							ret++;
						}
						if(stack3.isEmpty()) {
							stack3.add(plat);
							ret++;
						}else {
							if(stack3.peek()==plat) {
								
							}else {
								ret++;
								stack3.add(plat);
							}
						}
						
					}
				}
			}
			if(line==4) {
				if(stack4.isEmpty()) {
					stack4.add(plat);
					ret++;
				}else {
					if(stack4.peek()<plat) {
						stack4.add(plat);
						ret++;
					}else if(stack4.peek()==plat) {
						
					}else {
						while(!stack4.isEmpty()&&stack4.peek()>plat) {
							stack4.pop();
							ret++;
						}
						if(stack4.isEmpty()) {
							stack4.add(plat);
							ret++;
						}else {
							if(stack4.peek()==plat) {
								
							}else {
								ret++;
								stack4.add(plat);
							}
						}
						
					}
				}
			}
			if(line==5) {
				if(stack5.isEmpty()) {
					stack5.add(plat);
					ret++;
				}else {
					if(stack5.peek()<plat) {
						stack5.add(plat);
						ret++;
					}else if(stack5.peek()==plat) {
						
					}else {
						while(!stack5.isEmpty()&&stack5.peek()>plat) {
							stack5.pop();
							ret++;
						}
						if(stack5.isEmpty()) {
							stack5.add(plat);
							ret++;
						}else {
							if(stack5.peek()==plat) {
								
							}else {
								ret++;
								stack5.add(plat);
							}
						}
						
					}
				}
			}
			if(line==6) {
				if(stack6.isEmpty()) {
					stack6.add(plat);
					ret++;
				}else {
					if(stack6.peek()<plat) {
						stack6.add(plat);
						ret++;
					}else if(stack6.peek()==plat) {
						
					}else {
						while(!stack6.isEmpty()&&stack6.peek()>plat) {
							stack6.pop();
							ret++;
						}
						if(stack6.isEmpty()) {
							stack6.add(plat);
							ret++;
						}else {
							if(stack6.peek()==plat) {
								
							}else {
								ret++;
								stack6.add(plat);
							}
						}
						
					}
				}
			}
		}
		System.out.println(ret);
	}

}
