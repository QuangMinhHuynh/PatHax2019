#include "tasks.h"

TaskSet::TaskSet(string name) : _name(name) {}
TaskSet::TaskSet() {}
TaskSet::~TaskSet() {}

void TaskSet::addTask() {
  string info;
  string date;
  int priority;

  cout << "Description: ";
  cin >> info;
  cout << "Date: ";
  cin >> date;
  cout << "priority: ";
  cin >> priority;
  cout << endl;

  Task temp;
  temp._info = info;
  temp._date = date;
  temp._priority = priority;

  tasks.push_back(temp);
}
void TaskSet::removeTask() {
  // "assign" ids by vec index (don't actually assign)
  int id;
  cout << "ID of task to remove: ";
  cin >> id;
  tasks.erase(tasks.begin()+id);
}

void TaskSet::toggleComplete() {
  int id;
  cout << "ID of task to complete: ";
  cin >> id;
  if(tasks[id]._complete) { tasks[id]._complete = 0; }
  else                    { tasks[id]._complete = 1; }
  cout << endl;
}
void TaskSet::changeInfo() {
  int id;
  string info;
  cout << "ID of task to change description: ";
  cin >> id;
  cout << "New description: ";
  cin >> info;
  tasks[id]._info = info;
  cout << endl;
}
void TaskSet::changeDate() {
  int id;
  string date;
  cout << "ID of task to change date: ";
  cin >> id;
  cout << "New date: ";
  cin >> date;
  tasks[id]._date = date;
  cout << endl;
}
void TaskSet::setPriority() {
  int id, priority;
  cout << "ID of task to set priority: ";
  cin >> id;
  cout << "New priority: ";
  cin >> priority;
  tasks[id]._priority = priority;
  cout << endl;
}

void TaskSet::displayTasks() {
  cout << "Done " << "Description " << "Date " << "Priority " << "ID" << endl;
  cout << "-------------------------------------" << endl;
  for (int i = tasks.size() - 1; i >= 0; i--) {
    cout << tasks[i]._complete << " " << tasks[i]._info << " "
         << tasks[i]._date << " " << tasks[i]._priority  << " " << i
         << endl;
  }
  cout << endl;
}

void TaskSet::importTasks() {

}
void TaskSet::exportTasks() {

}

void TaskSet::changeName() {
  string name;
  cout << "New name: ";
  cin >> name;
  _name = name;
  cout << endl;
}
string TaskSet::getName() {
  return _name;
}

void TaskSet::removeAll() {
  char inp;
  cout << "Are you sure you want to remove all tasks? (Y/N)" << endl;
  cin >> inp;

  if (inp == 'Y') { tasks.clear(); }
  else            { cout << "Cancelling..." << endl; }

}
void TaskSet::removeThese() {
  int id;
  vector<int> ids;

  cout << "IDs of tasks to remove (-1 to end): " << endl;
  while(true){
    cin >> id;
    if (id == -1) { break; }
    ids.push_back(id);
  }

  for (int i = 0; i < ids.size(); i++) {
    tasks.erase(tasks.begin()+ids[i]);
  }

}
void TaskSet::completeThese() {
  int id;
  vector<int> ids;
  cout << "IDs of tasks to complete (-1 to end): " << endl;
  while(true){
    cin >> id;
    if (id == -1) { break; }
    ids.push_back(id);
  }

  for (int i = 0; i < ids.size(); i++) {
    if(tasks[ids[i]]._complete) { tasks[ids[i]]._complete = 0; }
    else                    { tasks[ids[i]]._complete = 1; }
  }
  cout << endl;
}
