const generateBtn = document.getElementById("generateBtn");
const keywordInput = document.getElementById("keyword");
const shayariContainer = document.getElementById("shayariContainer");
const loader = document.getElementById("loader");

generateBtn.addEventListener("click", async () => {
  const prompt = keywordInput.value;

  showLoader();
  // Send a POST request to the backend API
  const response = await fetch(
    `http://localhost:8080/chat?prompt=${prompt}`
  );
  hideLoader();

  const data = await response.json();

  // Display the generated Shayari on the page
  shayariContainer.textContent = data.shayari;
});

function showLoader() {
  loader.style.display = "block";
}

function hideLoader() {
  loader.style.display = "none";
}