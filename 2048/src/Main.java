import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
int check = 0;
	int[][]cells;
int MASS_LENGTH=4;	
int x1,x2,y1,y2;
ArrayList<Integer> rowArray;
Deque<Integer> deque;
public static void main(String[] args) {
	Main mn = new Main();

	}
Main(){
initMass();	
	
	
}
public void initMass(){
	cells = new int[MASS_LENGTH][MASS_LENGTH];
	 x1 = (int)(Math.random()*3);
	 y1 = (int)(Math.random()*3);
	
	
	 x2 = (int)(Math.random()*3);
	 y2 = (int)(Math.random()*3);
	
	while(x1==x2&&y1==y2){
		 x2 = (int)(Math.random()*3);
		 y2 = (int)(Math.random()*3);	
		
	}
	
	
	log(""+x1+"/");
	log(""+y1+"//");
	
	log(""+x2+"/");
	log(""+y2);
	
	logn("");
	
	cells[x1][y1]=2;
	cells[x2][y2]=2;
	
	logMass(cells);
	
	shiftCells("RIGHT");
	generateCell();
	logMass(cells);
	shiftCells("LEFT");
	
}

public void shiftCells(String direction){//передача направления
	
	
	
	if(direction.equals("LEFT")||direction.equals("RIGHT")){//
		
		for(int i=0;i<MASS_LENGTH;i++){//цикл обрабатывающий последовательно каждую строку массива cells
			 rowArray = new ArrayList<Integer>();//список элементов строки
			for(int j = 0;j<MASS_LENGTH;j++){//
				if(cells[i][j]!=0){
				rowArray.add(cells[i][j]);//заполнение списка элементами данной строки, которые не являются нулями
				}
				
				}
			//logn(rowArray.toString());
			if(direction.equals("LEFT")&&rowArray.size()>=2){
				shiftRow("left");
				logn(rowArray.toString()+"/");
			for(int g = 0;g<MASS_LENGTH;g++){
			cells[i][g]	=rowArray.get(g);
				
				
			}
			
			
			}
			else{
				if(direction.equals("RIGHT")&&rowArray.size()>=2){
				shiftRow("right");
				logn(deque.toString()+"//");
				for(int g = 0;g<MASS_LENGTH;g++){
					cells[i][g]	=deque.getFirst();
					deque.removeFirst();
						
						
					}
			}
			else{
				if(direction.equals("LEFT")){
				
					while(rowArray.size()!=4){
					rowArray.add(0);
					
					
				}
					logn(rowArray.toString()+"///");
					for(int g = 0;g<MASS_LENGTH;g++){
						cells[i][g]	=rowArray.get(g);
							
							
						}
				
				}
				else{
					 deque = new LinkedList<Integer>();
					 deque.addAll(rowArray);
					 
					
					
					
					for(int k = 0;k<(4-rowArray.size());k++){
						deque.addFirst(0);        // O(1)
						 
						
					}
					
					logn(deque.toString()+"///");	
					
					for(int g = 0;g<MASS_LENGTH;g++){
						cells[i][g]	=deque.getFirst();
						deque.removeFirst();
							
							
						}
					deque.clear();
					
				}
				
			}
		}
			
			if(rowArray!=null){
			rowArray.clear();}
			if(deque!=null){
			deque.clear();}
		}
		
		
		
	}
	
	
	
	
	
	
}

public void shiftRow(String align){
	if(align.equals("left")){
	//check();
		if(rowArray.get(0)==rowArray.get(1)){
			rowArray.set(0, rowArray.get(0)*2);
			rowArray.set(1, 0);
			for(int i = 0;i<rowArray.size();i++){
				if(rowArray.get(i)==0){
					rowArray.remove(i);
					
				}
				
			}
		
		}
		while(rowArray.size()!=4){
			rowArray.add(0);
			
			
		}
	}
	else{
		
		
		
		int a = rowArray.size();
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = a-1;i>=0;i--){
			temp.add(rowArray.get(i));
			
		}
		rowArray = temp;
		//logn(rowArray.toString()+" reverse");
		if(rowArray.get(0)==rowArray.get(1)){
			rowArray.set(0, rowArray.get(0)*2);
			rowArray.set(1, 0);
			for(int i = 0;i<rowArray.size();i++){
				if(rowArray.get(i)==0){
					rowArray.remove(i);
					
				}
				
			}
		
		}	
		//logn(rowArray.toString()+" reverse --0");
		
		deque = new LinkedList<Integer>();
		 deque.addAll(rowArray);
		 
		
		
		
		for(int k = 0;k<(4-rowArray.size());k++){
			deque.addFirst(0);        // O(1)
			 
			
		}
		
		
	}
	
}


public void generateCell(){
	x1 = (int)(Math.random()*3);
	 y1 = (int)(Math.random()*3);
	
	while(cells[x1][y1]!=0){
		x1 = (int)(Math.random()*3);
		 y1 = (int)(Math.random()*3);
		
	}
	cells[x1][y1] = 2;
	
}




public void check(){
	
	logn("check "+check);
	check++;
	
	
}




	public void log(String message){
		
		System.out.print(""+message);
	
	}

public void logn(String message){
		
		System.out.println(""+message);
	
	}
	
	public void logMass(int[][]mass){
		for(int i = 0;i<MASS_LENGTH;i++){
			
			for(int j = 0;j<MASS_LENGTH;j++){
				log(""+mass[i][j]);
				
				
			}
			System.out.println("");
			
		}
		
		
	}	

}
