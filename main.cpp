#include <iostream>
#include "tasks.h"

using namespace std;

int main() {

  TaskSet t = TaskSet("MyTasks");
  bool exit = 0;
  bool update = 1;

  while(!exit){

    if (update) { system("clear"); }
    else        { update = 1;  }
    cout << "Displaying " << t.getName() << endl << endl;
    t.displayTasks();

    cout << "type 'help' for a list of actions" << endl;

    //string inp;

    int size = 14;
    string commands [size] = {"help", "add", "remove", "complete", "info", "date", "priority", "import", "export", "name", "quit", "removeAll", "removeThese", "completeThese"};

    int cmd = -1;
    string inp;
    while(true) {
      cout << "Action: ";
      cin >> inp;

      for (int i = 0; i < size; i++) {
        if (inp == commands[i]) { cmd = i; break;}
      }

      if (cmd == 10)     { exit = 1; break; }
      else if (cmd != -1) { break; }
      else           { cout << "Please enter a valid action..." << endl; }
    }

    cout << endl;

    if (!exit) {
      switch (cmd) {
        case 0:
          cout << "\nhelp, " << "add, " << "remove, " << "complete, "
               << "info, " << "date, " << "priority, " << "import, "
               << "export, " << "name, " << "quit, " << "removeAll, "
               << "removeThese, " << "completeThese\n\n";
               update = 0;
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
          t.importTasks();
          break;
        case 8:
          t.exportTasks();
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
          cout << "Please enter a valid action..." << endl;
      }
    }

  }

  return 0;
}
