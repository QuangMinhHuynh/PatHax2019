package pathax;

public class TaskSet {

	protected Task[] tasks;
	  //vector<Task> tasks;
	  protected String _name = "";

	  TaskSet(String name) {}
	  TaskSet() {}

	  void addTask() {}
	  void addTask(boolean complete, String info, String date, int priority) {}
	  void removeTask() {}

	  void toggleComplete() {}
	  void changeInfo() {}
	  void changeDate() {}
	  void setPriority() {}

	  void displayTasks() {}

	  void load() {}
	  void save() {}

	  void changeName() {}
	  String getName() { return _name; }

	  void removeAll() {}
	  void removeThese() {}
	  void completeThese() {}
	
	public static void main(String[] args) {

		


	}

}
