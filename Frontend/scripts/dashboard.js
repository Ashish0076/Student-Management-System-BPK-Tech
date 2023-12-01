document.addEventListener("DOMContentLoaded", function () {
    const tbody = document.getElementById("tbody");

    // Fetch data and populate the table
    fetch("https://student-management-system-production-b5db.up.railway.app/student")
        .then((response) => response.json())
        .then((data) => {
            if (data.length <= 0) {
                alert("No Data Avaliable");
            } else {
                data.forEach((student) => {
                    const row = createTableRow(student);
                    tbody.appendChild(row);
                });
            }
        })
        .catch((error) => {
            console.error("Error fetching data:", error);
        });

    // Function to create a table row for a student
    function createTableRow(student) {

        const row = document.createElement("tr");

        const columns = [
            "id",
            "firstName",
            "lastName",
            "phoneNo",
            "gender",
            "Course",
            "Address",
            "enrollmentDate"
        ];

        columns.forEach((column) => {
            const cell = document.createElement("td");
            cell.textContent = student[column];
            row.appendChild(cell);
        });

        // Edit button
        const editCell = document.createElement("td");
        const editButton = document.createElement("button");
        editButton.textContent = "Edit";
        editButton.addEventListener("click", () => editStudent(student.id));
        editCell.appendChild(editButton);
        row.appendChild(editCell);

        // Delete button
        const deleteCell = document.createElement("td");
        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.addEventListener("click", () => deleteStudent(student.id));
        deleteCell.appendChild(deleteButton);
        row.appendChild(deleteCell);

        return row;
    }

    // Function to edit a student
    function editStudent(studentId) {
        const apiUrl = `https://student-management-system-production-b5db.up.railway.app/student/${studentId}`;

        let student;
        fetch(apiUrl, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((data) => {
                student=data;
                alert("Edit funcationality in not completed");
            })
            .catch((error) => {
                alert("Unable to edit the Student Data");
            });
    }

    // Function to delete a student
    function deleteStudent(studentId) {

        const apiUrl = `https://student-management-system-production-b5db.up.railway.app/student/${studentId}`;

        fetch(apiUrl, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((data) => {
                alert("Student Data Deleted Successfully");
                window.location.reload();
            })
            .catch((error) => {
                alert("Unable to delete the Student Data");
            });
    }
});

