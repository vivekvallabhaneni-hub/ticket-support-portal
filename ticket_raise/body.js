const forminput = document.querySelector("#forminput");
const emailinput = document.querySelector("#emailinput");
const nameinput = document.querySelector("#nameinput");
const titleinput = document.querySelector("#titleinput");
const departmentinput = document.querySelector("#departmentinput");
const contentinput = document.querySelector("#contentinput");
const result = document.querySelector("#result");

const api = "http://localhost:8080/api/ticket/add";

forminput.addEventListener("submit", function (event) {
    event.preventDefault();

    const requestdata = {
        email: emailinput.value,
        fullname: nameinput.value,  
        title: titleinput.value,
        department: departmentinput.value,
        content: contentinput.value
    };

    fetch(api, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestdata)
    })
    .then(function (response) {
        if (!response.ok) {
            throw new Error("Failed to save ticket");
        }
        return response.text(); 
    })
    .then(function () {
        result.textContent = "Successfully saved data";
        result.style.color = "green";
        forminput.reset(); 
    })
    .catch(function (error) {
        result.textContent = "Error saving data";
        result.style.color = "red";
        console.error(error);
    });
});
