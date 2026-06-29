// ProjectTwo.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include <algorithm>
#include <cctype>

using namespace std;

// =============================================================
// COURSE STRUCTURE
// Represents a single course with number, title, and prerequisites
// =============================================================
struct Course {
    string number;
    string title;
    vector<string> prerequisites;
};

// =============================================================
// HASH TABLE CLASS
// Stores all courses using separate chaining for collisions
// =============================================================
class HashTable {
private:
    static const unsigned int TABLE_SIZE = 179; // Prime number for good distribution
    vector<Course> table[TABLE_SIZE];

    // Hash function for course numbers
    unsigned int hashFunction(const string& key) const {
        unsigned int hash = 0;
        for (char c : key) {
            hash = hash * 31 + c;
        }
        return hash % TABLE_SIZE;
    }

public:

    // Insert a course into the hash table (no duplicates)
    void insert(const Course& course) {
        unsigned int index = hashFunction(course.number);

        // Prevent duplicate insertion
        for (const auto& c : table[index]) {
            if (c.number == course.number) {
                return;
            }
        }

        table[index].push_back(course);
    }

    // Search for a course by number
    Course* search(const string& courseNumber) {
        unsigned int index = hashFunction(courseNumber);
        for (auto& c : table[index]) {
            if (c.number == courseNumber) {
                return &c;
            }
        }
        return nullptr;
    }

    // Return all courses for sorting
    vector<Course> getAllCourses() const {
        vector<Course> all;
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (const auto& c : table[i]) {
                all.push_back(c);
            }
        }
        return all;
    }
};

// =============================================================
// TRIM FUNCTION — Removes whitespace from user input
// =============================================================
string trim(const string& s) {
    size_t start = s.find_first_not_of(" \t\n\r");
    size_t end = s.find_last_not_of(" \t\n\r");
    if (start == string::npos) return "";
    return s.substr(start, end - start + 1);
}

// =============================================================
// LOAD COURSES FROM FILE — Two-pass validation
// =============================================================
bool loadCoursesFromFile(const string& filename, HashTable& courseTable) {
    ifstream file(filename);
    if (!file.is_open()) {
        cout << "Error: Unable to open file." << endl << endl;
        return false;
    }

    vector<string> courseNumbers;
    string line;

    // FIRST PASS — Collect all course numbers
    while (getline(file, line)) {
        stringstream ss(line);
        string number;
        getline(ss, number, ',');

        number = trim(number);

        if (number.empty()) {
            cout << "Error: Invalid line format." << endl << endl;
            return false;
        }

        courseNumbers.push_back(number);
    }

    // Reset file pointer
    file.clear();
    file.seekg(0);

    // SECOND PASS — Build course objects
    while (getline(file, line)) {
        stringstream ss(line);
        string number, title, prereq;

        getline(ss, number, ',');
        getline(ss, title, ',');

        number = trim(number);
        title = trim(title);

        Course course;
        course.number = number;
        course.title = title;

        // Read prerequisites
        while (getline(ss, prereq, ',')) {
            prereq = trim(prereq);
            if (!prereq.empty()) {

                // Validate prerequisite exists
                if (find(courseNumbers.begin(), courseNumbers.end(), prereq) == courseNumbers.end()) {
                    cout << "Warning: Prerequisite " << prereq
                        << " does not exist in file. Skipping it." << endl;
                    continue;
                }

                course.prerequisites.push_back(prereq);
            }
        }

        courseTable.insert(course);
    }

    file.close();
    return true;
}

// =============================================================
// PRINT COURSE LIST — Sorted to match sample output
// =============================================================
void printCourseList(const HashTable& courseTable) {
    vector<Course> all = courseTable.getAllCourses();

    // Custom sort: CSCI courses first, then MATH, then others
    sort(all.begin(), all.end(), [](const Course& a, const Course& b) {
        string prefixA = a.number.substr(0, 4);
        string prefixB = b.number.substr(0, 4);

        if (prefixA != prefixB)
            return prefixA < prefixB;

        return a.number < b.number;
        });

    cout << "Here is a sample schedule:" << endl << endl;

    for (const auto& c : all) {
        cout << c.number << ", " << c.title << endl;
    }

    cout << endl;
}

// =============================================================
// PRINT COURSE INFORMATION — Includes prerequisite titles
// =============================================================
void printCourseInfo(HashTable& courseTable) {
    cout << "What course do you want to know about? ";
    string input;
    cin >> input;

    // Convert to uppercase
    for (auto& c : input) c = toupper(c);

    Course* course = courseTable.search(input);

    if (!course) {
        cout << "Course not found." << endl << endl;
        return;
    }

    cout << course->number << ", " << course->title << endl;

    if (course->prerequisites.empty()) {
        cout << "Prerequisites: None" << endl << endl;
    }
    else {
        cout << "Prerequisites: ";

        for (size_t i = 0; i < course->prerequisites.size(); i++) {
            string prereqNum = course->prerequisites[i];
            Course* prereqCourse = courseTable.search(prereqNum);

            if (prereqCourse) {
                cout << prereqCourse->number;
            }
            else {
                cout << prereqNum;
            }

            if (i < course->prerequisites.size() - 1)
                cout << ", ";
        }

        cout << endl << endl;
    }
}

// =============================================================
// MAIN MENU LOOP
// =============================================================
int main() {
    HashTable courseTable;
    bool dataLoaded = false;

    cout << "Welcome to the course planner." << endl << endl;

    int choice = 0;

    while (choice != 9) {
        cout << "1. Load Data Structure." << endl;
        cout << "2. Print Course List." << endl;
        cout << "3. Print Course." << endl;
        cout << "9. Exit" << endl << endl;

        cout << "What would you like to do? ";
        cin >> choice;
        cout << endl;

        switch (choice) {
        case 1: {
            string filename;
            cout << "Enter file name: ";
            cin >> filename;

            if (loadCoursesFromFile(filename, courseTable)) {
                dataLoaded = true;
                cout << "Data loaded successfully." << endl << endl;
            }
            break;
        }

        case 2:
            if (!dataLoaded)
                cout << "Please load the data structure first." << endl << endl;
            else
                printCourseList(courseTable);
            break;

        case 3:
            if (!dataLoaded)
                cout << "Please load the data structure first." << endl << endl;
            else
                printCourseInfo(courseTable);
            break;

        case 9:
            cout << "Thank you for using the course planner!" << endl;
            break;

        default:
            cout << choice << " is not a valid option." << endl << endl;
            break;
        }
    }

    return 0;
}
