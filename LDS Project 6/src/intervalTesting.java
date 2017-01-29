//Maxwell Lezon
//maxwell.lezon@rockets.utoledo.edu
//EECS 2500

//Note: the only error with this code is the "numJobs" not being an int array. I've tried to solve this by taking the input differently but it did not work. 

import java.util.*;
import java.io.*;

public class intervalTesting {
	public static int[] optAnswers;
	public static String[] startTime, finishTime, weight;
	public static int[] sTime, fTime,
						value, possibleJobs, 
						M,     bestIntervals;
	public static int numJobs, optimumValue;							
	public static void main(String[] args){
		
		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter the number of jobs that will be scheduled: ");
		numJobs = stdin.nextInt();
		
		try{

			String f = ("C\\Users\\Maxwell\\Desktop\\inputfile.txt");
			FileReader file = new FileReader(f);
			BufferedReader br = new BufferedReader(file);
			Scanner s = new Scanner(br);

			while(s.hasNextInt()){
				int i = 0;
				startTime[i] = s.next();
				finishTime[i] = s.next();
				weight[i] = s.next();
				i++;
			}

		}
		catch(FileNotFoundException ex) {
			System.out.println("FNF error");
		}
		catch(IOException ex){
			System.out.println("IO error");
		}
		
		for(int x = 0; x<numJobs; x++){     //parses and copies the old arrays to integer arrays
			sTime[x]    = Integer.parseInt(startTime[x]);
			fTime[x]    = Integer.parseInt(finishTime[x]);
			value[x]    = Integer.parseInt(weight[x]);
		}
		
		
		Arrays.sort(fTime); 				//sorts the jobs by finish time
		
		for(int m = 1; m<numJobs; m++){		//fills the output array with 0's
			M[m] = 0;
		}
		
		computeOpt(numJobs);
		findSolution(numJobs);
		for(int i = 0; i<numJobs; i++){
			optimumValue = Math.max(M[i], M[i-1]);
		}		
		for(int i = 0; i<numJobs; i++){
			bestIntervals = M[numJobs];
		}		
		
		
		System.out.println("Optimum value: " + optimumValue);
		System.out.println("Interval sequences: " + bestIntervals);
		System.exit(0);
		
	}	
	public static int[] pJobs(int[] p){	
		for(int k= 0; k<numJobs; k++){				//computes possible jobs
			if(sTime[k] >= fTime[k-1]){
				p[k]++;
			}
		}
		return p;
	}
	public static int computeOpt(int job){ //main recursion loop
			if(M[job] == 0)
				M[job] = Math.max(value[job] + computeOpt(pJobs(job)), computeOpt(job-1));
			return M[job];
		}

	public static int findSolution(int job){
		if (job == 0)
			return 0;
		else if (value[job] + computeOpt[pJobs[job]] >= computeOpt[job-1]);
			return job;
			findSolution(possibleJobs[job]);
		
		findSolution(job-1);
	}
	
}


