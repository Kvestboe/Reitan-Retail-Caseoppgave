
element = document.getElementById("filters");
toggleButton = document.getElementById("filter-button");

toggleButton.addEventListener("click", () => {
    element.classList.toggle("visible");
});


document.addEventListener('DOMContentLoaded', () => {
    const buttons = document.querySelectorAll('.toggle-button');

    buttons.forEach(button => {
        // Set initial background color based on data-color-off
        button.style.setProperty('--color-off', button.dataset.colorOff);
        button.style.setProperty('--color-on', button.dataset.colorOn);
        button.style.backgroundColor = button.dataset.colorOff;

        button.addEventListener('click', () => {
        // Toggle the 'active' class
        button.classList.toggle('active');

        // Update background color based on active state
        if (button.classList.contains('active')) {
            button.style.backgroundColor = button.dataset.colorOn;
        } else {
            button.style.backgroundColor = button.dataset.colorOff;
        }
        });
    });
});

// const activeFilters = document.querySelectorAll('p.active');

// // Extract the text content of each and store it in an array
// const activeTexts = Array.from(activeFilters).map(p => p.textContent.trim());

async function searchProducts() {
    const keyword = document.getElementById("searchBox").value;
    const activeFilterTexts = Array.from(document.querySelectorAll('#filters p.active')).map(p => p.textContent.trim());
    
    const query = new URLSearchParams({ keyword, activeFilterTexts: filters.join(",")});
    const response = await fetch("http://localhost:8080/search?" + query);
    const products = await response.json();

    document.getElementById("results").innerHTML = products.map(p => `<p>${p.name}</p>`).join("");

}
