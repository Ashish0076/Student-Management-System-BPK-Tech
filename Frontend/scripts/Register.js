// API URL
const apiUrl = "https://student-management-system-production-b5db.up.railway.app/student";


//Add Student
document.addEventListener("DOMContentLoaded", function () {
  const form = document.querySelector("form");

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const studentData = {
      "firstName": document.getElementById("firstname").value,
      "lastName": document.getElementById("lastname").value,
      "phoneNo": document.getElementById("phone").value,
      "Course": document.getElementById("course").value,
      "gender": document.getElementById("gender").value,
      "Address": document.getElementById("address").value,
      "enrollmentDate": document.getElementById("enrollmentDate").value
    };
    console.log(studentData);

    fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(studentData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Success:", data);
        alert("Student added successfully! Please check dashboard");
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("Error while adding student");
      });
  });
});

