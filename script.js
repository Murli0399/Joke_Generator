const generateBtn = document.getElementById("generateBtn");
const keywordInput = document.getElementById("keyword");
const shayariContainer = document.getElementById("shayariContainer");
const loader = document.getElementById("loader");

generateBtn.addEventListener("click", async () => {
  const prompt = keywordInput.value;

  showLoader();
  const response = await fetch(
    `http://localhost:8080/chat?prompt=${prompt}`
  );
  hideLoader();

  const data = await response;

  shayariContainer.textContent = data;
});

function showLoader() {
  loader.style.display = "block";
}

function hideLoader() {
  loader.style.display = "none";
}