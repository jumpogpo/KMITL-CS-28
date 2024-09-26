#include <iostream>
#include <string>
using namespace std;

class Staff {
    private:
        int id;
        string name;
    public:
        Staff() {

        }

        Staff(int anId, string aName) {
            id = anId;
            name = aName;
        }

        int getId() {
            return id;
        }

        string getName() {
            return name;
        }

        void setId(int anId) {
            id = anId;
        }

        void setName(string aName) {
            name = aName;
        }
};

class Department {
    private:
        int maxStaff;
        int numStaff;
        int deptId;
        string deptName;
        Staff *staff;
    public: 
        Department(int anId, string aName, int aMaxStaff) {
            deptId = anId;
            deptName = aName;
            maxStaff = aMaxStaff;
            staff = new Staff[maxStaff];
            numStaff = 0;         
        }

        ~Department() {
            delete [] staff;
        }

        int getDeptId() {
            return deptId;
        }

        string getDeptName() {
            return deptName;
        }

        void setEachStaff(Staff aStaff) {
            if (numStaff >= maxStaff) {
                cout << "number of staff members cannot higher than " << maxStaff << endl;
                exit(1); 
            }
            staff[numStaff++] = aStaff;
        }
        
        void printAllStaff() {
            cout << "Dept ID: " << deptId << " Dept Name: " << deptName << endl;
            for (int i =0; i < numStaff; i++) {
                cout << "Staff Id: " << staff[i].getId() << " Staff Name: " << staff[i].getName() << endl;
            }
        }

};

// This function uses pass by value, which creates a copy of the Department object.
// Copying the object might cause issues with the original pointer, leading to pointer corruption.
/*
void print(Department dept) {
    dept.printAllStaff();
}
*/

// Changed to pass by reference to avoid copying the object.
// This allows us to work directly with the original object and avoid pointer-related issues.
void print(Department &dept) { dept.printAllStaff(); }

int main() {
    Department department(1, "HR", 5);
    Staff dan(1, "Dan");
    Staff john(2, "John");
    department.setEachStaff(dan);
    department.setEachStaff(john);
    print(department);
    Staff marry(3, "Marry");
    department.setEachStaff(marry);
    print(department);   
}