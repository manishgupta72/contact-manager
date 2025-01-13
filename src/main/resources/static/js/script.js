console.log("script loaded");

let currentTheme = getTheme();
changeTheme(currentTheme);

function changeTheme(theme) {
  document.querySelector("html").classList.add(theme);

  let changeThemeButton = document.querySelector("#theme_change_button");
  changeThemeButton.querySelector("span").innerText =
    theme === "light" ? "Dark" : "Light";
  changeThemeButton.addEventListener("click", () => {
    document.querySelector("html").classList.remove(theme);
    theme = theme === "light" ? "dark" : "light";
    setTheme(theme);
    document.querySelector("html").classList.add(theme);
    changeThemeButton.querySelector("span").innerText =
      theme === "light" ? "Dark" : "Light";
  });
}

function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

function getTheme() {
  return localStorage.getItem("theme") || "light";
}
