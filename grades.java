public class grades{
	public static void main(String[] args){
	
		System.out.println("\n" + "Hey there, how are you doing?");
		System.out.println("\n" + "Do you want to tell me your grades? (Up to 5)");
		String start = IO.readString();
		if(start.length() < 1 || start.charAt(0) != 'y' && start.charAt(0) != 'Y'){
			System.out.println("\n" + "Okay then. Talk to you another time.");
			return;
		}
		
		double[] grades = new double[]{0,0,0,0,0};
		double[] credits = new double[]{0,0,0,0,0};
		
		int counter = 1;
		while(counter < 6){
			System.out.print("\n" + "Tell me grade " + counter + ":  ");
			while(true){
				
				start = IO.readString();
			
				if(start.equals("A")){
					grades[counter-1] = 4.0;
					break;
				}
				if(start.equals("B+")){
					grades[counter-1] = 3.5;
					break;
				}
				if(start.equals("B")){
					grades[counter-1] = 3.0;
					break;
				}
				if(start.equals("C+")){
					grades[counter-1] = 2.5;
					break;
				}if(start.equals("C")){
					grades[counter-1] = 2.0;
					break;
				}
				if(start.equals("D")){
					grades[counter-1] = 1.0;
					break;
				}
				if(start.equals("F")){
					grades[counter-1] = 0.0;
					break;
				}
				System.out.print("\n" + "Sorry that is not valid input. Please make sure you use capital letters.");
			}
			System.out.print("\n" + "And how many credits was that grade worth?  ");
			credits[counter-1] = IO.readInt();
			
			System.out.println("\n" + "\n" + "Do you have any more grades to tell me about?");
			start = IO.readString();
			if(start.length() < 1 || start.charAt(0) != 'y' || start.charAt(0) != 'Y')
				break;
			counter++;
			System.out.println("\n" + "Here is the value of counter: " + counter);
		}
		
		double gpa = 0.0;
		double credit_sum = 0.0;
		double grade_sum = 0.0;
		
		for(counter=0; counter<5; counter++){
			credit_sum += credits[counter];
			grade_sum += (grades[counter] * credits[counter]);
		}
		gpa = grade_sum / credit_sum;
		System.out.println("\n" + "Thank you for that information. Now here is your GPA:  " + gpa);
		return;
	}
}