// darkmode.js

document.addEventListener('DOMContentLoaded', function () {
  const body = document.body;
  const toggleBtn = document.getElementById('toggle-btn');
  const darkModeStorageKey = 'dark-mode';

  // Check the user's preference from local storage
  const isDarkMode = localStorage.getItem(darkModeStorageKey) === 'true';

  // Apply dark mode based on the user's preference
  if (isDarkMode) {
    body.classList.add('dark-mode');
  }

  // Toggle dark mode on button click
  toggleBtn.addEventListener('click', function () {
    body.classList.toggle('dark-mode');

    // Update the user's preference in local storage
    const newDarkModeState = body.classList.contains('dark-mode');
    localStorage.setItem(darkModeStorageKey, newDarkModeState.toString());
  });
});
