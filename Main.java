import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		TaskSet t = TaskSet("MyTasks");
		  boolean exit = false;
		  boolean update = true;

		  while(!exit){

		    if (update) { Runtime.getRuntime().exec("cls"); }
		    else        { update = true;  }
		    System.out.println("Displaying" + t.getName() + "\n\n");
		    t.displayTasks();

		    System.out.println("type 'help' for a list of actions\n");

		    int size = 13;
		    String[] commands = {"help", "add", "remove", "complete", "info", "date", "priority", "load", "save", "name", "quit", "removeAll", "removeThese", "completeThese"};

		    int cmd = -1;
		    while(true) {
		    	System.out.println("Action: ");
		      String inp = scan.next();

		      for (int i = 0; i < size; i++) {
		        if (inp == commands[i]) { cmd = i; break;}
		      }

		      if (cmd == 10)     { exit = true; break; }
		      else if (cmd != -1) { break; }
		      else           { System.out.println("Please enter a valid action..."); }
		    }

		    System.out.println("\n");

		    if (!exit) {
		      switch (cmd) {
		        case 0:
		          System.out.println("\nhelp, add, remove, complete, info, date, priority, import, export, name, quit, removeAll, removeThese, completeThese\n\n");
		               update = false;
		          break;
		        case 1:
		          t.addTask();
		          break;
		        case 2:
		          t.removeTask();
		          break;
		        case 3:
		          t.toggleComplete();
		          break;
		        case 4:
		          t.changeInfo();
		          break;
		        case 5:
		          t.changeDate();
		          break;
		        case 6:
		          t.setPriority();
		          break;
		        case 7:
		          t.load();
		          update = false;
		          break;
		        case 8:
		          t.save();
		          break;
		        case 9:
		          t.changeName();
		          break;
		        case 10:
		          break; // quit
		        case 11:
		          t.removeAll();
		          break;
		        case 12:
		          t.removeThese();
		          break;
		        case 13:
		          t.completeThese();
		          break;
		        default:
		          System.out.println("Please enter a valid action...");
		      }
		    }

		  }

	}

}
