console.log("Script Loaded")

let currentTheme = getTheme();
console.log(getTheme());

document.addEventListener('DOMContentLoaded', () =>{
    changeTheme();

});


function changeTheme(){

    changePageTheme(currentTheme,currentTheme);

    
    const changeThemeButton = document.querySelector("#button_theam_change");

    const oldTheme = currentTheme;


    changeThemeButton.addEventListener("click", () => {

        console.log("change theme button clicked");

        if(currentTheme === "dark"){

            currentTheme = "light";

        }else{
            currentTheme = "dark";
        }

        changePageTheme(currentTheme,oldTheme);

    });
}

function setTheme(theme){
    localStorage.setItem("theme",theme);

}

function getTheme(){

    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";

}

function changePageTheme(theme,oldTheme){
    setTheme(currentTheme);

    document.querySelector("html").classList.remove(oldTheme);

    document.querySelector("html").classList.add(theme);

    document
            .querySelector("#button_theam_change");
            document.querySelector("#mode").textContent = theme == "light" ? "Dark" : "Light";
}