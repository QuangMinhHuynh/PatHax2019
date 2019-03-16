#ifndef __tasks_h__
#define __tasks_h__

#include <iostream>
#include <string>
#include <vector>
#include <fstream>

using namespace std;

struct Task {
  string _info = "";
  string _date = "";
  bool _complete = 0;
  int _priority = 0;
};

class TaskSet {
protected:
  vector<Task> tasks;
  string _name = "";

public:
  TaskSet(string name);
  TaskSet();
  ~TaskSet();

  void addTask();
  void removeTask();

  void toggleComplete();
  void changeInfo();
  void changeDate();
  void setPriority();

  void displayTasks();

  void importTasks();
  void exportTasks();

  void changeName();
  string getName();

  // clear all tasks
  // delete list of ids
  // complete list of ids


};

#endif
