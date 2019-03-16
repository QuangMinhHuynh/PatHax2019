package pathax;

public class TaskDefinitions {
	
	public static void main(String[] args) {

		TaskSet::TaskSet(string name) : _name(name) {}
		TaskSet::TaskSet() {}

		void TaskSet::addTask() {
		  String info;
		  String date;
		  int priority;

		  System.out.println("Description: ");
		  String info = scan.next();
		  
		  System.out.println("Date: ");
		  String date = scan.next();
		  
		  System.out.println("Priority: ");
		  int priority = scan.nextInt();
		  
		  System.out.println("\n");

		  Task temp;
		  temp._info = info;
		  temp._date = date;
		  temp._priority = priority;

		  tasks.push_back(temp);
		}
		void TaskSet::addTask(boolean complete, String info, String date, int priority) {

		  Task temp;
		  temp._complete = complete;
		  temp._info = info;
		  temp._date = date;
		  temp._priority = priority;

		  tasks.push_back(temp);
		}
		void TaskSet::removeTask() {
		  // "assign" ids by vec index (don't actually assign)
		  System.out.println("ID of task to remove: ");
		  int id = scan.nextInt();
		  tasks.erase(tasks.begin()+id);
		}

		void TaskSet::toggleComplete() {
		  System.out.println("ID of task to complete: ");
		  int id = scan.nextInt();
		  if(tasks[id]._complete) { tasks[id]._complete = 0; }
		  else                    { tasks[id]._complete = 1; }
		  System.out.println("\n");
		}
		void TaskSet::changeInfo() {
		  System.out.println("ID of task to change description: ");
		  int id = scan.nextInt();
		  
		  System.out.println("ID of task to complete: ");
		  int id = scan.nextInt();
		  System.out.println("New description: ");
		  String info = scan.next();

		  tasks[id]._info = info;
		  System.out.println("\n");
		}
		void TaskSet::changeDate() {
		  System.out.println("ID of task to change date: ");
		  int id = scan.nextInt();
		  System.out.println("New date: ");
		  String date = scan.next();

		  tasks[id]._date = date;
		  System.out.println("\n");
		}
		void TaskSet::setPriority() {
		  System.out.println("ID of task to set priority: ");
		  int id = scan.nextInt();
	  	  System.out.println("New priority: ");
	 	  String date = scan.next();
	 	  
		  tasks[id]._priority = priority;
		  System.out.println("\n");
		}

		void TaskSet::displayTasks() {
		  System.out.println("ID of task to set priority: ");
		  System.out.println("Done Description Date Priority ID\n");
		  System.out.println("-------------------------------------\n");
		  for (int i = tasks.size() - 1; i >= 0; i--) {
			System.out.println(tasks[i]._complete + " " + tasks[i]._info + " " + tasks[i]._date + " " + tasks[i]._priority + " " + i);
		  }
		  System.out.println("\n");
		}

		void TaskSet::load() {
		  bool complete;
		  string info, date;
		  int priority;

		  string filename = "saveFile.txt";
		  ifstream fi(filename);
		  removeAll();
		  while(!fi.eof()) {
		    fi >> complete >> info >> date >> priority;
		    addTask(complete, info, date, priority);
		  }
		  fi.close();
		  tasks.pop_back();
		}
		void TaskSet::save() {
		  string filename = "saveFile.txt";
		  ofstream fo(filename);
		  for (int i = 0; i < tasks.size(); i++) {
		    fo << tasks[i]._complete << " " << tasks[i]._info << " "
		         << tasks[i]._date << " " << tasks[i]._priority << endl;
		    fo.close();
		  }
		  System.out.println("Saved\n");
		}

		void TaskSet::changeName() {
		  System.out.println("New name: ");
		  String name = scan.next();
		  _name = name;
		  System.out.println("\n");
		}

		void TaskSet::removeAll() {
		  System.out.println("Do you want to remove all tasks? (Y/N)\n");
		  char inp = scan.nextChar();

		  if (inp == 'Y') { tasks.clear(); }
		  else            { System.out.println("Cancelling...\n"); }

		}
		void TaskSet::removeThese() {
		  vector<int> ids;
		  
		  System.out.println("IDs of tasks to remove (-1 to end): \n");
		  while(true){
			int id = scan.nextInt();
		    if (id == -1) { break; }
		    ids.push_back(id);
		  }

		  for (int i = 0; i < ids.size(); i++) {
		    tasks.erase(tasks.begin()+ids[i]);
		  }

		}
		void TaskSet::completeThese() {
		  vector<int> ids;
		  System.out.println("IDs of tasks to complete (-1 to end): \n");
		  while(true){
			int id = scan.nextInt();
		    if (id == -1) { break; }
		    ids.push_back(id);
		  }

		  for (int i = 0; i < ids.size(); i++) {
		    if(tasks[ids[i]]._complete) { tasks[ids[i]]._complete = 0; }
		    else                    { tasks[ids[i]]._complete = 1; }
		  }
		  System.out.println("\n");
		}

		
	}
}
