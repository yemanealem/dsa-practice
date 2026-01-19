public class CountStudents {

    // Method to count students unable to eat
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;

        // Students as a circular queue
        int[] queue = new int[n];
        for (int i = 0; i < n; i++) queue[i] = students[i];
        int front = 0;
        int size = n; // number of students in queue

        // Sandwiches as a stack
        int[] stack = new int[n];
        for (int i = 0; i < n; i++) stack[i] = sandwiches[i];
        int top = 0; // index of next sandwich

        int rotations = 0;

        while (size > 0 && rotations < size) {
            if (queue[front] == stack[top]) {
                // student eats
                front = (front + 1) % n;
                top++;
                size--;
                rotations = 0; // reset rotations
            } else {
                // move student to the end
                queue[(front + size) % n] = queue[front];
                front = (front + 1) % n;
                rotations++;
            }
        }

        return size; // students unable to eat
    }

    // Main method for testing
    public static void main(String[] args) {
        CountStudents cs = new CountStudents();

        // Test case 1
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        System.out.println("Students unable to eat: " + cs.countStudents(students1, sandwiches1));
        // Expected output: 0

        // Test case 2
        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
        System.out.println("Students unable to eat: " + cs.countStudents(students2, sandwiches2));
        // Expected output: 3
    }
}


/*

Step 1: Problem Understanding

We have students who are in a queue. Each student prefers either:

0 → circular sandwich

1 → square sandwich

We have sandwiches in a stack (top first).

Students go in order:

If the student at the front likes the top sandwich, they eat it.

If not, they go to the end of the queue.

Stop when no student wants the top sandwich.

Return the number of students who cannot eat.

Step 2: Data Structures

Since we cannot use built-in Queue or Stack:

Students → circular queue (array + front pointer + size counter)

Sandwiches → stack (array + top pointer)

Step 3: Initialize Arrays
int[] queue = new int[n];   // store students
for (int i = 0; i < n; i++) queue[i] = students[i];

int[] stack = new int[n];   // store sandwiches
for (int i = 0; i < n; i++) stack[i] = sandwiches[i];

int front = 0;  // front index of queue
int size = n;   // number of students in queue
int top = 0;    // index of top sandwich


queue keeps the students in order.

stack keeps sandwiches in order (top = stack[top]).

front points to the first student.

size tracks how many students are left in the queue.

top points to the next sandwich.

Step 4: Rotate Students

We use a rotations counter:

int rotations = 0;
while (size > 0 && rotations < size) {


Each time a student cannot eat, we move them to the end → counts as one rotation.

If rotations reaches size, it means no student wants the current sandwich, so we stop.

Step 5: Check Each Student
if (queue[front] == stack[top]) {
    front = (front + 1) % n;  // student leaves queue
    top++;                     // remove sandwich
    size--;                    // one less student
    rotations = 0;             // reset rotation
} else {
    queue[(front + size) % n] = queue[front];  // move student to end
    front = (front + 1) % n;                   // move front
    rotations++;                                // increment rotations
}


Case 1: Student eats

The student at front likes the sandwich.

Move front to next student (front + 1) % n.

Increment top → sandwich taken.

Decrease size → one student gone.

Reset rotations → new cycle starts.

Case 2: Student does NOT eat

Move student to “end” of queue → queue[(front + size) % n].

Increment front → next student comes to front.

Increment rotations → track how many students have been skipped in this round.

Step 6: Stop Condition
while (size > 0 && rotations < size)


If size == 0 → all students ate → stop.

If rotations == size → nobody wants the current sandwich → stop.

Step 7: Return Result
return size;  // students unable to eat


size now contains the number of students left in the queue who could not eat.

Step 8: Example Walkthrough

Example:

students = [1, 1, 0, 0]
sandwiches = [0, 1, 0, 1]


Step by step:

Student 1 vs sandwich 0 → cannot eat → move to end → rotations = 1

Student 1 vs sandwich 0 → cannot eat → move to end → rotations = 2

Student 0 vs sandwich 0 → eats → remove both → rotations = 0

Student 0 vs sandwich 1 → cannot eat → move to end → rotations = 1

Student 1 vs sandwich 1 → eats → remove both → rotations = 0

Student 1 vs sandwich 0 → cannot eat → move to end → rotations = 1

Student 0 vs sandwich 0 → eats → remove both → rotations = 0

Queue empty → 0 students unable to eat ✅



*/